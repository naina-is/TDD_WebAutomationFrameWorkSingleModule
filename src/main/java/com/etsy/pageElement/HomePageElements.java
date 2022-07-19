package com.etsy.pageElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageElements {
//    Web element class to keep all the locators of this page

//  *********************  xpaths *********************

//    Search elements
    public static final String searchBoxWebElement="/descendant::input[@id='global-enhancements-search-query']";
    public static final String searchButtonWebElement="//*[@type='submit']//span";
    public static final String verifyInvalidSearchedProductWebElement="//div[@class='wt-bg-beeswax-tint wt-position-relative wt-overflow-hidden search-broadener-container']/descendant::p[2]";
//  Language setting elements
    public static final String languageSettingsButtonWebElement = "//div[@class='site-footer-tagline-links wt-pl-xs-4 wt-pr-xs-4 wt-pb-xs-3 wt-pt-xs-3']/div/child::div/a[@id='locale-picker-trigger']";
    public static final String saveLanguageButtonWebElement = "//*[@id='content']/div/form/div[4]/div/button";
    public static final String verifySpecificLanguageSetting = "//h1[@class='wt-body-max-width wt-text-heading-01']";

//    filters elements
    public static final String saleButtonWebElement = "//ul[@class='wt-grid wt-grid--block wt-justify-content-center wt-pt-xs-1 wt-pl-xs-1 wt-pr-xs-1 wt-pt-md-0 wt-pl-md-4 wt-pr-md-4 wt-pl-lg-6 wt-pr-lg-6']/descendant::li[6]";
    public static final String applyFilterButtonWebElement = "//*/button[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']";



    //  *****************  CSS Selectors  ************************

//    Sign in elements
    public static final String signInButtonWebElement = "div[class='wt-flex-shrink-xs-0']>nav>ul>li>button[class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']";
    public static final String usernameWebElement = "input#join_neu_email_field";
    public static final String passwordWebElement = "input#join_neu_password_field";
    public static final String signInButtonAfterInputtingUsernameAndPassWebElement = "div.wt-validation>button";
    public static final String verifyRegisteredUserSignedInWelcomeMessage = "#content > div > div:nth-child(1) > div:nth-child(2) > div > div > h1.welcome-message-text.line-clamp.wt-text-center-xs.wt-hide-xs.wt-show-lg.wt-mb-xs-3.wt-mb-md-3.wt-mt-xs-3.wt-mt-md-3.wt-text-heading-01";
    public static final String verifyUnregisteredUserSignedInError = "div#aria-join_neu_email_field-error";

//    Language settings elements
    public static final String regionDropdownMenuWebElement = "select#locale-overlay-select-region_code";
    public static final String languageDropdownMenuWebElement = "select#locale-overlay-select-language_code";
    public static final String currencyDropdownMenuWebElement = "select#locale-overlay-select-currency_code";

    public static final String franceRegionWebElement = "select#locale-overlay-select-region_code > option:nth-child(3)";
    public static final String frenchLanguageWebElement = "select#locale-overlay-select-language_code>option:nth-child(5)";
    public static final String eurosCurrencyWebElement = "select#locale-overlay-select-currency_code>option:nth-child(3)";

    public static final String ChinaRegionWebElement = "select#locale-overlay-select-region_code > optgroup > option:nth-child(44)";
    public static final String ChineseLanguageWebElement = "select#locale-overlay-select-language_code>option:nth-child(7)";
    public static final String chineseYuanCurrencyWebElement = "select#locale-overlay-select-currency_code>option:nth-child(7)";

    public static final String polandRegionWebElement = "select#locale-overlay-select-region_code > option:nth-child(10)";
    public static final String polishLanguageWebElement = "select#locale-overlay-select-language_code>option:nth-child(9)";
    public static final String polishZlotyCurrencyWebElement = "select#locale-overlay-select-currency_code>option:nth-child(29)";


//    filters elements
    public static final String allFiltersButtonWebElement = "button#search-filter-button";
    public static final String freeShippingCheckboxWebElement = "#search-filter-form > div > div.main-filters > div:nth-child(2) > fieldset > div > div > div:nth-child(1) > div > label";
    public static final String verifyFreeShippingFilterisAppliedWebElement = "#content > div > div.wt-bg-white.wt-grid__item-md-12.wt-pl-xs-1.wt-pr-xs-0.wt-pr-md-1.wt-pl-lg-0.wt-pr-lg-0.wt-bb-xs-1 > div > div.wt-mt-xs-3.wt-text-black > div.wt-grid.wt-pl-xs-0.wt-pr-xs-1.search-listings-group > div:nth-child(4) > div:nth-child(8) > ul > li > ul > li > a";





}
