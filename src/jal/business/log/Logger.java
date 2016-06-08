package jal.business.log;

/**
 * An interface that accepts logs.
 * 
 * @author Roy
 * 
 * @see jal.business.log.JALogger
 * @see jal.business.log.Log
 * @see jal.business.log.LogLevel
 */

public interface Logger {
	
	/**
	 * Log a message with a certain log level and tag.
	 * Prefer the convenience methods instead.
	 * 
	 * @param logLevel the log level of the log
	 * @param message the message of the log
	 * @param tag the tag of the log
	 */
	public void log(LogLevel logLevel, String message, String tag);

	/**
	 * Log a message with a certain log level without a tag.
	 * Prefer the convenience methods instead.
	 * 
	 * @param logLevel the log level of the log
	 * @param message the message of the log
	 */
	public void log(LogLevel logLevel, String message);

	/**
	 * Log a message with the log level {@link jal.business.log.LogLevel#DEBUG debug} and certain tag.
	 * 
	 * @param message the message of the log
	 * @param tag the tag of the log
	 */
	public void debug(String message, String tag);

	/**
	 * Log a message with the log level {@link jal.business.log.LogLevel#DEBUG debug} without a tag.
	 * 
	 * @param message the message of the log
	 * @param tag the tag of the log
	 */
	public void debug(String message);

	/**
	 * Log a message with the log level {@link jal.business.log.LogLevel#INFO info} and certain tag.
	 * 
	 * @param message the message of the log
	 * @param tag the tag of the log
	 */
	public void info(String message, String tag);

	/**
	 * Log a message with the log level {@link jal.business.log.LogLevel#INFO info} without a tag.
	 * 
	 * @param message the message of the log
	 * @param tag the tag of the log
	 */
	public void info(String message);

	/**
	 * Log a message with the log level {@link jal.business.log.LogLevel#WARNING warning} and certain tag.
	 * 
	 * @param message the message of the log
	 * @param tag the tag of the log
	 */
	public void warning(String message, String tag);

	/**
	 * Log a message with the log level {@link jal.business.log.LogLevel#WARNING warning} without a tag.
	 * 
	 * @param message the message of the log
	 * @param tag the tag of the log
	 */
	public void warning(String message);

	/**
	 * Log a message with the log level {@link jal.business.log.LogLevel#ERROR error} and certain tag.
	 * 
	 * @param message the message of the log
	 * @param tag the tag of the log
	 */
	public void error(String message, String tag);

	/**
	 * Log a message with the log level {@link jal.business.log.LogLevel#ERROR error} without a tag.
	 * 
	 * @param message the message of the log
	 * @param tag the tag of the log
	 */
	public void error(String message);

}
