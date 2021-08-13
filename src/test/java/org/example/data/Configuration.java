package org.example.data;

public class Configuration {

    public static final String  OPERATION_SYSTEM        = "nix";     // osx for mac; win for windows; nix for linux;
    public static final String  BROWSER                 = "firefox";  // chrome for Google Chrome; firefox for Mozilla Firefox;
    public static final String  HEADLESS                = "false";   // true for run tests in headless mode or false;
    public static final String  NOTIFICATIONS           = "true";    // true for enable push notifications;
    public static final Integer GLOBAL_TIMEOUTS         = 10;        // timeouts in seconds;
    public static final Integer BROWSER_WIDTH           = 1600;      // window width;
    public static final Integer BROWSER_HEIGHT          = 900;       // window height;

    public static final String  PATH_TO_DRIVERS_DIR     = "src/test/resources/drivers";

}
