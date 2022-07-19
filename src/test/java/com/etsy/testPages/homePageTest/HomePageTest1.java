package com.etsy.testPages.homePageTest;

import com.etsy.pages.HomePage;
import com.etsy.pages.HomePage1;
import com.etsy.pages.HomePage2;
import configuration.common.WebTestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.etsy.pageElement.HomePageElements.*;
import static com.etsy.pages.HomePage.*;

public class HomePageTest1 extends WebTestBase {

    @Test(enabled = false)
    public static void verifySearchProductUsingInvalidProduct(){
        HomePage2 homePage2 = new HomePage2();
        homePage2.searchInvalidProduct();
//        searchInvalidProduct();
        String expectedProductName="We couldn't find any results for 23124MSNADN!!~#@$#";
        String actualProductName= driver.findElement(By.xpath(verifyInvalidSearchedProductWebElement)).getText();
        printLog("Actual Result: " + actualProductName);
        printLog("Expected Result: " + expectedProductName);
        Assert.assertEquals(actualProductName,expectedProductName,"Product name matches successfully");
    }

    @Test(enabled = false)
    public static void verifyRegisteredUserSignedIn() throws InterruptedException {
        SignInValidUser();
        String actualWelcomeMessage = driver.findElement(By.cssSelector(verifyRegisteredUserSignedInWelcomeMessage)).getText();
        String expectedWelcomeMessage = "Welcome back, Naina!";
        printLog("Expected Result: " + expectedWelcomeMessage);
        printLog("Actual Result: " + actualWelcomeMessage);
        Assert.assertEquals(actualWelcomeMessage,expectedWelcomeMessage,"Welcome messages do not match");
    }

    @Test(enabled = false)
    public static void verifyUnregisteredUserSignedIn() throws InterruptedException {
        SignInWithInValidUser();
        String actualResult = driver.findElement(By.cssSelector(verifyUnregisteredUserSignedInError)).getText();
        String expectedResult = "Email address is invalid.";
        printLog("Expected Result: " + expectedResult);
        printLog("Actual Result: " + actualResult);
        Assert.assertEquals(actualResult,expectedResult,"Invalid email successfully logged in");
    }

    @Test(enabled = false)
    public static void verifyFrenchLanguageSettingsChanged() throws InterruptedException {
        LanguageSettingsFrench();
        String actualResult = driver.findElement(By.xpath(verifySpecificLanguageSetting)).getText();
        String expectedResult = "Economisez sur de fabuleuses trouvailles venant de créateurs locaux avec nos soldes d'été.";
        printLog("Actual Result: "+actualResult);
        printLog("Expected Result: " + expectedResult);
        Assert.assertEquals(actualResult,expectedResult,"Language changed to French unsuccessful");
    }

    @Test(enabled = false)
    public static void verifyChineseLanguageSettingsChanged() throws InterruptedException {
        LanguageSettingsChinese();
        String actualResult = driver.findElement(By.xpath(verifySpecificLanguageSetting)).getText();
        String expectedResult = "お気に入りの一点を見つけましょう。独立セラーを支援しましょうEtsy ならでは。";
        printLog("Actual Result: "+actualResult);
        printLog("Expected Result: " + expectedResult);
        Assert.assertEquals(actualResult,expectedResult,"Language changed to Chinese unsuccessful");

    }

    @Test(enabled = false)
    public static void verifyPolishLanguageSettingsChanged() throws InterruptedException{
        LanguageSettingsPolish();
        String actualResult = driver.findElement(By.xpath(verifySpecificLanguageSetting)).getText();
        String expectedResult = "Znajdź rzeczy, które pokochasz. Wspieraj niezależnych sprzedawców. Tylko na Etsy.";
        printLog("Actual Result: "+actualResult);
        printLog("Expected Result: " + expectedResult);
        Assert.assertEquals(actualResult,expectedResult,"Language changed to Polish unsuccessful");

    }

    @Test(enabled = false)
    public static void verifyFreeShippingFilterWorks() throws InterruptedException {
        FreeShippingFilter();
        String actualResult = driver.findElement(By.cssSelector(verifyFreeShippingFilterisAppliedWebElement)).getText();
        String expectedResult = "FREE shipping";
        printLog("Actual Result: "+actualResult);
        printLog("Expected Result: " + expectedResult);
        Assert.assertEquals(actualResult,expectedResult,"Free Shipping filter unsuccessful");

    }

//    Two Approaches to instantiate driver in test class
//    1. Constructor with Page Factory
//    2. @Before Method with Page Factory

}
