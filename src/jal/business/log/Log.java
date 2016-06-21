package jal.business.log;

import java.util.Date;

import org.json.JSONObject;

/**
 * A class that represents a log sent to a {@link jal.business.log.JALogger}.
 * 
 * @author Roy
 */
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
    
    /**
     * Creates a log with a certain log level, message and tag.
     * 
     * @param logLevel the log level.
     * @param message the message.
     * @param tag the tag.
     */
    public Log(LogLevel logLevel, String message, String tag) {

    	this(new Date(), logLevel, message, tag);
    }

    /**
     * Gets the log level.
     * 
     * @return the log level.
     */
    public LogLevel getLogLevel() {
        return logLevel;
    }

    /**
     * Gets the time stamp.
     * 
     * @return the time stamp.
     */
    public Date getTimeStamp() {
        return timestamp;
    }
    
    /**
     * gets the message.
     * 
     * @return the message.
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Gets the tag.
     * 
     * @return the tag.
     */
    public String getTag() {
        return tag;
    }
    
    /**
     * Creates a log by parsing a JSON object.
     * 
     * @param json the JSON object to parse.
     * 
     * @return the parsed log.
     * 
     * @see #toJSON()
     */
    public static Log from(JSONObject json) {

    	Date timestamp = new Date(json.getLong(timestamp_field));
    	LogLevel logLevel = LogLevel.valueOf(json.getString(logLevel_field));
    	String message = json.getString(message_field);
    	String tag = json.getString(tag_field);

    	return new Log(timestamp, logLevel, message, tag);
    }
    
    /**
     * Converts this log into a JSON object.
     * 
     * @return the log as a JSON object.
     * 
     * @see #from(JSONObject)
     */
    public JSONObject toJSON() {

    	JSONObject json = new JSONObject();
    	json.put(timestamp_field, timestamp.getTime());
    	json.put(logLevel_field, logLevel.name());
    	json.put(message_field, message);
    	json.put(tag_field, tag);

    	return json;
    }
    
    /**
     * Converts this log into a String fit for being printed or otherwise shown to a technical user.
     * 
     * @return the String representation of this log.
     */
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
