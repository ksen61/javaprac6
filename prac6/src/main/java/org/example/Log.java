package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
    private String className;
    private PrintWriter infoWriter;
    private PrintWriter errorWriter;

    public Log(String className) {
        this.className = className;
        try {
            infoWriter = new PrintWriter(new FileWriter(className + "_info.log", true));
            errorWriter = new PrintWriter(new FileWriter(className + "_error.log", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logInfo(String message) {
        String logMessage = "[" + className + "] [INFO] " + message;
        System.out.println(logMessage);
        infoWriter.println(logMessage);
    }

    public void logError(String message) {
        String logMessage = "[" + className + "] [ERROR] " + message;
        System.err.println(logMessage);
        errorWriter.println(logMessage);
    }

    public void close() {
        infoWriter.close();
        errorWriter.close();
    }
}
