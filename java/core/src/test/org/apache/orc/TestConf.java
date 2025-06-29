/*
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
package org.apache.orc;

import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.BeforeEach;

/**
 * A shared configuration for ORC tests.
 */
public interface TestConf {

  Configuration conf = getNewConf();

  @BeforeEach
  default void clear() {
    conf.clear();
    conf.setIfUnset("fs.defaultFS", "file:///");
    conf.setIfUnset("fs.file.impl.disable.cache", "true");
  }

  private static Configuration getNewConf() {
    Configuration conf = new Configuration();
    conf.setIfUnset("fs.defaultFS", "file:///");
    conf.setIfUnset("fs.file.impl.disable.cache", "true");
    return conf;
  }
}
