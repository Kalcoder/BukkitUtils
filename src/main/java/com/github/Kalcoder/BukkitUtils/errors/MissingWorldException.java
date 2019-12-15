package com.github.Kalcoder.BukkitUtils.errors;

import java.security.PrivilegedActionException;

public class MissingWorldException extends Exception {
  
  /**
   * Constructs a new exception with {@code null} as its detail message.
   * The cause is not initialized, and may subsequently be initialized by a
   * call to {@link #initCause}.
   *
   * @since 1.1
   */
  public MissingWorldException() {
    super();
  }
  
  /**
   * Constructs a new exception with a detail message that includes the specified world.  The
   * cause is not initialized, and may subsequently be initialized by
   * a call to {@link #initCause}.
   *
   * @param worldName the detail message. The detail message is saved for
   *                later retrieval by the {@link #getMessage()} method.
   *
   * @since 1.1
   */
  public MissingWorldException(String worldName) {
    super("The world " + worldName + " was not found!");
  }
  
  /**
   * Constructs a new exception with the specified detail message and
   * cause.  <p>Note that the detail message associated with
   * {@code cause} is <i>not</i> automatically incorporated in
   * this exception's detail message.
   *
   * @param worldName the detail message (which is saved for later retrieval
   *                by the {@link #getMessage()} method).
   * @param cause   the cause (which is saved for later retrieval by the
   *                {@link #getCause()} method).  (A <tt>null</tt> value is
   *                permitted, and indicates that the cause is nonexistent or
   *                unknown.)
   *
   * @since 1.1
   */
  public MissingWorldException(String worldName, Throwable cause) {
    super("The world " + worldName + " was not found!", cause);
  }
  
  /**
   * Constructs a new exception with the specified cause and a detail
   * message of <tt>(cause==null ? null : cause.toString())</tt> (which
   * typically contains the class and detail message of <tt>cause</tt>).
   * This constructor is useful for exceptions that are little more than
   * wrappers for other throwables (for example, {@link
   * PrivilegedActionException}).
   *
   * @param cause the cause (which is saved for later retrieval by the
   *              {@link #getCause()} method).  (A <tt>null</tt> value is
   *              permitted, and indicates that the cause is nonexistent or
   *              unknown.)
   *
   * @since 1.1
   */
  public MissingWorldException(Throwable cause) {
    super(cause);
  }
}
