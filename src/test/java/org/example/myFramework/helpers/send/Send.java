package org.example.myFramework.helpers.send;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Send {

    private WebDriver driver;

    public Send(WebDriver driver){

        this.driver = driver;
    }

    public Data text(String text){

        return new Data(this.driver, text);
    }
    public Data key(Keys keys){

        return new Data(this.driver, keys);
    }

}
