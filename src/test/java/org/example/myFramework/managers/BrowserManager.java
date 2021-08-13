package org.example.myFramework.managers;

import org.example.myFramework.helpers.BaseHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserManager extends BaseHelper {

    public BrowserManager(WebDriver driver) {

        super(driver);
    }

    public void             setDimension(Dimension dimension){

        getDriver().manage().window().setSize(dimension);
    }
    public void             setDimension(int width, int height){

        Dimension dimension = new Dimension(width, height);
        getDriver().manage().window().setSize(dimension);
    }
    public void             refresh(){

        getDriver().navigate().refresh();
    }
    public Set<String> getWindowHandles(){

        return driver.getWindowHandles();
    }
    public String           getWindowHandle(){

        return driver.getWindowHandle();
    }

}
