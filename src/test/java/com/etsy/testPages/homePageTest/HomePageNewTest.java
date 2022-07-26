package com.etsy.testPages.homePageTest;

import com.etsy.pages.HomePageNew;
import configuration.common.WebTestBase;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static configuration.common.GlobalReusableMethods.*;

public class HomePageNewTest extends WebTestBase {

    @Test
    public void verifySearchInvalidProduct(){
        HomePageNew homePageNew = new HomePageNew();
        homePageNew.searchInvalidProduct("23124MSNADN!!~#@$#");
        verifyText(HomePageNew.verifyInvalidSearch,"We couldn't find any results for "+"23124MSNADN!!~#@$#","Product is found");
    }
    @Test
    public void verifySearchInvalidProduct2(){
        HomePageNew homePageNew = new HomePageNew();
        homePageNew.searchInvalidProduct2("&#$*#^$@#^@^@");
        verifyText(HomePageNew.verifyInvalidSearch,"We couldn't find any results for "+"&#$*#^$@#^@^@","Product is found");
    }

//    @Test
    public static void verifyPhoneCaseIphone11Product() throws InterruptedException {
        HomePageNew homePageNew = new HomePageNew();
        homePageNew.searchValidProduct("phone case iphone 11");
        verifyText(homePageNew.verifyValidProductPhoneCase,"iphone 13 case, Pressed Dried Flower Handmade iPhone Case 8 8p Xr X XS Xsmax iPhone 11 11 Pro Max, iphone 12 11 Pro Max case","Product Name matches successfully" );
    }

}
