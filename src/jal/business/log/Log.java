package jal.business.log;

import java.util.Date;

import org.json.JSONObject;

public final class Log {

	private static final String timestamp_field = "timestamp";
	private static final String logLevel_field = "logLevel";
	private static final String message_field = "message";
	private static final String tag_field = "tag";

    private LogLevel logLevel;
    private Date timestamp;
    private String message;
    private String tag;

    private Log(Date timestamp, LogLevel logLevel, String message, String tag) {

        this.timestamp = timestamp;
        this.logLevel = logLevel;
        this.message = message;
        this.tag = tag;
    }

    public Log(LogLevel logLevel, String message, String tag) {

    	this(new Date(), logLevel, message, tag);
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public Date getTimeStamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getTag() {
        return tag;
    }

    public static Log from(JSONObject json) {

    	Date timestamp = new Date(json.getLong(timestamp_field));
    	LogLevel logLevel = LogLevel.valueOf(json.getString(logLevel_field));
    	String message = json.getString(message_field);
    	String tag = json.getString(tag_field);

    	return new Log(timestamp, logLevel, message, tag);
    }

    public JSONObject toJSON() {

    	JSONObject json = new JSONObject();
    	json.put(timestamp_field, timestamp);
    	json.put(logLevel_field, logLevel.name());
    	json.put(message_field, message);
    	json.put(tag_field, tag);

    	return json;
    }

    @Override
    public String toString() {

    	StringBuilder stringBuilder = new StringBuilder();

    	stringBuilder.append(String.format("%s - [%s]", timestamp.toString(), logLevel.toString()));

    	if(tag != null && !tag.isEmpty())
    		stringBuilder.append(" [" + tag + "]");

    	stringBuilder.append(" " + message);

    	return stringBuilder.toString();
    }
}
