package jal.business.log;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * A class that accepts logs and passes them on to listeners.
 * Use {@link #addListener(Consumer)} to register as a listener.
 * 
 * @author Roy
 * 
 * @see jal.business.log.Log
 * @see jal.business.log.Logger
 */
public class JALogger implements Logger {

	private LogLevel logLevel;
	private List<Consumer<Log>> listeners;
	
	/**
	 * Initializes the Logger with a certain log level.
	 * 
	 * @param logLevel defines which log levels get logged.
	 */
	public JALogger(LogLevel logLevel) {
		
		this.logLevel = logLevel;
		listeners = new ArrayList<>();
	}

	/**
	 * Initializes the Logger with the log level debug.
	 */
	public JALogger() {

		this(LogLevel.DEBUG);
	}
	
	/**
	 * Add a listener, this listener will receive a Log object for every log that is made on this JALogger.
	 * 
	 * @param listener the listener to add.
	 */
	public void addListener(Consumer<Log> listener) {

		listeners.add(listener);
	}

	/**
	 * Remove a listener, this listener will no longer receive a Log object for every log that is made on this JALogger.
	 * 
	 * @param listener the listener to remove.
	 */
	public void removeListener(Consumer<Log> listener) {

		listeners.remove(listener);
	}

	@Override
	public void log(LogLevel logLevel, String message, String tag) {

		if(logLevel.getLevel() < this.logLevel.getLevel())
			return;
		
		Log log = new Log(logLevel, message, tag);
		listeners.stream().forEach(listener -> listener.accept(log));
	}

	@Override
	public void log(LogLevel logLevel, String message) {

		log(logLevel, message, "");
	}

	@Override
	public void debug(String message, String tag) {

		log(LogLevel.DEBUG, message, tag);
	}

	@Override
	public void debug(String message) {

		debug(message, "");
	}

	@Override
	public void info(String message, String tag) {

		log(LogLevel.INFO, message, tag);
	}

	@Override
	public void info(String message) {

		info(message, "");
	}

	@Override
	public void warning(String message, String tag) {

		log(LogLevel.WARNING, message, tag);
	}

	@Override
	public void warning(String message) {

		warning(message, "");
	}

	@Override
	public void error(String message, String tag) {

		log(LogLevel.ERROR, message, tag);
	}

	@Override
	public void error(String message) {

		error(message, "");
	}
}
