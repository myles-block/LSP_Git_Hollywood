package org.howard.edu.lsp.exam.problem51;

public class Logger {
    private static Logger instance;
    private String log;

    private Logger() {
        this.log = "";
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logMessage(String message) {
        this.log += message + "\n";
    }

    public String displayLog() {
        return "Log:\n" + log;
    }
}