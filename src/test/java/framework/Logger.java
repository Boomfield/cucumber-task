package framework;

import org.testng.Reporter;

public class Logger {
    public static void logInfo(String message) {
        Reporter.log("[INFO] " + message);
    }

    public static void logFatal(String message) {
        Reporter.log("<br/><b style='color:red;'>[FATAL] " + message + "</b><br/>");
    }
}
