package jal.business.log;

/**
 * An enumeration to represent the severity of a {@link jal.business.log.Log}
 * 
 * @author Roy
 */
public enum LogLevel {
	
	/**
	 * The lowest log level, used for debugging purposes.
	 */
	DEBUG(0),
	
	/**
	 * The second lowest log level, used for informative messages.
	 */
	INFO(1),
	
	/**
	 * The second highest log level, used when something goes wrong or not as expected but can easily be recovered.
	 */	
	WARNING(2),
	
	/**
	 * The highest log level, used when something goes wrong or unexpectedly and no easy recovery is possible.
	 */	
	ERROR(3);

	private int level;
	
	/**
	 * Gets a integer representing the log level.
	 * 
	 * @param level the integer representing the log level.
	 */
	private LogLevel(int level) {

		this.level = level;
	}

	public int getLevel() {

		return level;
	}
}
