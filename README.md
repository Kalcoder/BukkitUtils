# BukkitUtils
A set of utilities for Bukkit plugin development

### Author
Kalcoder

## About
This set of utilities makes creating Bukkit plugins easier. It uses the Craftbukkit API to do things such as custom commands, configuration utilities, etc. 

**NOTE**: You still have to have a Bukkit API in your project for your plugin to work! This does not automatically add the Bukkit API to your project.

## Getting Started
To use this set of utilities, you can either use it as a dependency in your Maven/Gradle project, or you can download the jar file to manually add as a dependency to your project.

To use this as a dependency, go to the packages tab on this repository, and follow the instructions.

There are many different ways to use this utility set.

### Creating a command
When creating a custom command, you have different options on what type of command to create.

**NOTE**: You still have to add the command to the plugin.yml and register it in your `public void onEnable()` in you main class. 

##### Example: /test (Can be sent by anyone)
```java
public class TestCommand extends BaseCommand {
  public TestCommand(JavaPlugin plugin) {
    super("test", plugin);
  }
  @Override
  public void onCommand(CommandSender sender, String[] arg) {
    sender.sendMessage("Test!");
  }
}
```


##### Example: /hello (Can only be sent by a player)
```java
public class HelloCommand extends BaseCommand implements IPlayerCommand {
  public TestCommand(JavaPlugin plugin) {
    super("hello", plugin);
  }
  @Override
  public void onCommand(CommandSender sender, String[] arg) {
    sender.sendMessage("Hello, World!");
  }
}
```
