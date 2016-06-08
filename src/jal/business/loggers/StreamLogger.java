package jal.business.loggers;

import java.io.PrintStream;
import java.util.function.Consumer;

import jal.business.log.Log;

/**
 * A logger for {@link jal.business.log.JALogger JALogger} that writes all logs to a specified stream. <br>
 * Can be used to redirect logs to STDOUT as follows: <br>
 * <br>
 * {@code new StreamLogger(System.out)}
 * 
 * @author Roy
 */
public class StreamLogger implements Consumer<Log> {

	private PrintStream out;
	
	/**
	 * Creates a StreamLogger that will write to a specified stream
	 * 
	 * @param out the stream to write to.
	 */
	public StreamLogger(PrintStream out) {

		this.out = out;
	}

	@Override
	public void accept(Log log) {

		out.println(log.toString());
	}
}
