package com.github.Kalcoder.BukkitUtils.utils

import com.github.Kalcoder.BukkitUtils.errors.ConfigurationNotFoundException
import org.bukkit.ChatColor
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.IOException
import java.util.*

/** Utilities for configuration files
 *
 * @since 1.0
 */
object ConfigUtils {

  /** List of cached configurations
   *
   * @since 1.0
   */
  private val configurations = HashMap<YamlConfiguration, File>()

  //region File Management

  /** Loads all configurations and caches them
   * @param plugin The plugin that uses BukkitUtils
   *
   * @since 1.1
   */
  @JvmStatic
  fun loadAllConfigs(plugin: JavaPlugin) {
    if (!plugin.dataFolder.exists()) {
      println("Making data folder!")
      plugin.dataFolder.mkdir()
    }
    if (plugin.dataFolder.listFiles() == null) return
    println("Files were found!")

    for (file in plugin.dataFolder.listFiles()!!) {
      println(file.absolutePath)
      val configuration = YamlConfiguration.loadConfiguration(file)
      configurations[configuration] = file
    }
  }

  /** Creates a new configuration
   * @param configName The name of the configuration
   * @param plugin The plugin that uses BukkitUtils
   *
   * @since 1.0
   */
  @JvmStatic
  fun createNewConfig(configName: String, plugin: JavaPlugin) {
    val configFile = File(plugin.dataFolder, "$configName.yml")

    if (configFile.exists()) {
      plugin.server.consoleSender.sendMessage(ChatColor.RED.toString() + "Error: Could not create new config called " + configName + " because it already exists!")
      return
    }

    try {
      configFile.createNewFile()
    } catch (e: IOException) {
      e.printStackTrace()
    }

    configurations[YamlConfiguration.loadConfiguration(configFile)] = configFile
  }

  /** Checks if a configuration exists
   * @param configName The name of the configuration
   * @param plugin The plugin that uses BukkitUtils
   *
   * @return true if the given configuration was found
   *
   * @since 1.1
   */
  @JvmStatic
  fun configurationExists(configName: String, plugin: JavaPlugin): Boolean {
    val configFile = File(plugin.dataFolder, "$configName.yml")
    return configFile.exists()
  }
  //endregion

  //region Config Management

  /** Retrieve all keys from configuration
   * @param name The name of the configuration to retrieve keys from
   * @param deep If false will read only top-level keys
   *
   * @return The keys
   *
   * @throws ConfigurationNotFoundException
   *
   * @since 1.1
   */
  @JvmStatic
  @Throws(ConfigurationNotFoundException::class)
  fun getAllKeysFromConfig(name: String, deep: Boolean): Set<String> {
    for (file in configurations.values) {
      println("file.getName() = " + file.name.substring(0, file.name.length - 4))
      if (file.name.substring(0, file.name.length - 4).equals(name, ignoreCase = true)) return YamlConfiguration.loadConfiguration(file).getKeys(deep)
    }
    throw ConfigurationNotFoundException(name)
  }

  /** Read a value from a configuration
   * @param name The name of the configuration to read from
   * @param path The path to read from
   *
   * @return The value that was read
   *
   * @throws ConfigurationNotFoundException
   *
   * @since 1.0
   */
  @JvmStatic
  @Throws(ConfigurationNotFoundException::class)
  fun readFromConfig(name: String, path: String): Any? {
    for (file in configurations.values) {
      if (file.name.substring(0, file.name.length - 4).equals(name, ignoreCase = true)) return YamlConfiguration.loadConfiguration(file).get(path)
    }
    throw ConfigurationNotFoundException(name)
  }

  /** Read a value from a configuration
   * @param config The configuration to read from
   * @param path The path to read from
   *
   * @return The value that was read
   *
   * @since 1.1
   */
  @JvmStatic
  fun readFromConfig(config: YamlConfiguration, path: String): Any? {
    return config.get(path)
  }

  /** Read a value from a configuration
   * @param configFile The configuration's file
   * @param path The path to read from
   *
   * @return The value that was read
   *
   * @since 1.1
   */
  @JvmStatic
  fun readFromConfig(configFile: File, path: String): Any? {
    return YamlConfiguration.loadConfiguration(configFile).get(path)
  }

  /** Read a boolean value from a configuration
   * @param name The name of the configuration to read from
   * @param path The path to read from
   *
   * @return The value that was read
   *
   * @throws ConfigurationNotFoundException
   *
   * @since 1.1
   */
  @JvmStatic
  @Throws(ConfigurationNotFoundException::class)
  fun readBooleanFromConfig(name: String, path: String): Boolean {
    for (file in configurations.values) {
      if (file.name.substring(0, file.name.length - 4).equals(name, ignoreCase = true)) return YamlConfiguration.loadConfiguration(file).getBoolean(path)
    }
    throw ConfigurationNotFoundException(name)

  }

  /** Read a string value from a configuration
   * @param name The name of the configuration to read from
   * @param path The path to read from
   *
   * @return The value that was read
   *
   * @throws ConfigurationNotFoundException
   *
   * @since 1.1
   */
  @JvmStatic
  @Throws(ConfigurationNotFoundException::class)
  fun readStringFromConfig(name: String, path: String): String? {
    for (file in configurations.values) {
      if (file.name.substring(0, file.name.length - 4).equals(name, ignoreCase = true)) return YamlConfiguration.loadConfiguration(file).getString(path)
    }
    throw ConfigurationNotFoundException(name)

  }

  /** Read an integer value from a configuration
   * @param name The name of the configuration to read from
   * @param path The path to read from
   *
   * @return The value that was read
   *
   * @throws ConfigurationNotFoundException
   *
   * @since 1.1
   */
  @JvmStatic
  @Throws(ConfigurationNotFoundException::class)
  fun readIntFromConfig(name: String, path: String): Int {
    for (file in configurations.values) {
      if (file.name.substring(0, file.name.length - 4).equals(name, ignoreCase = true)) return YamlConfiguration.loadConfiguration(file).getInt(path)
    }
    throw ConfigurationNotFoundException(name)

  }

  /** Set a value in a configuration
   * @param name The name of the configuration
   * @param path The path to set the value to
   * @param value The value to set
   *
   * @throws ConfigurationNotFoundException
   *
   * @since 1.0
   */
  @JvmStatic
  @Throws(ConfigurationNotFoundException::class)
  fun setInConfig(name: String, path: String, value: Any) {
    for (file in configurations.values) {
      if (file.name.substring(0, file.name.length - 4).equals(name, ignoreCase = true)) {
        val config = YamlConfiguration.loadConfiguration(file)
        config.set(path, value)
        try {
          config.save(file)
        } catch (e: IOException) {
          e.printStackTrace()
        }

      }
    }
    throw ConfigurationNotFoundException(name)
  }

  //endregion

}