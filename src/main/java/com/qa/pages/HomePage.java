package com.qa.pages;

import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import com.qa.util.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class HomePage {
    private WebDriver driver;
    private ConfigReader configReader;
    ElementUtil elementUtil;
    JavaScriptUtil javaScriptUtil;

    //Locator
    private final By popupDismiss = By.xpath(".//*[@class='ext-popup-cross']");
    private final By categoryMenuOption = By.xpath("//nav[contains(@class,'header__nav header__nav--categories')]");
    private final By categoryList = By.xpath(".//div[contains(@class,'header-navigation__nav-inner')]//ul[contains(@class,'header__nav-category-list')]/li/dl[contains(@class,'header__nav-category--is-level-1')]/dt/a");
    private final By subCategoryList = By.xpath("//div[contains(@class,'header-navigation__nav-inner')]//ul[contains(@class,'header__nav-category-list')]/li/dl[contains(@class,'header__nav-category--is-level-2')]/dt/following-sibling::dd/ul/li/a");

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
        configReader = new ConfigReader();
        javaScriptUtil = new JavaScriptUtil(driver);
    }

    //page Action
    public void clickOnPopUp() {
        elementUtil.waitForElementToBeClickable(popupDismiss,30);
        elementUtil.doClick(popupDismiss);
    }
    public void setCategoryAndSubCategory(String category,String subCategory){
        elementUtil.waitForRequiredSec(3);
        elementUtil.doActionsMoveToElement(categoryMenuOption);
        elementUtil.waitForRequiredSec(3);
        elementUtil.selectRequiredItemAndSubItem(categoryList,subCategoryList,category,subCategory);
    }
    public boolean verifyCurrentURL(String expectedUrl){
        return elementUtil.waitForUrl(30, expectedUrl);
    }

}
