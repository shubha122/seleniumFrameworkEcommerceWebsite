package appHooks;

import com.qa.factory.DriverFactory;
import com.qa.util.Browser;
import com.qa.util.BrowserUtility;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.Scanner;

public class ApplicationHooks {
    Logger log = Logger.getLogger(ApplicationHooks.class);
    BrowserUtility browserUtility;
    private ConfigReader configReader;
    Properties prop;
    private DriverFactory driverFactory;
    private WebDriver driver;

    @Before(order = 0)
    public void getProperty(){
        log.info("Capturing the Config Properties");
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }
    @Before(order = 1)
    public void launchBrowser(){
        log.info("Driver initialization for required Browser");
        browserUtility = new BrowserUtility();
        Browser browser = browserUtility.getBrowser(prop);
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(prop,browser);
    }
    @Before(order = 2)
    public void launchUrl(){
        log.info("shopback url is launched");
        prop = configReader.init_prop();
        driver.get(prop.getProperty("url"));
    }
    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }
    @After(order = 1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            log.error("Capturing Screenshot for Failed Test cases.");
            String screenshotName = scenario.getName().replaceAll("","_") ;
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenshotName);
        }

    }
}
