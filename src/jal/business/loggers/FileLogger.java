package jal.business.loggers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.Consumer;

import jal.business.log.Log;

import static trycrash.Try.*;

public class FileLogger implements Consumer<Log> {

	private File file;

	public FileLogger(File file) {

		this.file = file;
	}

	public FileLogger(String fileLocation) {

		this(new File(fileLocation));
	}

	@Override
	public void accept(Log log) {

		if(!file.exists()) {
			file.mkdirs();
			tryCrash(() -> file.createNewFile());
		}

		tryCrash(() -> Files.write(Paths.get(file.toURI()), log.toString().getBytes(), StandardOpenOption.APPEND));
	}
}
