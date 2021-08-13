package org.example.myFramework.helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseHelper {

    protected WebDriver driver;
    Logger logger = LoggerFactory.getLogger(BaseHelper.class);

    public      BaseHelper(WebDriver driver) {

        this.driver = driver;
    }
    protected   WebDriver getDriver(){

        return this.driver;
    }

    /**
     * Данный метод создает скриншот страницы
     * и сохраняет его в дирректорию screenshots в
     * корне проекта. Название скриншота будет соответствовать
     * времени создания скриншота.
     */
    public void takeScreenshot()
    {
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);

        String sd = "screenshots/" + scrDir();
        String sf = "SCR_" + scrFile() + ".jpg";

        File destFile = new File(sd + "/" + sf);

        try {
            FileUtils.copyFile(scrFile, destFile);
            logger.info("screenshot has been created with name: " + sf + " in " + sd + " folder");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String scrDir()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    private String scrFile()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

}
