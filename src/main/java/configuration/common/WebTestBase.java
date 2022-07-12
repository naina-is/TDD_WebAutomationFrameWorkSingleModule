package configuration.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class WebTestBase {

    public static WebDriver driver;

//    String url = "https://www.etsy.com/";
    @BeforeTest
    public void setupAutomation(){
        System.out.println("******************* Automation Started ********************");
    }

    @Parameters({"browserName","url"})
    @BeforeMethod
    public void setup(String browserName, String url) {
//        String driverPath = "C:\\Users\\islam\\IdeaProjects\\WebAutomation\\BrowserDriver\\Windows\\chromedriver.exe";
        String driverPath = "../TDD_WebAutomationFrameWorkSingleModule/BrowserDriver/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
//        opens youtube homepage on chrome
        driver.get(url);
    }

    @AfterMethod
    public void tearDownAutomation() throws InterruptedException {
//        Thread.sleep(5000);
//        driver.close();
        System.out.println("******************* Automation Ended ********************");
    }
}
