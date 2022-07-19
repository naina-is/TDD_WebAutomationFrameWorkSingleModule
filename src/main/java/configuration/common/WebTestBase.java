package configuration.common;

import com.etsy.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WebTestBase {
//    Create driver
    public static WebDriver driver;

//    Credentials for cloud environments
//    public static final String BROWSERSTACK_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String BROWSERSTACK_USERNAME = "demow_swyINW";
//    public static final String BROWSERSTACK_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String BROWSERSTACK_ACCESS_KEY = "sACtMguV8sBJyotVDtQE";
    public static final String BROWSERSTACK_URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeTest
    public void setupAutomation(){
        printLog("******************* Automation Started ********************");
    }

    @Parameters({"browserName","url"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browserName,@Optional("https://www.google.com") String url) {

//      String driverPath = "C:\\Users\\islam\\IdeaProjects\\WebAutomation\\BrowserDriver\\Windows\\chromedriver.exe";
        String driverPath = "../TDD_WebAutomationFrameWorkSingleModule/BrowserDriver/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        printLog("Browser: " + browserName);
        printLog("URL: " + url);
        driver = new ChromeDriver();
//        opens youtube homepage on chrome
        driver.get(url);
    }

    public static void printLog(final String message){
        Reporter.log(message, true);
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
            if (os.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDriver/Windows/chromedriver");
            } else if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDriver/Windows/chromedriver.exe");
            }
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
    public WebDriver getCloudDriver(String envName, String envAccessKey, String os, String osVersion, String browserName, String browserVersion) throws MalformedURLException {
        // Add the following capabilities to your test script
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);

        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("os", os);
        options.put("osVersion", osVersion);

        if (envName.equalsIgnoreCase("browserStack")){
            capabilities.setCapability("resolution", "1024x786");
            capabilities.setCapability("bstack:options", options);
            driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL),capabilities);
        } else if (envName.equalsIgnoreCase("sauceLabs")){

        }


        return driver;
    }
}
