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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.felix.framework.Felix;
import org.apache.felix.framework.util.FelixConstants;
import org.apache.hadoop.conf.Configuration;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * @author kbohling
 * 
 */
public class HostApplication {

  public final static String CONFIGURATION_KEY = HostApplication.class
      .getName()
      + ".conf";
  private HostActivator m_activator = null;
  private Felix m_felix = null;

  public HostApplication() {
    // Create a configuration property map.
    Map<String, Object> configMap = new HashMap<String, Object>();
    Configuration conf = new Configuration();

    final String prefix = "file:build/osgi/bundle";

    // TODO: Must be dumped into a config file.
    String bundleList[] = new String[] {
//        "analysis-de.jar", -- Ignoring for now.
//        "analysis-fr.jar", -- Ignoring for now.
        "automaton.jar",
        "com.springsource.javax.servlet-2.4.0.jar",
        "com.springsource.javax.xml.rpc-1.1.0.jar",
        "com.springsource.org.apache.commons.beanutils-1.8.0.jar",
        "com.springsource.org.apache.commons.collections-3.2.1.jar",
        "com.springsource.org.apache.commons.httpclient-3.1.0.jar",
        "com.springsource.org.apache.commons.lang-2.1.0.jar",
        "com.springsource.org.apache.commons.logging-1.1.1.jar",
        "com.springsource.org.apache.log4j-1.2.15.jar",
        "com.springsource.org.jaxen-1.1.1.jar",
        "commons-feedparser.jar",
//        "creativecommons.jar", -- Ignoring for now.
//        "feed.jar", -- Ignoring for now.
        "field-basic.jar",
        "field-boost.jar",
        "index-anchor.jar",
        "index-basic.jar",
        "index-more.jar",
//        "languageidentifier.jar" -- Ignoring for now.
        "lib-http.jar",
        "lib-jakarta-poi.jar",
        "lib-lucene-analyzers.jar",
        "lib-nekohtml.jar",
        "lib-parsems.jar",
        "lib-regex-filter.jar",
        "lib-xml.jar",
        "microformats-reltag.jar",
//        "nutch-extensionpoints.jar", -- Don't think this should be needed.
        "nutch.jar",
//        "ontology.jar", -- Ignoring for now.
        "org.apache.commons.codec_1.3.0.v20080530-1600.jar",
        "org.apache.felix.shell-1.2.0.jar",
        "org.apache.felix.shell.tui-1.2.0.jar",
        "org.apache.oro_2.0.8.v200803061811.jar",
        "org.jdom_1.0.0.v200803070505.jar",
        "parse-ext.jar",
        "parse-html.jar",
        "parse-js.jar",
//        "parse-mp3.jar", -- Ignoring for now.
        "parse-msexcel.jar",
        "parse-mspowerpoint.jar",
        "parse-msword.jar",
        "parse-oo.jar",
//        "parse-pdf.jar", -- I don't want to deal with this right now.
        "parse-rss.jar",
//        "parse-rtf.jar", -- Another plugin I won't want to deal with.
//        "parse-swf.jar", -- Another plugin I won't want to deal with.
        "parse-text.jar",
        "parse-zip.jar",
        "protocol-file.jar",
        "protocol-ftp.jar",
        "protocol-http.jar",
        "protocol-httpclient.jar",
        "query-basic.jar",
        "query-custom.jar",
        "query-more.jar",
        "query-site.jar",
        "query-url.jar",
        "response-json.jar",
        "response-xml.jar",
        "scoring-link.jar",
        "scoring-opic.jar",
        "subcollection.jar",
        "summary-basic.jar",
        "summary-lucene.jar",
        "tagsoup.jar",
        "tld.jar",
        "urlfilter-automaton.jar",
        "urlfilter-domain.jar",
        "urlfilter-prefix.jar",
        "urlfilter-regex.jar",
        "urlfilter-suffix.jar",
        "urlfilter-validator.jar",
        "urlnormalizer-basic.jar",
        "urlnormalizer-pass.jar",
        "urlnormalizer-regex.jar",
    };
    
    // TODO: Needs to be dumped into a config file.
    String packageList[] = new String[] {
        "com.ibm.icu.text",
        "net.sf.json",
        
        "org.apache.commons.cli",
        "org.apache.commons.net",
        "org.apache.commons.net.ftp",
        "org.apache.commons.net.ftp.parser",
        
        "org.apache.felix.framework",
        "org.apache.felix.main",

        "org.apache.hadoop.conf",
        "org.apache.hadoop.fs",
        "org.apache.hadoop.io",
        "org.apache.hadoop.ipc",
        "org.apache.hadoop.mapred",
        "org.apache.hadoop.mapred.lib",
        "org.apache.hadoop.util",
        
        "org.apache.html.dom",
        
        "org.apache.lucene.analysis",
        "org.apache.lucene.analysis.standard",
        "org.apache.lucene.document",
        "org.apache.lucene.util",
        "org.apache.lucene.index",
        "org.apache.lucene.misc",
        "org.apache.lucene.search",
        "org.apache.lucene.search.highlight",
        "org.apache.lucene.store",
        "org.apache.lucene.queryParser",

        
        "org.apache.solr.client.solrj",
        "org.apache.solr.client.solrj.impl",
        "org.apache.solr.client.solrj.request",
        "org.apache.solr.client.solrj.response",
        "org.apache.solr.common",
        "org.apache.solr.common.params",
        
        "org.apache.tika.mime",
        "org.apache.tika",
        
        "org.apache.xerces.dom",
        "org.apache.xerces.impl",
        "org.apache.xerces.parsers",
        "org.apache.xerces.util",
        "org.apache.xerces.xni",
        "org.apache.xerces.xni.parser",
        "org.apache.xml.resolver",
        "org.apache.xml.resolver.readers",
        
        "sun.io",
        "sun.net.www.protocol.http",
        

    };
    
    String autoStart = "";
    boolean first = true;
    for (String it : bundleList) {
      if (false == first) {
        autoStart = autoStart + " ";
      } else {
        first = false;
      }
      autoStart = autoStart + prefix + "/" + it;
    }

    String packageListStr = "";
    
    first = true;
    for (String it : packageList) {
      if (false == first) {
        packageListStr = packageListStr + ", ";
      } else {
        first = false;
      }
      
      packageListStr = packageListStr + it; 
    }
    
    configMap.put(CONFIGURATION_KEY, conf);
    configMap.put("felix.auto.start.1", autoStart);
    
    
    configMap.put("felix.log.level", "1");
    configMap.put("org.osgi.service.http.port", "7070");
    configMap.put("osgi.shell.telnet", "on");
    configMap.put("orb.repository.url",
        "http://felix.apache.org/orb/releases.xml");
    configMap.put("org.osgi.framework.system.packages.extra",
        packageListStr);

    // Create host activator;
    m_activator = new HostActivator(configMap);
    List<Object> list = new ArrayList<Object>();
    list.add(m_activator);
    configMap.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, list);
    configMap.put(FelixConstants.FRAMEWORK_STORAGE, "build/felix-cache");

    try {
      // Now create an instance of the framework with
      // our configuration properties.
      m_felix = new Felix(configMap);
      // Now start Felix instance.
      m_felix.start();
    } catch (Exception ex) {
      System.err.println("Could not create framework: " + ex);
      ex.printStackTrace();
    }
  }

  public Bundle[] getInstalledBundles() {
    // Use the system bundle activator to gain external
    // access to the set of installed bundles.
    return m_activator.getBundles();
  }

  public void shutdownApplication(long timeout) throws InterruptedException,
      BundleException {
    // Shut down the felix framework when stopping the
    // host application.
    m_felix.stop();
    m_felix.waitForStop(timeout);
  }
}