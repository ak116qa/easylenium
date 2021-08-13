package org.example.myFramework.managers;

import org.example.data.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    public WebDriver getDriver(

            String operationSystem,
            String browser,
            String headless

    ) {

        String os = operationSystem.toLowerCase();
        String driver = browser.toLowerCase();

        final boolean h = headless.toLowerCase().trim().equals("true");

        switch (driver) {

            case "chrome":

                ChromeOptions chromeOptions = new ChromeOptions();

                // accept notification
                Map<String, Object> prefs = new HashMap<>();

                if (Configuration.NOTIFICATIONS.toLowerCase().equals("true")) {

                    prefs.put("profile.default_content_setting_values.notifications", 1);

                } else {

                    prefs.put("profile.default_content_setting_values.notifications", 0);

                }

                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");

                switch (os) {

                    case "nix":
                        System.setProperty("webdriver.chrome.driver", String.format("%s/chromedriver_linux", Configuration.PATH_TO_DRIVERS_DIR));
                        break;

                    case "osx":
                        System.setProperty("webdriver.chrome.driver", String.format("%s/chromedriver_osx", Configuration.PATH_TO_DRIVERS_DIR));
                        break;

                    case "win":
                        System.setProperty("webdriver.chrome.driver", String.format("%s/chromedriver_win.exe", Configuration.PATH_TO_DRIVERS_DIR));
                        break;

                    default:
                        throw new RuntimeException("Wrong os variable. Please use windows, linux or mac value.");
                }

                if (h) {

                    chromeOptions.addArguments("--headless");

                }

                return new ChromeDriver(chromeOptions);

            case "firefox":

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setLogLevel(FirefoxDriverLogLevel.INFO);

                switch (os) {

                    case "nix":
                        System.setProperty("webdriver.gecko.driver", String.format("%s/geckodriver_linux", Configuration.PATH_TO_DRIVERS_DIR));
                        break;

                    case "osx":
                        System.setProperty("webdriver.gecko.driver", String.format("%s/geckodriver_osx", Configuration.PATH_TO_DRIVERS_DIR));
                        break;

                    case "win":
                        System.setProperty("webdriver.gecko.driver", String.format("%s/geckodriver_win.exe", Configuration.PATH_TO_DRIVERS_DIR));
                        break;

                    default:
                        throw new RuntimeException("Wrong os variable. Please use windows, linux or mac value.");
                }

                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

                if (h) {
                    firefoxOptions.addArguments("-headless");
                }

                return new FirefoxDriver(firefoxOptions);

            case "safari":
                return new SafariDriver();

            default:
                throw new RuntimeException("Wrong browser variable. Please use chrome or firefox value");
        }
    }

}
