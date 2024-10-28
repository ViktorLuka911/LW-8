package Loggers;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomFormatter extends Formatter {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        String level = record.getLevel().toString();
        if ("SEVERE".equals(level)) {
            level = "ERROR";
        }
        String dateTime = dateFormat.format(new Date(record.getMillis()));

        return String.format("%s %n[%s]: %s%n%n", dateTime, level, record.getMessage());
    }
}
