package org.example.yourProject.tests;

import org.example.myFramework.BaseTestUI;
import org.example.yourProject.pageObjects.GooglePage;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleTests extends BaseTestUI {

    private GooglePage page;

    @BeforeClass
    public void preconditions(){

        page = new GooglePage(driver);
    }


    @Test(description = "go to google page and take screenshot")
    public void goToGooglePageAndTakeScreenshot(){

        goTo().page(page.PAGE_URL);

        w8().untilElementToBeVisible(page.logoGoogle);

        app().takeScreenshot();

    }

    @Test(description = "send text selenium to search input and send enter key")
    public void searchSeleniumRequest(){

        goTo().page(page.PAGE_URL);

        send()
                .text("Selenium")
                .to(page.inputSearch);

        send()
                .key(Keys.ENTER)
                .to(page.inputSearch)
                .andSleep(1000);

        page.printAllSearchResults();

        app().takeScreenshot();

    }

    @Test(description = "search text Selenium and click to first result")
    public void searchSeleniumRequestAndClick(){

        goTo().page(page.PAGE_URL);

        page.searchText("Selenium");

        click()
                .to(page.searchResultHeaders.get(0))
                .andSleep(2000);

        app().takeScreenshot();
    }

}
