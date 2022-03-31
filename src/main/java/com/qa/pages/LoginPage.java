package com.qa.pages;

import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class LoginPage {
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    ElementUtil elementUtil;

    //Locator
    private By loginSignUpButton = By.xpath(".//div[text()='Login / Signup']");
    private By loginButton = By.xpath(".//span[text()='Login']");
    private By useEmailAddressButton = By.xpath(".//span[text()='Use Email Address']");
    private By emailText = By.xpath(".//input[@type='email']");
    private By nextButton = By.xpath(".//span[text()='Next']");
    private By password = By.xpath(".//input[@type='password']");


    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
        configReader = new ConfigReader();
    }

    //page Action
    public void lauchURL() {
        prop = configReader.init_prop();
        driver.get(prop.getProperty("url"));
    }
    public void clickOnLoginSignUpButton() {
        elementUtil.doClick(loginSignUpButton);
    }
    public void clickOnLoginButton() {
        elementUtil.doClick(loginButton);
    }
    public void clickUseEmailAddressButton() {
        elementUtil.doClick(useEmailAddressButton);
    }
    public void setEmail(String email) {
        elementUtil.doSendKeys(emailText, email);
    }
    public void clickNextBtn() {
        elementUtil.doClick(nextButton);
    }
    public void setPassword(String pswd) {
        elementUtil.doSendKeys(password, pswd);
    }
    public boolean loginSignUpButtonIsNotVisible(){
        return elementUtil.doIsDisplayed(loginSignUpButton);
    }

    public HomePage doLogin(String email, String pwd) {
        elementUtil.doClick(loginSignUpButton);
        elementUtil.doClick(loginButton);
        elementUtil.doClick(useEmailAddressButton);
        elementUtil.doSendKeys(emailText, email);
        elementUtil.doClick(nextButton);
        elementUtil.doSendKeys(password, pwd);
        elementUtil.doClick(nextButton);
        return new HomePage(driver);
    }

}
