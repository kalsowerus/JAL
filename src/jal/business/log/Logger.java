package jal.business.log;

public interface Logger {

	public void log(LogLevel logLevel, String message, String tag);

	public void log(LogLevel logLevel, String message);

	public void debug(String message, String tag);

	public void debug(String message);

	public void info(String message, String tag);

	public void info(String message);

	public void warning(String message, String tag);

	public void warning(String message);

	public void error(String message, String tag);

	public void error(String message);

}
