package com.qa.factory;

import com.qa.util.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public WebDriver driver;
    public static String highlight = "true";
    private OptionsManager optionsManager;
    public static ThreadLocal<WebDriver> tlDriver  = new ThreadLocal<>();

    public WebDriver init_driver(Properties prop, Browser browserName){
        highlight = prop.getProperty("highlight");
        optionsManager = new OptionsManager(prop);
        switch (browserName){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
                break;
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return getDriver();

    }
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
