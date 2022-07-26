package com.etsy.pages;

import configuration.common.WebTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.etsy.pageElement.HomePageElements.*;
import static configuration.utilities.DataDriven.*;
import static configuration.utilities.DataProviderClass.getRegistrationDataFromExcel;

public class HomePage2 extends WebTestBase {
//    Action class for business flow
    public HomePage2(){
//        To Instantiate the driver when there is a null point exception
    PageFactory.initElements(driver,this);
    }
//    This method tests if the searchbox functionality works when an invalid product is searched
    public void searchInvalidProduct1(){
        driver.findElement(By.xpath(searchBoxWebElement)).sendKeys("23124MSNADN!!~#@$#");
        driver.findElement(By.xpath(searchButtonWebElement)).click();
    }

    public static List<String> getExpectedProducts() {
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("$#$#!!!!");
        itemsList.add(")))$#$--1");
        itemsList.add("##@^^@##");
        itemsList.add("%%#$#$))");
        itemsList.add("!@!@!@#@$#@$<>>");
        itemsList.add("$@#@???");
        itemsList.add("#$$&#&$#");
        itemsList.add("@!#@#$#$//");
        return itemsList;
    }

//    Data Driven Approach: Direct Data
    public void searchInvalidProduct2(){
        getExpectedProducts();

        for (String st:getItemValue()){
            searchBox.clear();
            searchBox.sendKeys(st);
            searchButton.click();
            String expectedProductName="We couldn't find any results for " + st;
            String actualProductName= driver.findElement(By.xpath(verifyInvalidSearchedProductWebElement)).getText();
            printLog("Actual Result: " + actualProductName);
            printLog("Expected Result: " + expectedProductName);
            Assert.assertEquals(actualProductName,expectedProductName,"Product name matches successfully");
        }

    }

    //    Data Driven Approach: Excel Data
    public void searchInvalidProduct3() throws Exception {

        for (int i = 0; i < getItemsListFromExcel().size(); i++) {
            searchBox.clear();
            searchBox.sendKeys(getExpectedProducts().get(i));
            searchButton.click();
            String expectedProductName="We couldn't find any results for " + getItemsListFromExcel().get(i+1);
            String actualProductName= driver.findElement(By.xpath(verifyInvalidSearchedProductWebElement)).getText();
            printLog("Actual Result: " + actualProductName);
            printLog("Expected Result: " + expectedProductName);
            Assert.assertEquals(actualProductName,expectedProductName,"Product name matches successfully");
            waitFor(3);
        }
    }

    //    Data Driven Approach: Database
    public void searchInvalidProduct4() throws Exception {
        for (String st:getItemsListFromDB()){
            searchBox.clear();
            searchBox.sendKeys(st);
            searchButton.click();
            String expectedProductName="We couldn't find any results for " + st;
            String actualProductName= driver.findElement(By.xpath(verifyInvalidSearchedProductWebElement)).getText();
            printLog("Actual Result: " + actualProductName);
            printLog("Expected Result: " + expectedProductName);
            Assert.assertEquals(actualProductName,expectedProductName,"Product name matches successfully");
        }
    }

    //    Data Driven Approach: Data Provider
    public void searchInvalidProduct5() throws Exception {

        for (int rowNum = 0; rowNum < getRegistrationDataFromExcel().length; rowNum++) {
            for (int columnNum = rowNum; columnNum < getRegistrationDataFromExcel()[rowNum].length; columnNum++) {
                System.out.println(getRegistrationDataFromExcel()[rowNum][columnNum]);
                searchBox.clear();
                String firstName = (String) getRegistrationDataFromExcel()[rowNum][columnNum];
                searchBox.sendKeys(firstName);
                waitFor(3);
                searchButton.clear();
                String lastName = (String) getRegistrationDataFromExcel()[rowNum][columnNum];

//                searchButton.click();
//                String expectedProductName="We couldn't find any results for " + st;
//                String actualProductName= driver.findElement(By.xpath(verifyInvalidSearchedProductWebElement)).getText();
//                printLog("Actual Result: " + actualProductName);
//                printLog("Expected Result: " + expectedProductName);
//                Assert.assertEquals(actualProductName,expectedProductName,"Product name matches successfully");

            }
        }

//        for (Object[] stt: getRegistrationDataFromExcel()) {
//            for (Object st:stt) {
//                searchBox.clear();
//                searchBox.sendKeys((String)st);
//                searchButton.click();
//                String expectedProductName="We couldn't find any results for " + st;
//                String actualProductName= driver.findElement(By.xpath(verifyInvalidSearchedProductWebElement)).getText();
//                printLog("Actual Result: " + actualProductName);
//                printLog("Expected Result: " + expectedProductName);
//                Assert.assertEquals(actualProductName,expectedProductName,"Product name matches successfully");
//
//            }
//        }

    }

