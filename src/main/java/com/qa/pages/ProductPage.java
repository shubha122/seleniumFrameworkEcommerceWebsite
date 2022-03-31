package com.qa.pages;

import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import com.qa.util.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

public class ProductPage {
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    ElementUtil elementUtil;
    JavaScriptUtil javaScriptUtil;

    //Locators
    private By maxPriceLocator = By.xpath(".//input[@class='form-control border-none rounded' and @placeholder ='$ max']");
//    private By doneButton = By.xpath(".//button[text()='Done']");
    private By sortDropdown = By.xpath(".//div[@id='dropdown']");
    private By priceLowToHigh = By.xpath(".//li[text()='Price Low to High']");
//    private By nextPageLink = By.xpath(".//a[text()='2']");
    private By searchTextBox = By.xpath(".//input[@id='header-desktop-search-input']");
//    private By productList = By.xpath(".//*[@class='product-listing-content flex flex-wrap']/div[1]");

    //Constructor
    public ProductPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
        configReader = new ConfigReader();
        javaScriptUtil = new JavaScriptUtil(driver);
    }
    //page actions
    public void setProductDetails(String productName){
        elementUtil.doSendKeysAndEnter(searchTextBox,productName);
    }
    public void countListedProduct(){

    }
    public void clickOnProduct(){
         List<WebElement> productDetail = driver.findElements(By.xpath(".//a[@class='flex flex-col w-2/3 flex-auto text-neutral-700 no-underline']"));
         javaScriptUtil.clickElementByJS(productDetail.get(0));
    }
    public void filterBrandName() throws InterruptedException {
        Thread.sleep(5000);
        WebElement filterBrand= driver.findElement(By.id("brand-filter-47"));
        javaScriptUtil.clickElementByJS(filterBrand);
    }
    public void setMaxPrice(String maxPrice)  {
        elementUtil.doSendKeys(maxPriceLocator,maxPrice);
    }
    public void selectCashbackStore(){
        WebElement cashBackStroe = driver.findElement(By.id("store-filter-1"));
        javaScriptUtil.clickElementByJS(cashBackStroe);
    }
    public void clickOnDoneButton(){
        WebElement doneButton= driver.findElement(By.xpath(".//button[text()='Done']"));
        javaScriptUtil.clickElementByJS(doneButton);
    }
    public void clickOnSortByLink() throws InterruptedException {
//        Thread.sleep(2000);
        elementUtil.doClick(sortDropdown);
        elementUtil.doClick(priceLowToHigh);
    }
    public void scrollDownToPage() throws InterruptedException {
       javaScriptUtil.scrollPageDown();
       Thread.sleep(7000);
    }
    public void clickNextPage() throws InterruptedException {
        WebElement nextPageLink= driver.findElement(By.xpath(".//a[text()='2']"));
        javaScriptUtil.clickElementByJS(nextPageLink);
        Thread.sleep(2000);
    }
}


