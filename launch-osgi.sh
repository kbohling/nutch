#!/bin/sh

java -classpath \
build/osgi/bundle/com.springsource.org.apache.log4j-1.2.15.jar:\
build/osgi/bundle/com.springsource.org.apache.commons.logging-1.1.1.jar:\
build/osgi/lib/apache-solr-common-1.3.0.jar:\
build/osgi/lib/apache-solr-solrj-1.3.0.jar:\
build/osgi/lib/clustering-carrot2.jar:\
build/osgi/lib/commons-cli-2.0-SNAPSHOT.jar:\
build/osgi/lib/creativecommons.jar:\
build/osgi/lib/feed.jar:\
build/osgi/lib/felix.jar:\
build/osgi/lib/hadoop-0.19.1-core.jar:\
build/osgi/lib/icu4j-4_0_1.jar:\
build/osgi/lib/jets3t-0.6.1.jar:\
build/osgi/lib/jetty-5.1.4.jar:\
build/osgi/lib/junit-3.8.1.jar:\
build/osgi/lib/language-identifier.jar:\
build/osgi/lib/launcher.jar:\
build/osgi/lib/lucene-core-2.4.0.jar:\
build/osgi/lib/lucene-misc-2.4.0.jar:\
build/osgi/lib/nutch-extensionpoints.jar:\
build/osgi/lib/ontology.jar:\
build/osgi/lib/parse-pdf.jar:\
build/osgi/lib/parse-swf.jar:\
build/osgi/lib/taglibs-i18n.jar:\
build/osgi/lib/tika-0.1-incubating.jar:\
build/osgi/lib/xerces-2_6_2-apis.jar:\
build/osgi/lib/xerces-2_6_2.jar \
 org.apache.nutch.plugin.osgi.EmbeddedOSGi
