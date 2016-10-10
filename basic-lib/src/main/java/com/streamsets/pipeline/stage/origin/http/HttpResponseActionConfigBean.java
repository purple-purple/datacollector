/*
 * Copyright 2016 StreamSets Inc.
 *
 * Licensed under the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.streamsets.pipeline.stage.origin.http;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.ValueChooserModel;

public abstract class HttpResponseActionConfigBean {

  public static final int DUMMY_STATUS = -1;
  public static final long DEFAULT_BACKOFF_INTERVAL_MS = 1000;
  public static final int DEFAULT_MAX_NUM_RETRIES = 10;

  public abstract int getStatusCode();
  public abstract long getBackoffInterval();
  public abstract int getMaxNumRetries();
  public abstract ResponseAction getAction();
}
