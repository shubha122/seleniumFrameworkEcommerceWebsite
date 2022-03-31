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
    Properties prop;
    ElementUtil elementUtil;
    JavaScriptUtil javaScriptUtil;
    WebElement web;

    //Locator
    private By popupDismiss = By.xpath(".//*[@class='ext-popup-cross']");

//    private WebElement categoryLink = driver.findElement(By.xpath(".//div[@class='header__nav-category-mobile-section-title' and text()='Categories']"));
    private By selectSubCategory = By.xpath(".//*[@href='/product/category/Smartphone/82']");


//    Mobiles & Tablets
    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
        configReader = new ConfigReader();
        javaScriptUtil = new JavaScriptUtil(driver);
    }

    //page Action
    public void clickOnPopUp() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(popupDismiss));
        elementUtil.doClick(popupDismiss);
    }
    public void setSelectCategory(String category) throws InterruptedException {
        Thread.sleep(3000);
       WebElement web = elementUtil.getElement(selectSubCategory);
//        WebElement categoryLink = driver.findElement(By.xpath(".//div[@class='header__nav-category-mobile-section-title' and text()='Categories']"));
        javaScriptUtil.clickElementByJS(web);
        WebElement selectCategory = driver.findElement(By.xpath(".//a[text()='"+category+"']"));
        javaScriptUtil.clickElementByJS(selectCategory);
    }
    public ProductPage setSelectSubCategory(String subCategory) {
        WebElement subCategoryLocator = driver.findElement(By.xpath(".//a[text()='"+subCategory+"']"));
        javaScriptUtil.clickElementByJS(subCategoryLocator);
        return new ProductPage(driver);
    }
    public boolean verifyCurrentURL(String expectedUrl){
        return elementUtil.waitForUrl(30, expectedUrl);
    }


}
