/**
 * Licensed to the Apache Software Foundation (ASF) under one
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

package com.streamsets.pipeline.api;

import com.streamsets.pipeline.api.impl._ApiUtils;
import com.streamsets.pipeline.api.impl._PipelineException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Locale;

public class StageException extends Exception {
  private static final Logger LOG = LoggerFactory.getLogger(StageException.class);
  private static final String PIPELINE_BUNDLE_NAME = "pipeline-bundle";

  static void setContext(Stage.Info info, ClassLoader stageClassLoader) {
    _ApiUtils.checkNotNull(info, "info");
    _ApiUtils.checkNotNull(stageClassLoader, "stageClassLoader");
    String bundleName = (info.getName() + "-" + info.getVersion()).replace('.', '_');
    _PipelineException.setContext(bundleName, stageClassLoader);
  }

  static void resetContext() {
    _PipelineException.resetContext();
  }

  private _PipelineException exception;

  // last parameter can be a cause exception
  public StageException(ErrorId id, Object... params) {
    exception = new _PipelineException(PIPELINE_BUNDLE_NAME, id, params);
    if (!_PipelineException.isContextSet()) {
      // setting an exception to create a stack trace
      LOG.warn("The StageException context has not been set, messages won't be localized", new Exception());
    }
  }

  public ErrorId getErrorId() {
    return exception.getErrorId();
  }

  public String getMessage() {
    return exception.getMessage();
  }

  public String getMessage(Locale locale) {
    return exception.getMessage(locale);
  }

  @Override
  public String getLocalizedMessage() {
    return exception.getLocalizedMessage();
  }

  @Override
  public synchronized Throwable getCause() {
    return exception.getCause();
  }

  @Override
  public synchronized Throwable initCause(Throwable cause) {
    return exception.initCause(cause);
  }

  @Override
  public String toString() {
    return exception.toString();
  }

  @Override
  public void printStackTrace() {
    exception.printStackTrace();
  }

  @Override
  public void printStackTrace(PrintStream s) {
    exception.printStackTrace(s);
  }

  @Override
  public void printStackTrace(PrintWriter s) {
    exception.printStackTrace(s);
  }

  @Override
  public StackTraceElement[] getStackTrace() {
    return exception.getStackTrace();
  }

  @Override
  public void setStackTrace(StackTraceElement[] stackTrace) {
    exception.setStackTrace(stackTrace);
  }

}
