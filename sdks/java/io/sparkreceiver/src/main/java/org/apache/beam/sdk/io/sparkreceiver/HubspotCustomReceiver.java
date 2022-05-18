package org.apache.beam.sdk.io.sparkreceiver;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.gson.JsonElement;
import io.cdap.plugin.hubspot.common.HubspotHelper;
import io.cdap.plugin.hubspot.common.HubspotPage;
import io.cdap.plugin.hubspot.common.SourceHubspotConfig;
import io.cdap.plugin.hubspot.source.streaming.HubspotReceiver;
import io.cdap.plugin.hubspot.source.streaming.HubspotStreamingSourceConfig;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.receiver.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("FutureReturnValueIgnored")
public class HubspotCustomReceiver extends Receiver<String> {

    private static final Logger LOG = LoggerFactory.getLogger(HubspotCustomReceiver.class);
    private static final String RECEIVER_THREAD_NAME = "hubspot_api_listener";
    private final HubspotStreamingSourceConfig config;
    private String startOffset = null;

    HubspotCustomReceiver(HubspotStreamingSourceConfig config) throws IOException {
        super(StorageLevel.MEMORY_AND_DISK_2());
        this.config = config;
    }

    public void setStartOffset(String startOffset) {
        this.startOffset = startOffset;
    }

    public HubspotStreamingSourceConfig getConfig() {
        return config;
    }

    public String getStartOffset() {
        return startOffset;
    }

    @Override
    public void onStart() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat(RECEIVER_THREAD_NAME + "-%d")
                .build();

        Executors.newSingleThreadExecutor(namedThreadFactory).submit(this::receive);
    }

    @Override
    public void onStop() {
        // There is nothing we can do here as the thread calling receive()
        // is designed to stop by itself if isStopped() returns false
    }

    private void receive() {
        try {
            HubspotPagesIterator hubspotPagesIterator = new HubspotPagesIterator(config, startOffset);

            while (!isStopped()) {
                if (hubspotPagesIterator.hasNext()) {
                    store(hubspotPagesIterator.next().toString());
                } else {
                    Integer minutesToSleep = config.getPullFrequency().getMinutesValue();
                    LOG.debug(String.format("Waiting for '%d' minutes to pull.", minutesToSleep));
                    Thread.sleep(TimeUnit.MINUTES.toMillis(1));

                    // reload current page
                    HubspotPage currentPage = new HubspotHelper().getHubspotPage(config,
                            hubspotPagesIterator.getCurrentPageOffset());
                    int iteratorPosition = hubspotPagesIterator.getIteratorPosition();

                    hubspotPagesIterator = new HubspotPagesIterator(config, currentPage,
                            hubspotPagesIterator.getCurrentPageOffset());
                    hubspotPagesIterator.setIteratorPosition(iteratorPosition);
                }
            }
        } catch (Exception e) {
            String errorMessage = "Exception while receiving messages from hubspot";
            // Since it's top level method of thread, we need to log the exception or it will be unseen
            LOG.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public static class HubspotPagesIterator implements Iterator<JsonElement> {
        private HubspotPage currentPage;
        private Iterator<JsonElement> currentPageIterator;
        private int iteratorPosition = 0;
        private String currentPageOffset;

        /**
         * Constructor for HubspotPagesIterator object.
         * @param config the source hub spot config
         * @param currentPage the current page
         * @param currentPageOffset the current page offset
         */
        public HubspotPagesIterator(SourceHubspotConfig config, HubspotPage currentPage,
                                    String currentPageOffset) {
            this.currentPage = currentPage;
            this.currentPageIterator = currentPage.getIterator();
            this.currentPageOffset = currentPageOffset;
        }

        public HubspotPagesIterator(SourceHubspotConfig config, String offset) throws IOException {
            this(config, new HubspotHelper().getHubspotPage(config, offset), offset);
        }

        /**
         * Here if require, it will be switched the page.
         * @throws IOException on issues with data reading
         */
        public void switchPageIfNeeded() throws IOException {
            if (!currentPageIterator.hasNext()) {
                // switch page
                HubspotPage nextPage = currentPage.nextPage();

                if (nextPage != null) {
                    iteratorPosition = 0;
                    currentPageOffset = currentPage.getOffset();
                    currentPage = nextPage;
                    currentPageIterator = currentPage.getIterator();
                } else {
                    currentPageIterator = null;
                }
            }
        }

        @Override
        public boolean hasNext() {
            try {
                switchPageIfNeeded();
            } catch (IOException e) {
                throw new RuntimeException("Failed to switch to next page", e);
            }
            return (currentPageIterator != null);
        }

        @Override
        public JsonElement next() {
            iteratorPosition++;
            return currentPageIterator.next();
        }

        public String getCurrentPageOffset() {
            return currentPageOffset;
        }

        public int getIteratorPosition() {
            return iteratorPosition;
        }

        /**
         * Here, just set the position of iteration.
         * @param iteratorPosition the iterator position
         */
        public void setIteratorPosition(int iteratorPosition) {
            this.currentPageIterator = currentPage.getIterator();

            for (int i = 0; i < iteratorPosition; i++) {
                if (currentPageIterator.hasNext()) {
                    next();
                } else {
                    break;
                }
            }
        }
    }

}
