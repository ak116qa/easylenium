package org.example.myFramework.helpers.send;

import org.example.data.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Data {

    private WebDriver driver;
    private WebDriverWait wait;

    private String          text;
    private Keys key;

    public Data(WebDriver driver, String text){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Configuration.GLOBAL_TIMEOUTS);
        this.text = text;
    }
    public Data(WebDriver driver, Keys keys){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Configuration.GLOBAL_TIMEOUTS);
        this.key = keys;
    }

    public Where to(WebElement element){

        if (this.text == null) {
            element.sendKeys(key);
        } else {
            element.sendKeys(text);
            try {
                wait.until(ExpectedConditions.attributeToBe(element, "value", text));
            } catch (TimeoutException ex){
                ex.printStackTrace();
                throw new RuntimeException("Не удалось ввести текст в указанный элемент");
            }
        }
        return new Where(driver);
    }
    public Where by(By by){

        if (this.text == null) {
            driver.findElement(by).sendKeys(key);
        } else {
            driver.findElement(by).sendKeys(text);
            try {
                wait.until(ExpectedConditions.attributeToBe(by, "value", text));
            } catch (TimeoutException ex){
                ex.printStackTrace();
                throw new RuntimeException("Не удалось ввести текст в указанный элемент");
            }
        }

        return new Where(driver);
    }

}
