package com.github.Kalcoder.BukkitUtils.utils;

import com.github.Kalcoder.BukkitUtils.errors.MissingConfigurationException;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/** Utilities for configuration files
 *
 * @since 1.0
 */
public class ConfigUtils {

  /** List of cached configurations
   *
   * @since 1.0
   */
  private static HashMap<YamlConfiguration, File> configurations = new HashMap<>();

  //region File Management

  /** Loads all configurations and caches them
   * @param plugin The plugin that uses BukkitUtils
   *
   * @since 1.1
   */
  public static void loadAllConfigs(JavaPlugin plugin) {
    if (!plugin.getDataFolder().exists()) {
      System.out.println("Making data folder!");
      plugin.getDataFolder().mkdir();
    }
    if (plugin.getDataFolder().listFiles() == null) return;
    System.out.println("Files were found!");

    for (File file : plugin.getDataFolder().listFiles()) {
      System.out.println(file.getAbsolutePath());
      YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
      configurations.put(configuration, file);
    }
  }

  /** Creates a new configuration
   * @param configName The name of the configuration
   * @param plugin The plugin that uses BukkitUtils
   *
   * @since 1.0
   */
  public static void createNewConfig(String configName, JavaPlugin plugin) {
    File configFile = new File(plugin.getDataFolder(), "$configName.yml");

    if (configFile.exists()) {
      plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED.toString() + "Error: Could not create new config called " + configName + " because it already exists!");
      return;
    }

    try {
      configFile.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    configurations.put(YamlConfiguration.loadConfiguration(configFile), configFile);
  }

  /** Checks if a configuration exists
   * @param configName The name of the configuration
   * @param plugin The plugin that uses BukkitUtils
   *
   * @return true if the given configuration was found
   *
   * @since 1.1
   */
  public static boolean configurationExists(String configName, JavaPlugin plugin) {
    File configFile = new File(plugin.getDataFolder(), "$configName.yml");
    return configFile.exists();
  }
  //endregion

  //region Config Management

  /** Retrieve all keys from configuration
   * @param name The name of the configuration to retrieve keys from
   * @param deep If false will read only top-level keys
   *
   * @return The keys
   *
   * @throws MissingConfigurationException if configuration was not found
   *
   * @since 1.1
   */
  public static Set<String> getAllKeysFromConfig(String name, Boolean deep) throws MissingConfigurationException {
    for (File file : configurations.values()) {
      System.out.println("file.getName() = " + file.getName().substring(0, file.getName().length() - 4));
      if (file.getName().substring(0, file.getName().length() - 4).equalsIgnoreCase(name)) return YamlConfiguration.loadConfiguration(file).getKeys(deep);
    }
    throw new MissingConfigurationException(name);
  }

  /** Read a value from a configuration
   * @param name The name of the configuration to read from
   * @param path The path to read from
   *
   * @return The value that was read
   *
   * @throws MissingConfigurationException if configuration was not found
   *
   * @since 1.0
   */
  public static Object readFromConfig(String name, String path) throws MissingConfigurationException {
    for (File file : configurations.values()) {
      if (file.getName().substring(0, file.getName().length() - 4).equalsIgnoreCase(name)) return YamlConfiguration.loadConfiguration(file).get(path);
    }
    throw new MissingConfigurationException(name);
  }

  /** Read a value from a configuration
   * @param config The configuration to read from
   * @param path The path to read from
   *
   * @return The value that was read
   *
   * @since 1.1
   */
  public static Object readFromConfig(YamlConfiguration config, String path) {
    return config.get(path);
  }

  /** Read a value from a configuration
   * @param configFile The configuration's file
   * @param path The path to read from
   *
   * @return The value that was read
   *
   * @since 1.1
   */
  public static Object readFromConfig(File configFile, String path) {
    return YamlConfiguration.loadConfiguration(configFile).get(path);
  }

  /** Set a value in a configuration
   * @param name The name of the configuration
   * @param path The path to set the value to
   * @param value The value to set
   *
   * @throws MissingConfigurationException if configuration was not found
   *
   * @since 1.0
   */
  public static void setInConfig(String name, String path, Object value) throws MissingConfigurationException {
    for (File file : configurations.values()) {
      if (file.getName().substring(0, file.getName().length() - 4).equalsIgnoreCase(name)) {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set(path, value);
        try {
          config.save(file);
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    }
    throw new MissingConfigurationException(name);
  }

  //endregion

}