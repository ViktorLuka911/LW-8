package Commands;

import Loggers.LoggerInfo;
import SystemVouchers.SystemVouchers;

public class Command {

    protected String title;
    protected SystemVouchers systemVouchers;
    protected LoggerInfo logger;

    public Command(String title) {
        this.title = title;
        this.systemVouchers = SystemVouchers.getInstance();
        this.logger = LoggerInfo.getInstance();
    }

    public void execute() {};

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVouchers(SystemVouchers systemVouchers) {
        this.systemVouchers = systemVouchers;
    }

    public void setLoggerInfo(LoggerInfo logger) {
        this.logger = logger;
    }
}