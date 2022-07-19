package com.etsy.pages;

import configuration.common.WebTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.etsy.pageElement.HomePageElements.*;

public class HomePage1 extends WebTestBase {
//    Action class for business flow
    public HomePage1(WebDriver driver){
//        To Instantiate the driver when there is a null point exception
        PageFactory.initElements(driver,this);
    }
//    This method tests if the searchbox functionality works when an invalid product is searched
    public void searchInvalidProduct1(){
        driver.findElement(By.xpath(searchBoxWebElement)).sendKeys("23124MSNADN!!~#@$#");
        driver.findElement(By.xpath(searchButtonWebElement)).click();
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
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(usernameWebElement)).sendKeys("islam.naina15@gmail.com");
        driver.findElement(By.cssSelector(passwordWebElement)).sendKeys("Test321!");
        driver.findElement(By.cssSelector(signInButtonAfterInputtingUsernameAndPassWebElement)).click();
        Thread.sleep(3000);
    }

    public static void SignInWithInValidUser() throws InterruptedException{
        driver.findElement(By.cssSelector(signInButtonWebElement)).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(usernameWebElement)).sendKeys("etsyuser@gmail.com");
        driver.findElement(By.cssSelector(passwordWebElement)).sendKeys("1234567");
        driver.findElement(By.cssSelector(signInButtonAfterInputtingUsernameAndPassWebElement)).click();
        Thread.sleep(3000);
    }

    public static void LanguageSettingsFrench() throws InterruptedException {
        driver.findElement(By.xpath(languageSettingsButtonWebElement)).click();
        Thread.sleep(2000);
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
        Thread.sleep(2000);
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
        Thread.sleep(2000);
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
        Thread.sleep(2000);
//        Click on the free shipping checkbox
        driver.findElement(By.cssSelector(freeShippingCheckboxWebElement)).click();
//        Click on apply button
        driver.findElement(By.xpath(applyFilterButtonWebElement)).click();
        Thread.sleep(3000);
    }

}
