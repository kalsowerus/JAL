package jal.business.log;

public enum LogLevel {

	DEBUG(0),
	INFO(1),
	WARNING(2),
	ERROR(3);

	private int level;

	private LogLevel(int level) {

		this.level = level;
	}

	public int getLevel() {

		return level;
	}
}
