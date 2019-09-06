# BukkitUtils
A set of utilities for Bukkit plugin development

### Author
Kalcoder

## About
This set of utilities makes creating Bukkit plugins easier. It uses the Craftbukkit API to do things such as custom commands, configuration utilities, etc. 

**NOTE**: You still have to have a Bukkit API in your project for your plugin to work! This does not automatically add the Bukkit API to your project.

## Getting Started
To use this set of utilities, you can either use it as a dependency in your Maven/Gradle project, or you can download the jar file to manually add as a depenency to your project.

To add to your maven project, add it to your pom.xml:
```xml
<repositories>
  ...
  <repository>
    <id>mavenCentral</id>
    <url>http://repo.maven.apache.org/maven2</url>
  </repository>
  ...
</repositories>

<dependencies>
  ...
  <dependency>
    <groupId>com.github.Kalcoder</groupId>
    <artifactId>BukkitUtils</artifactId>
    <version>LATEST_VERSION_HERE</version>
  </dependency>
  ...
</dependencies>
```

To add it to your gradle project, add it to your build.gradle:
```groovy
repositories {
  mavenCentral()
}

dependencies {
  implementation "com.github.Kalcoder:BukkitUtils:LATEST_VERSION_HERE"
}
```

For each of these options, replace "LATEST_VERSION_HERE" with the version found at the top of this page.

## Getting Started
There are many different ways to use this utility set.

### Creating a command
When creating a custom comman, you have different options on what type of command to create.

// TODO: Finish README.md
