package org.apache.beam.sdk.io.sparkreceiver;

import org.apache.beam.sdk.transforms.DoFn;

import java.util.ArrayList;
import java.util.List;

public class TestOutputDoFn extends DoFn<String, String> {
    private final static List<String> records = new ArrayList<>();

    @ProcessElement
    public void processElement(
            @Element String input, OutputReceiver<String> output) {
        records.add(input);
        output.output(input);
    }

    public List<String> getRecords() {
        return records;
    }
}
