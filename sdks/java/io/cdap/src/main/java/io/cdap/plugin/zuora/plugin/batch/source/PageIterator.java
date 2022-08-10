/*
 *  Copyright © 2020 Cask Data, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package io.cdap.plugin.zuora.plugin.batch.source;

import io.cdap.plugin.zuora.client.ZuoraRestClient;
import io.cdap.plugin.zuora.restobjects.ObjectInfo;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import io.cdap.plugin.zuora.restobjects.objects.BaseResult;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Iterates over ever object on every page.
 */
public class PageIterator {
  private final ObjectInfo objectInfo;
  private final Map<String, String> arguments;
  private final ZuoraRestClient client;

  private BaseResult<BaseObject> currentPage;
  private BaseResult<BaseObject> prevPage;
  private Iterator<BaseObject> recordIterator;
  private int iteratorPosition;

  /**
   * Constructor for iteratorPosition object.
   * @param client the client
   * @param objectInfo the object info
   * @param arguments the arguments
   * @throws IOException in case if resource not found
   */
  public PageIterator(ZuoraRestClient client, ObjectInfo objectInfo, Map<String, String> arguments) throws IOException {
    this.client = client;
    this.objectInfo = objectInfo;
    this.arguments = arguments;
    gotoNextPage(null);
  }

  /**
   * Returns the boolean.
   * @return  boolean
   * @throws IOException in case if resource not found
   */
  public boolean hasNext() throws IOException {
    if (!recordIterator.hasNext()) {
      BaseResult<BaseObject> page = client.nextPage(currentPage);
      if (page != null) {
        prevPage = currentPage;
        currentPage = page;

        gotoNextPage(currentPage);
      }
    }

    return (currentPage != null && recordIterator.hasNext());
  }

  /**
   * Returns the BaseObject.
   * @return BaseObject
   * @throws IOException in case if resource not found
   */
  public BaseObject next() throws IOException {
    if (hasNext()) {
      iteratorPosition++;
      return recordIterator.next();
    } else {
      throw new NoSuchElementException("No more objects present.");
    }
  }

  /**
   * Just reload the current page.
   * @throws IOException
   */
  public void reloadCurrentPage() throws IOException {
    int iteratorPosition = this.iteratorPosition;
    gotoNextPage(prevPage);
    setIteratorPosition(iteratorPosition);
  }

  private void gotoNextPage(BaseResult<BaseObject> page) throws IOException {
    if (page == null) {
      currentPage = client.getObject(objectInfo, arguments);
    } else {
      currentPage = client.nextPage(prevPage);
    }

    if (!currentPage.isSuccess()) {
      throw new RuntimeException(String.format("API exception of the query id %s: %s",
                                               currentPage.getProcessId(), currentPage.getReason(false)));
    }

    iteratorPosition = 0;
    recordIterator = currentPage.getResult().iterator();
  }

  private void setIteratorPosition(int iteratorPosition) throws IOException {
    for (int i = 0; i < iteratorPosition; i++) {
      if (recordIterator.hasNext()) {
        next();
      } else {
        break;
      }
    }
  }
}
