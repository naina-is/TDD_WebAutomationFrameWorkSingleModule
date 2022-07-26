package com.etsy.pages;

import configuration.common.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static configuration.common.GlobalReusableMethods.*;

public class AboutPage extends WebTestBase {
//Reusable methods being called

    public void verifyAboutUsButton(){
        clickOnElementByXpath("3345345435");
    }

    @FindBy(xpath = "4234324") public static WebElement about;
    @FindBy(xpath = "4234324") public List<WebElement> aboutList;

    public void search(){
        clickOnElementByXpath(String.valueOf(about));
        waitUntilClickable(about);
        explicitWaitForElementUsingVisibilityOf(about).click();
        fluentwaitUntilConditionMeets(about).click();
//        to help select any item from dropdown list
        selectByVisibleTextFromSelect(about,"Newest");
        selectByIndexFromSelect(about,4);
        selectByValueFromSelect(about,"Highest");
        getListOfStrings(aboutList);
    }

}
