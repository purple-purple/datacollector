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
package com.streamsets.pipeline.config;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.streamsets.pipeline.serde.StageConfigurationSerializer;

import java.util.ArrayList;
import java.util.List;

/**
 * A registry of all {@link com.streamsets.pipeline.api.Stage} objects
 * available in an installation.
 */
@JsonSerialize(using = StageConfigurationSerializer.class)
public class StageRegistry {

  private List<StageDefinition> stageDefinitions = null;

  public StageRegistry() {
    this.stageDefinitions = new ArrayList<StageDefinition>();
  }

  public List<StageDefinition> getStageDefinitions() {
    return stageDefinitions;
  }
}