    //    Modern Approach: @FindBy with how
//    @FindBy() public WebElement variableName
    @FindBy(how = How.XPATH,using = searchBoxWebElement) public static WebElement searchBox;
    //    Modern Approach: @FindBy
    @FindBy(xpath = searchBoxWebElement) public WebElement searchBox1;
    @FindBy(xpath = searchButtonWebElement) public static WebElement searchButton;
    public void searchInvalidProduct(){
        searchBox.sendKeys("23124MSNADN!!~#@$#");
        searchButton.click();
    }

    /**
     * 1. This method tests if sign in with valid user is successful
     * @throws InterruptedException
     */
    public static void SignInValidUser() throws InterruptedException{
        driver.findElement(By.cssSelector(signInButtonWebElement)).click();
        waitFor(3);
        driver.findElement(By.cssSelector(usernameWebElement)).sendKeys("islam.naina15@gmail.com");
        driver.findElement(By.cssSelector(passwordWebElement)).sendKeys("Test321!");
        driver.findElement(By.cssSelector(signInButtonAfterInputtingUsernameAndPassWebElement)).click();
        waitFor(3);
    }

    public static void SignInWithInValidUser() throws InterruptedException{
        driver.findElement(By.cssSelector(signInButtonWebElement)).click();
        waitFor(3);
        driver.findElement(By.cssSelector(usernameWebElement)).sendKeys("etsyuser@gmail.com");
        driver.findElement(By.cssSelector(passwordWebElement)).sendKeys("1234567");
        driver.findElement(By.cssSelector(signInButtonAfterInputtingUsernameAndPassWebElement)).click();
        waitFor(3);
    }

    public static void LanguageSettingsFrench() throws InterruptedException {
        driver.findElement(By.xpath(languageSettingsButtonWebElement)).click();
        waitFor(2);
        driver.findElement(By.cssSelector(regionDropdownMenuWebElement)).click();
        driver.findElement(By.cssSelector(franceRegionWebElement)).click();
        driver.findElement(By.cssSelector(languageDropdownMenuWebElement)).click();
        driver.findElement(By.cssSelector(frenchLanguageWebElement)).click();
        driver.findElement(By.cssSelector(currencyDropdownMenuWebElement)).click();
        driver.findElement(By.cssSelector(eurosCurrencyWebElement)).click();
        driver.findElement(By.xpath(saveLanguageButtonWebElement)).click();

    }

    public static void LanguageSettingsChinese() throws InterruptedException {
        driver.findElement(By.xpath(languageSettingsButtonWebElement)).click();
        waitFor(2);
        driver.findElement(By.cssSelector(regionDropdownMenuWebElement)).click();
        driver.findElement(By.cssSelector(ChinaRegionWebElement)).click();
        driver.findElement(By.cssSelector(languageDropdownMenuWebElement)).click();
        driver.findElement(By.cssSelector(ChineseLanguageWebElement)).click();
        driver.findElement(By.cssSelector(currencyDropdownMenuWebElement)).click();
        driver.findElement(By.cssSelector(chineseYuanCurrencyWebElement)).click();
        driver.findElement(By.xpath(saveLanguageButtonWebElement)).click();

    }

    public static void LanguageSettingsPolish() throws InterruptedException {
        driver.findElement(By.xpath(languageSettingsButtonWebElement)).click();
        waitFor(2);
        driver.findElement(By.cssSelector(regionDropdownMenuWebElement)).click();
        driver.findElement(By.cssSelector(polandRegionWebElement)).click();
        driver.findElement(By.cssSelector(languageDropdownMenuWebElement)).click();
        driver.findElement(By.cssSelector(polishLanguageWebElement)).click();
        driver.findElement(By.cssSelector(currencyDropdownMenuWebElement)).click();
        driver.findElement(By.cssSelector(polishZlotyCurrencyWebElement)).click();
        driver.findElement(By.xpath(saveLanguageButtonWebElement)).click();

    }


    public static void FreeShippingFilter() throws InterruptedException {
//        Click on sale button
        driver.findElement(By.xpath(saleButtonWebElement)).click();
//    Click on All filters button
        driver.findElement(By.cssSelector(allFiltersButtonWebElement)).click();
        waitFor(2);
//        Click on the free shipping checkbox
        driver.findElement(By.cssSelector(freeShippingCheckboxWebElement)).click();
//        Click on apply button
        driver.findElement(By.xpath(applyFilterButtonWebElement)).click();
        waitFor(2);
    }

}
