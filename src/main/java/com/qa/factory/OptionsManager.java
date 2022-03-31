package com.qa.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {
    Properties prop;
    private ChromeOptions chromeOptions;
    private FirefoxOptions firefoxOptions;

    public OptionsManager(Properties prop) {
        this.prop = prop;
    }
    public ChromeOptions getChromeOptions(){
        chromeOptions = new ChromeOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless").trim())) chromeOptions.addArguments("--headless");
        if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) chromeOptions.addArguments("--incognito");
        return chromeOptions;
    }
    public FirefoxOptions getFirefoxOptions(){
        firefoxOptions = new FirefoxOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless").trim())) firefoxOptions.addArguments("--headless");
        if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) firefoxOptions.addArguments("--incognito");
        return firefoxOptions;
    }


}
