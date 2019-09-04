package me.sh0ck.BukkitUtils.errors;

/** Error for a missing configuration file
 * @version 1.0
 * @since 1.0
 */
public class MissingConfigurationError extends Error{
  
  public MissingConfigurationError() {
    super();
  }
  
  public MissingConfigurationError(String message) {
    super(message);
  }
  
  public MissingConfigurationError(String message, Throwable cause) {
    super(message, cause);
  }
  
  public MissingConfigurationError(Throwable cause) {
    super(cause);
  }
  
  protected MissingConfigurationError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
