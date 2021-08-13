package org.example.myFramework.helpers.click;

import org.example.myFramework.helpers.wait.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Action {

    private WebDriver driver;

    public Action(WebDriver driver)
    {
        this.driver = driver;
    }

    public Conditions andWaitUntil(WebElement element){

        return new Conditions(this.driver, element);
    }
    public Conditions andWaitUntil(By by){

        return new Conditions(this.driver, by);
    }
    public Action andSleep(int milliseconds){

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }
    public WaitHelper andWait(){

        return new WaitHelper(driver);
    }

}
