package Commands;

import Loggers.LoggerInfo;
import SystemVouchers.SystemVouchers;

import java.util.Scanner;

public abstract class Command {

    protected String title;
    protected SystemVouchers systemVouchers;
    protected LoggerInfo loggerInfo;
    protected Scanner scanner;

    public Command(String title) {
        this.title = title;
        this.systemVouchers = SystemVouchers.getInstance();
        this.loggerInfo = LoggerInfo.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public abstract void execute();

    public String getTitle() {
        return title;
    }

    public void setVouchers(SystemVouchers systemVouchers) {
        this.systemVouchers = systemVouchers;
    }

    public void setLoggerInfo(LoggerInfo loggerInfo) {
        this.loggerInfo = loggerInfo;
    }
}