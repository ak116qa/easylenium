package org.example.myFramework.helpers.wait;

import org.example.data.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHelper(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Данный метод приостанавливает выполнение теста на
     * переданное кол-во миллисекунд
     * @param milliseconds время ожидания в миллисекундах
     */
    public void time(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public WebElement untilElementToBeClickable(WebElement element){

        return new WebDriverWait(driver, Configuration.GLOBAL_TIMEOUTS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebElement untilElementToBeClickable(By by){

        return new WebDriverWait(driver, Configuration.GLOBAL_TIMEOUTS)
                .until(ExpectedConditions.elementToBeClickable(by));
    }
    public WebElement untilElementToBeVisible(WebElement element){

        return new WebDriverWait(driver, Configuration.GLOBAL_TIMEOUTS)
                .until(ExpectedConditions.visibilityOf(element));
    }

}
