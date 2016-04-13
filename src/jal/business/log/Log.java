package jal.business.log;

import java.util.Date;

public final class Log {

    private LogLevel logLevel;
    private Date timeStamp;
    private String message;
    private String tag;

    public Log(LogLevel logLevel, String message, String tag) {

        this.logLevel = logLevel;
        timeStamp = new Date();
        this.message = message;
        this.tag = tag;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {

    	StringBuilder stringBuilder = new StringBuilder();

    	stringBuilder.append(String.format("%s - [%s]", timeStamp.toString(), logLevel.toString()));

    	if(tag != null && !tag.isEmpty())
    		stringBuilder.append(" [" + tag + "]");

    	stringBuilder.append(" " + message);

    	return stringBuilder.toString();
    }
}
