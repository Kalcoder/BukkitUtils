package com.github.Kalcoder.BukkitUtils.config;

import com.github.Kalcoder.BukkitUtils.errors.ConfigurationNotFoundException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.HashMap;

/** Utilities for configuration files
 * @version 1.0
 * @since 1.0
 */
public class ConfigUtils {
  
  /** Configuration files
   *
   */
  static HashMap<String, FileConfiguration> configurations = new HashMap<>();
  
  /** Creates a configuration file
   * @param name Name of the configuration
   * @param plugin The plugin that BukkitUtils uses
   */
  public static void createConfig(String name, Plugin plugin) {
    File newConfig = new File(plugin.getDataFolder(), name + ".yml");
    configurations.put(name, YamlConfiguration.loadConfiguration(newConfig));
  }
  
  /** Reads an object from a configuration file
   * @param configName The name of the configuration
   * @param type The type of object to retrieve
   * @param path The path of the object to retrieve
   * @return The object that was retrieved
   * @throws ConfigurationNotFoundException Thrown if no configuration was found under the name given
   */
  public static Object readFromConfig(String configName, SearchType type, String path) throws ConfigurationNotFoundException {
    
    FileConfiguration config = null;
    
    for (String name:
         configurations.keySet()) {
      if (name.equalsIgnoreCase(configName)) {
        config = configurations.get(name);
      }
    }
    
    if (config == null) throw new ConfigurationNotFoundException();
    
    switch (type) {
      case STRING:
        return config.getString(path);
      case INTEGER:
        return config.getInt(path);
      default:
        break;
    }
    
    return null;
    
  }

/** Adds an object from a configuration file
 * @param configName The name of the configuration
 * @param path The path of the object to set
 * @param value The object to set path to
 * @throws ConfigurationNotFoundException Thrown if no configuration was found under the name given
 */
  public static void addToConfig(String configName, String path, Object value) throws ConfigurationNotFoundException {
    FileConfiguration config = null;
  
    for (String name:
            configurations.keySet()) {
      if (name.equalsIgnoreCase(configName)) {
        config = configurations.get(name);
      }
    }
  
    if (config == null) throw new ConfigurationNotFoundException();
    
    config.set(path, value);
  }
  
  /** The different objects that are readable from a configuration
   *
   */
  public enum SearchType {
    INTEGER,
    STRING
  }
  
}
