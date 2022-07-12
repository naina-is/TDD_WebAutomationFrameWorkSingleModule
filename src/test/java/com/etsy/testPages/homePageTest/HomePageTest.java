package com.etsy.testPages.homePageTest;

import configuration.common.WebTestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.etsy.pageElement.HomePageElements.*;
import static com.etsy.pages.HomePage.*;

public class HomePageTest extends WebTestBase {

//    @Test
    //    Verification method
    public static void verifySearchProductUsingInvalidProduct(){
        searchInvalidProduct();
        String expectedProductName="We couldn't find any results for 23124MSNADN!!~#@$#";
        String actualProductName= driver.findElement(By.xpath(verifyInvalidSearchedProductWebElement)).getText();
        System.out.println("Actual Result: " + actualProductName);
        System.out.println("Expected Result: " + expectedProductName);
        Assert.assertEquals(actualProductName,expectedProductName,"Product name matches successfully");
    }

//    @Test
    public static void verifyRegisteredUserSignedIn() throws InterruptedException {
        SignInValidUser();
        String actualWelcomeMessage = driver.findElement(By.cssSelector(verifyRegisteredUserSignedInWelcomeMessage)).getText();
        String expectedWelcomeMessage = "Welcome back, Naina!";
        System.out.println("Expected Result: " + expectedWelcomeMessage);
        System.out.println("Actual Result: " + actualWelcomeMessage);
        Assert.assertEquals(actualWelcomeMessage,expectedWelcomeMessage,"Welcome messages do not match");
    }

//    @Test
    public static void verifyUnregisteredUserSignedIn() throws InterruptedException {
        SignInWithInValidUser();
        String actualResult = driver.findElement(By.cssSelector(verifyUnregisteredUserSignedInError)).getText();
        String expectedResult = "Email address is invalid.";
        System.out.println("Expected Result: " + expectedResult);
        System.out.println("Actual Result: " + actualResult);
        Assert.assertEquals(actualResult,expectedResult,"Invalid email successfully logged in");
    }

//    @Test
    public static void verifyFrenchLanguageSettingsChanged() throws InterruptedException {
        LanguageSettingsFrench();
        String actualResult = driver.findElement(By.xpath(verifySpecificLanguageSetting)).getText();
        String expectedResult = "Economisez sur de fabuleuses trouvailles venant de créateurs locaux avec nos soldes d'été.";
        System.out.println("Actual Result: "+actualResult);
        System.out.println("Expected Result: " + expectedResult);
        Assert.assertEquals(actualResult,expectedResult,"Language changed to French unsuccessful");
    }

//    @Test
    public static void verifyChineseLanguageSettingsChanged() throws InterruptedException {
        LanguageSettingsChinese();
        String actualResult = driver.findElement(By.xpath(verifySpecificLanguageSetting)).getText();
        String expectedResult = "お気に入りの一点を見つけましょう。独立セラーを支援しましょうEtsy ならでは。";
        System.out.println("Actual Result: "+actualResult);
        System.out.println("Expected Result: " + expectedResult);
        Assert.assertEquals(actualResult,expectedResult,"Language changed to Chinese unsuccessful");

    }

//    @Test
    public static void verifyPolishLanguageSettingsChanged() throws InterruptedException{
        LanguageSettingsPolish();
        String actualResult = driver.findElement(By.xpath(verifySpecificLanguageSetting)).getText();
        String expectedResult = "Znajdź rzeczy, które pokochasz. Wspieraj niezależnych sprzedawców. Tylko na Etsy.";
        System.out.println("Actual Result: "+actualResult);
        System.out.println("Expected Result: " + expectedResult);
        Assert.assertEquals(actualResult,expectedResult,"Language changed to Polish unsuccessful");

    }

    @Test
    public static void verifyFreeShippingFilterWorks() throws InterruptedException {
        FreeShippingFilter();
        String actualResult = driver.findElement(By.cssSelector(verifyFreeShippingFilterisAppliedWebElement)).getText();
        String expectedResult = "FREE shipping";
        System.out.println("Actual Result: "+actualResult);
        System.out.println("Expected Result: " + expectedResult);
        Assert.assertEquals(actualResult,expectedResult,"Free Shipping filter unsuccessful");

    }


}
