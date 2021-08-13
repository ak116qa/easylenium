package org.example.myFramework.helpers.click;

import org.example.data.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Conditions {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;
    private By by;

    public Conditions(WebDriver driver, WebElement element){

        this.driver = driver;
        this.element = element;
        wait = new WebDriverWait(this.driver, Configuration.GLOBAL_TIMEOUTS);
    }
    public Conditions(WebDriver driver, By by){

        this.driver = driver;
        this.by = by;
        wait = new WebDriverWait(this.driver, Configuration.GLOBAL_TIMEOUTS);
    }

    public WebElement toBeVisible(){

        WebElement e;

        if (by == null){

            e = wait.until(ExpectedConditions.visibilityOf(element));

        } else if (element == null){

            e = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        } else {

            throw new RuntimeException("Не передан элемент, который нужно ожидать");
        }

        return e;
    }

}
