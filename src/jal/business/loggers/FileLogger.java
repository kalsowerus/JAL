package jal.business.loggers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.Consumer;

import jal.business.log.Log;

import static trycrash.Try.*;

/**
 * A logger for {@link jal.business.log.JALogger JALogger} that writes all logs to a specified file.
 * 
 * @author Roy
 */
public class FileLogger implements Consumer<Log> {

	private File file;
	
	/**
	 * Creates a logger that will write to a specified file.
	 * 
	 * @param file the file to write to.
	 */
	public FileLogger(File file) {

		this.file = file;
	}
	
	/**
	 * Creates a logger that will write to a file at a specified location.
	 * 
	 * @param fileLocation the location of the file to write to.
	 */
	public FileLogger(String fileLocation) {

		this(new File(fileLocation));
	}

	@Override
	public void accept(Log log) {

		if(!file.exists()) {
			file.getParentFile().mkdirs();
			tryCrash(() -> file.createNewFile());
		}

		tryCrash(() -> Files.write(Paths.get(file.toURI()), (log.toString() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND));
	}
}
