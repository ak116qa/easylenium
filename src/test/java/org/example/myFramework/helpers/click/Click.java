package org.example.myFramework.helpers.click;

import org.example.data.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Click {

    private WebDriver driver;
    private WebDriverWait wait;

    public Click(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Configuration.GLOBAL_TIMEOUTS);
    }

    public Action to(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        sleep(500);
        return new Action(this.driver);
    }
    public Action by(By by){

        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        sleep(500);
        return new Action(this.driver);
    }

    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
