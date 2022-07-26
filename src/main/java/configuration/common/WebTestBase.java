package configuration.common;

import com.etsy.pages.HomePage;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Reporter;
//import org.testng.annotations.*;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;

import com.etsy.pages.HomePage2;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import configuration.reporting.ExtentManager;
import configuration.reporting.ExtentTestManager;
import configuration.utilities.ReadProperties;
import configuration.utilities.ReadSystemProperties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

public class WebTestBase {
//    Create driver
    public static WebDriver driver;

//    read properties
static Properties readProperty = ReadProperties.loadProperties("src/main/resources/config.properties");
//    String getBrowserStackUserName=readProperty.getProperty("BROWSERSTACK_USERNAME");
//    Credentials for cloud environments
//    Temp Email for BrowserStack: hicarow810@runfons.com and pass: Test1234
//    Temp Email for SauceLabs: hicarow810@runfons.com and Username:hicarow810 and pass: Test1234!
    public static final String BROWSERSTACK_USERNAME = "demow_swyINW";
    public static final String BROWSERSTACK_ACCESS_KEY = "sACtMguV8sBJyotVDtQE";
//    public static final String BROWSERSTACK_URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static final String BROWSERSTACK_URL = "https://" + readProperty.getProperty("BROWSERSTACK_USERNAME") + ":" + readProperty.getProperty("BROWSERSTACK_ACCESS_KEY") + "@hub-cloud.browserstack.com/wd/hub";

    public static final String SAUCELABS_USERNAME = "hicarow810";
    public static final String SAUCELABS_ACCESS_KEY = "24474fb3-c57e-4325-b83b-6223efd9e75c";
    public static final String SAUCELABS_URL = "https://" + SAUCELABS_USERNAME + ":" + SAUCELABS_ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    @BeforeTest
    public void setupAutomation(){
        printLog("******************* Automation Started ********************");
    }


    @Parameters({"useCloudEnv","cloudEnvName","os","osVersion","browserName","browserVersion","url"})
    @BeforeMethod
    public void setup(@Optional("false") boolean useCloudEnv,@Optional("sauceLabs") String cloudEnvName,@Optional("OS X") String os,@Optional("Big Sur") String osVersion,@Optional("chrome") String browserName,@Optional("100") String browserVersion,@Optional("https://www.google.com") String url) throws MalformedURLException {
        if(useCloudEnv){
            if (cloudEnvName.equalsIgnoreCase("browserStack") || (cloudEnvName.equalsIgnoreCase("sauceLabs"))) {
                getCloudDriver(cloudEnvName, os, osVersion, browserName, browserVersion);
            }
        } else {
            getLocalDriver(os,browserName);
        }

        printLog("Browser: " + browserName);
        printLog("URL: " + url);
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //wait up to 30sec if there are network,software, other issues etc.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().deleteAllCookies();
//        opens etsy homepage on chrome
        driver.get(url);
    }


//    /**
//     * This method retrieves the url from the config.properties file to automate etsy.com
//     * This method will accept urls based on environment from the command line during the execution
//     * @param useCloudEnv
//     * @param cloudEnvName
//     * @param os
//     * @param osVersion
//     * @param browserName
//     * @param browserVersion
//     * @throws MalformedURLException
//     */
//    @Parameters({"useCloudEnv","cloudEnvName","os","osVersion","browserName","browserVersion"})
//    @BeforeMethod
//    public void setup(@Optional("false") boolean useCloudEnv,@Optional("sauceLabs") String cloudEnvName,@Optional("OS X") String os,@Optional("Big Sur") String osVersion,@Optional("chrome") String browserName,@Optional("100") String browserVersion) throws MalformedURLException {
//        if(useCloudEnv){
//            if (cloudEnvName.equalsIgnoreCase("browserStack") || (cloudEnvName.equalsIgnoreCase("sauceLabs"))) {
//                getCloudDriver(cloudEnvName, os, osVersion, browserName, browserVersion);
//            }
//        } else {
//            getLocalDriver(os,browserName);
//        }
//
//        printLog("Browser: " + browserName);
//        printLog("URL: " + ReadSystemProperties.getEnvUrl());
////        driver = new ChromeDriver();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
////        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//        driver.manage().deleteAllCookies();
////        opens etsy homepage on chrome
//        driver.get(ReadSystemProperties.getEnvUrl());
//    }

    public static String captureScreenshotWithPath(WebDriver driver, String screenShotName){
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String fileName = System.getProperty("user.dir")+"/Screenshots/"+screenShotName+"_"+dateName+".png";
        try {
            FileUtils.copyFile(file,new File(fileName));
            printLog("Screenshot Captured");
        } catch (IOException e) {
            printLog("Exception while taking Screenshot"+e.getMessage());
        }
        return fileName;
    }
    public static void printLog(final String message){
        Reporter.log(message, true);
    }

    /**
     * **************************************************
     * ********** Start Of Reporting Utilities **********
     * **************************************************
     * **************************************************
     */
    //ExtentReport
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) throws Exception {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }
        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            //logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
            // logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
            String screenshotPath = captureScreenshotWithPath(driver, result.getName());
            //To add it in the extent report
            //   logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));

//            if (result.getStatus() == ITestResult.FAILURE) {
//                captureScreenShotWithPath(driver, result.getName());
//                logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
//            }

        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();

        // driver.close();
        //driver.quit();
        // ending test
        //endTest(logger) : It ends the current test and prepares to create HTML report
        extent.endTest(logger);
    }

    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }


    public static String convertToString(String st) {
        String splitString = "";
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }


    @AfterMethod
    public void tearDownAutomation() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

    @AfterTest
    public static void tearDownAutomationMessage(){
        printLog("******************* Automation Ended ********************");
    }

    public WebDriver getLocalDriver(String os, String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
//            if (os.equalsIgnoreCase("OS X")){
////                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDriver/Mac/chromedriver");
//            } else if (os.equalsIgnoreCase("windows")) {
//                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDriver/Windows/chromedriver.exe");
//            }
//            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDriver/Windows/chromedriver.exe");
//            }
            driver= new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("chrome-options")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");
            options.addArguments("--start-maximized");
            ChromeOptions capability = new ChromeOptions();
            capability.setCapability(ChromeOptions.CAPABILITY,options);
            if (os.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDriver/Windows/chromedriver");
            } else if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDriver/Windows/chromedriver.exe");
            }
            driver = new ChromeDriver();
        }
        return driver;
    }

//    https://automate.browserstack.com/dashboard/v2/quick-start/integrate-test-suite-step#integrate-your-test-suite-with-browserstack
//https://app.saucelabs.com/platform-configurator
    public WebDriver getCloudDriver(String envName, String os, String osVersion, String browserName, String browserVersion) throws MalformedURLException {
        // Add the following capabilities to your test script
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);

        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("os", os);
        options.put("osVersion", osVersion);

        if (envName.equalsIgnoreCase("browserStack")){
//            capabilities.setCapability("resolution", "1024x786");
            capabilities.setCapability("bstack:options", options);
            driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL),capabilities);

        } else if (envName.equalsIgnoreCase("sauceLabs")){
            capabilities.setCapability("sauce:options", options);
//            URL url = new URL("https://hicarow810:24474fb3-c57e-4325-b83b-6223efd9e75c@ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(new URL(SAUCELABS_URL), capabilities);
        }
        return driver;
    }

public static void waitFor(int seconds) throws InterruptedException {
        Thread.sleep(1000*seconds);
}

}
