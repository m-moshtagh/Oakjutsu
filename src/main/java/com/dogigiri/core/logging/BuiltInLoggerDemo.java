package com.dogigiri.core.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuiltInLoggerDemo {
    private static final Logger LOGGER = Logger.getLogger(BuiltInLoggerDemo.class.getName());
    static {
        LOGGER.setLevel(Level.FINER);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINER);
        LOGGER.addHandler(consoleHandler);
    }
    public static void main(String[] args) {
        LOGGER.log(Level.FINER, "This is java.util Logger instance");
    }
}
