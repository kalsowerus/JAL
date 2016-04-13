package jal.business.loggers;

import java.io.PrintStream;
import java.util.function.Consumer;

import jal.business.log.Log;

public class StreamLogger implements Consumer<Log> {

	private PrintStream out;

	public StreamLogger(PrintStream out) {

		this.out = out;
	}

	@Override
	public void accept(Log log) {

		out.println(log.toString());
	}
}
