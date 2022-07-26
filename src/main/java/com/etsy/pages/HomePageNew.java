package com.etsy.pages;

import configuration.common.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//import static com.etsy.pageElement.HomePageElements.*;
import static com.etsy.pageElement.HomePageNewElements.*;
import static configuration.common.GlobalReusableMethods.*;

public class HomePageNew extends WebTestBase {

    public HomePageNew(){
        PageFactory.initElements(driver,this);
    }

//    @FindBy(how = How.XPATH,using = searchBoxWebElement) public static WebElement searchBox1;

    //    Modern Approach: @FindBy
    @FindBy(xpath = searchBoxWebElement) public WebElement searchBox;
    @FindBy(xpath = searchButtonWebElement) public static WebElement searchButton;
    @FindBy(xpath = phoneCaseIphone11WebElement) public static WebElement phoneCase;
    @FindBy(xpath = verifyPhoneCaseIphone11WebElement) public static WebElement verifyValidProductPhoneCase;
    @FindBy(xpath = verifyInvalidSearchedProductWebElement) public static WebElement verifyInvalidSearch;

    public void searchInvalidProduct(String productName){
//        searchBox.sendKeys("23124MSNADN!!~#@$#");
        enterValueOnElement(searchBox,"23124MSNADN!!~#@$#");
        clickOnElement(searchButton);
    }

    public void searchInvalidProduct2(String productName){
        enterValueOnElement(searchBox,"&#$*#^$@#^@^@");
        clickOnElement(searchButton);
    }
    public void searchValidProduct(String productName) throws InterruptedException {
//        searchBox.sendKeys("23124MSNADN!!~#@$#");
        enterValueOnElement(searchBox,"phone case iphone 11");
        clickOnElement(searchButton);
        waitFor(3);
//        clickOnElement(phoneCase);
        scrollDownToElement(phoneCase);
    }



}
