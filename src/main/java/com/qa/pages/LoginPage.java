package com.qa.pages;

import com.qa.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {
    private WebDriver driver;
    ElementUtil elementUtil;

    //Locator
    private final By loginSignUpButton = By.xpath(".//div[text()='Login / Signup']");
    private final By loginButton = By.xpath(".//span[text()='Login']");
    private final By useEmailAddressButton = By.xpath(".//span[text()='Use Email Address']");
    private final By emailText = By.xpath(".//input[@type='email']");
    private final By nextButton = By.xpath(".//span[text()='Next']");
    private final By password = By.xpath(".//input[@type='password']");
    private final By logOutDropdown = By.xpath(".//div[contains(@class,'header__account-menu--dropdown absolute')]/a");
    private final By logOutLink = By.xpath("//div[@class='ml-1']");

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    //page Action
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
    public void setPassword(String pwd) {
        elementUtil.doSendKeys(password, pwd);
    }
    public boolean logOutButtonIsAvailable(String logOut){
        elementUtil.waitForRequiredSec(3);
        elementUtil.doActionsMoveToElement(logOutLink);
        return elementUtil.verifyElementInDropDownList(logOutDropdown,logOut);
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
