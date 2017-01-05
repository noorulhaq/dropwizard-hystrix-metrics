#Dropwizard Hystrix Metrics

A library that captures hystrix circuit breaker metrics in provided metrics registry.

## Getting it

1) Define maven repository
```xml
	<repository>
	  <id>sonatype-snapshots</id>
	  <name>Sonatype Snapshots</name>
	  <url>https://oss.sonatype.org/content/repositories/snapshots</url>
	  <snapshots>
	    <enabled>true</enabled>
	  </snapshots>
	</repository>
```

2) Add dependency
```xml
	<dependency>
	   <groupId>io.github.noorulhaq</groupId>
	   <artifactId>hystrix-metrics</artifactId>
       <version>1.0.0-SNAPSHOT</version>
	</dependency>
```

-------------------------------------
_Licensed under [Apache Software License 2.0](www.apache.org/licenses/LICENSE-2.0)_
