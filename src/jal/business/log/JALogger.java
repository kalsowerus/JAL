package jal.business.log;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class JALogger implements Logger {

	private LogLevel logLevel;
	private List<Consumer<Log>> listeners;
	
	public JALogger(LogLevel logLevel) {
		
		this.logLevel = logLevel;
		listeners = new ArrayList<>();
	}

	public JALogger() {

		this(LogLevel.DEBUG);
	}

	public void addListener(Consumer<Log> listener) {

		listeners.add(listener);
	}

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
