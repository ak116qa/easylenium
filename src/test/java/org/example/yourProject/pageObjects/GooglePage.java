package org.example.yourProject.pageObjects;

import org.example.data.Configuration;
import org.example.myFramework.BasePage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GooglePage extends BasePage {

    public final String PAGE_URL = "https://www.google.com/";

    public GooglePage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='Google']")
    public WebElement logoGoogle;

    @FindBy(name = "q")
    public WebElement inputSearch;

    @FindAll(@FindBy(xpath = "//h3"))
    public List<WebElement> searchResultHeaders;

    public void printAllSearchResults(){

        searchResultHeaders.forEach(e -> System.out.println(e.getText()));
    }

    public void searchText(String text){

        inputSearch.clear();

        inputSearch.sendKeys(text);

        inputSearch.sendKeys(Keys.ENTER);

        new WebDriverWait(driver, Configuration.GLOBAL_TIMEOUTS)
                .until(ExpectedConditions.visibilityOfAllElements(searchResultHeaders));
    }

}
