/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nutch.plugin.osgi;

import java.util.Map;

import org.apache.felix.main.AutoActivator;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * Based upon the trivial sample code from 
 * <a href="http://felix.apache.org/site/launching-and-embedding-apache-felix.html#LaunchingandEmbeddingApacheFelix-embedding">
 * Felix's Embedding Documentation</a>
 * 
 * @author kbohling
 *
 */
public class HostActivator extends AutoActivator
{
  /**
   * @param configMap
   */
  public HostActivator(Map<String, Object> configMap) {
    super(configMap);
  }

  private BundleContext m_context = null;

  public void start(BundleContext context)
  {
    super.start(context);
    m_context = context;
  }

  public void stop(BundleContext context)
  {
    m_context = null;
  }

  public Bundle[] getBundles()
  {
    if (m_context != null)
    {
      return m_context.getBundles();
    }
    return new Bundle[0];
  }
}
