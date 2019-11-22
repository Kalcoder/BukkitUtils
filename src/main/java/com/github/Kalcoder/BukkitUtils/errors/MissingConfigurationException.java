package com.github.Kalcoder.BukkitUtils.errors;

/** Error for a missing configuration file
 *
 * @since 1.0
 */
<<<<<<< Updated upstream:src/main/java/com/github/Kalcoder/BukkitUtils/errors/ConfigurationNotFoundException.java
public class ConfigurationNotFoundException extends Exception{
=======
public class MissingConfigurationException extends Error{
>>>>>>> Stashed changes:src/main/java/com/github/Kalcoder/BukkitUtils/errors/MissingConfigurationException.java
  
  public MissingConfigurationException() {
    super();
  }
  
  /**
   * @param configName The name of the missing configuration
   *
   * @since 1.0
   */
  public MissingConfigurationException(String configName) {
    super("The configuration \"" + configName + "\" was not found!");
  }
  
  /**
   * @param configName The name of the missing configuration
   * @param cause The cause of the error
   *
   * @since 1.0
   */
  public MissingConfigurationException(String configName, Throwable cause) {
    super("The configuration \"" + configName + "\" was not found!", cause);
  }
  
  /**
   * @param cause The cause of the error
   *
   * @since 1.0
   */
  public MissingConfigurationException(Throwable cause) {
    super(cause);
  }
  
  protected MissingConfigurationException(String configName, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super("The configuration \"" + configName + "\" was not found!", cause, enableSuppression, writableStackTrace);
  }
}
