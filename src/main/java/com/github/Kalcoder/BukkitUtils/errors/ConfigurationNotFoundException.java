package com.github.Kalcoder.BukkitUtils.errors;

/** Error for a missing configuration file
 * @version 1.0
 * @since 1.0
 */
public class ConfigurationNotFoundException extends Error{
  
  public ConfigurationNotFoundException() {
    super();
  }
  
  /**
   * @param configName The name of the missing configuration
   */
  public ConfigurationNotFoundException(String configName) {
    super("The configuration \"" + configName + "\" was not found!");
  }
  
  /**
   * @param configName The name of the missing configuration
   * @param cause The cause of the error
   */
  public ConfigurationNotFoundException(String configName, Throwable cause) {
    super("The configuration \"" + configName + "\" was not found!", cause);
  }
  
  /**
   * @param cause The cause of the error
   */
  public ConfigurationNotFoundException(Throwable cause) {
    super(cause);
  }
  
  protected ConfigurationNotFoundException(String configName, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super("The configuration \"" + configName + "\" was not found!", cause, enableSuppression, writableStackTrace);
  }
}
