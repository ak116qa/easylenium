package org.example.myFramework.helpers;

import org.openqa.selenium.WebDriver;

import java.net.URL;

public class NavigationHelper extends BaseHelper{

    public NavigationHelper(WebDriver driver) {

        super(driver);
    }

    public void page(String pageURL){

        if (!driver.getCurrentUrl().equals(pageURL)){

            getDriver().navigate().to(pageURL);
        }

    }
    public void page(URL pageURL){

        getDriver().navigate().to(pageURL);
    }
    public void back(){

        getDriver().navigate().back();
    }
    public void forward(){

        getDriver().navigate().forward();
    }

}
