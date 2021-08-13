package org.example.myFramework;

import org.example.data.Configuration;
import org.example.myFramework.helpers.BaseHelper;
import org.example.myFramework.helpers.NavigationHelper;
import org.example.myFramework.helpers.click.Click;
import org.example.myFramework.helpers.send.Send;
import org.example.myFramework.helpers.wait.WaitHelper;
import org.example.myFramework.managers.BrowserManager;
import org.example.myFramework.managers.DriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTestUI {

    public final Logger logger = LoggerFactory.getLogger(BaseTestUI.class);

    protected static WebDriver driver;

    private BaseHelper baseHelper;
    private Send send;
    private Click click;
    private NavigationHelper navigationHelper;
    private WaitHelper waitHelper;
    private BrowserManager browserManager;

    private final String os = System.getProperty("os", Configuration.OPERATION_SYSTEM);
    private final String browser = System.getProperty("browser", Configuration.BROWSER);
    private final String headless = System.getProperty("mode", Configuration.HEADLESS);

    @BeforeSuite(description = "Demo Before Suite", alwaysRun = true)
    public void setUp() {

        logger.info("start before suite...");
        logger.info("start selenium web driver with params:");
        logger.info("os: " + Configuration.OPERATION_SYSTEM);
        logger.info("browser: " + Configuration.BROWSER);
        logger.info("headless mode: " + Configuration.HEADLESS);

        driver = new DriverManager().getDriver(os, browser, headless);

        Dimension dimension = new Dimension(

                Configuration.BROWSER_WIDTH,
                Configuration.BROWSER_HEIGHT
        );

        logger.info("set browser dimension: " + Configuration.BROWSER_WIDTH + "x" + Configuration.BROWSER_HEIGHT);
        browser().setDimension(dimension);
    }

    @AfterSuite(description = "Demo After Suite", alwaysRun = true)
    public void tearDown() {

        if (driver != null) {

            logger.info("kill driver...");
            driver.quit();
        }
    }

    protected BaseHelper app() {

        if (this.baseHelper == null) {
            return new BaseHelper(driver);
        } else {
            return baseHelper;
        }
    }

    protected BrowserManager browser() {

        if (browserManager == null) {
            return new BrowserManager(driver);
        } else {
            return browserManager;
        }
    }

    protected Send send() {

        if (this.send == null) {
            return new Send(driver);
        } else {
            return this.send;
        }
    }

    protected Click click() {

        if (this.click == null) {
            return new Click(driver);
        } else {
            return this.click;
        }
    }

    protected NavigationHelper goTo() {

        if (this.navigationHelper == null) {
            return new NavigationHelper(driver);
        } else {
            return this.navigationHelper;
        }
    }

    protected WaitHelper w8() {

        if (this.waitHelper == null) {
            return new WaitHelper(driver);
        } else {
            return this.waitHelper;
        }
    }

}
