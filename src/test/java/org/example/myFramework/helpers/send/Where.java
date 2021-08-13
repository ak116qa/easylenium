package org.example.myFramework.helpers.send;

import org.example.data.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Where {

    private WebDriverWait wait;

    public Where(WebDriver driver){

        this.wait = new WebDriverWait(driver, Configuration.GLOBAL_TIMEOUTS);
    }

    public void     andClickTo(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void     andClickBy(By by){

        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public Where    andSleep(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

}
