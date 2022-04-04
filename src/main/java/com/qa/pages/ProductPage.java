package com.qa.pages;

import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import com.qa.util.JavaScriptUtil;
import org.openqa.selenium.By;
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
    private final By searchTextBox = By.xpath(".//input[@id='header-desktop-search-input']");
    private final By searchList = By.xpath(".//a[@class='flex flex-col w-2/3 flex-auto text-neutral-700 no-underline']");
    private final By categoryFilter = By.xpath(".//div[contains(@class,'category-filter')]//div[@class='filter-check-item']/label");
    private final By brandFilter = By.xpath(".//div[contains(@class,'brand-filter')]//div[@class='filter-check-item']/label");
    private final By cashBackStoreFilter = By.xpath(".//div[contains(@class,'store-filter')]//div[@class='filter-check-item']/label");
    private final By priceInput = By.xpath(".//div[contains(@class,'price-input-field')]/input");
    private final By doneButton = By.xpath(".//button[text()='Done']");
    private final By sortDropdownLink = By.xpath(".//div[@id='dropdown']");
    private final By sortSelection = By.xpath(".//li[@class='dropdown-list-option cursor-pointer']");
    private final By paginationLink = By.xpath(".//div[@class='btn-group pagination-list']/a");
    private final By pageLink = By.xpath("//footer[@class='text-sb-white-two']");

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
    public void clickOnProduct(){
         List<WebElement> productSearchList = elementUtil.getElements(searchList);
         javaScriptUtil.clickElementByJS(productSearchList.get(0));
    }
    public void setCategoryFilter(String categoryItem){
        List<WebElement> categoryFilterList = elementUtil.getElements(categoryFilter);
        javaScriptUtil.clickElementByJS(categoryFilterList,categoryItem);
    }
    public void setBrandFilter(String brandName){
        List<WebElement> brandFilterList = elementUtil.getElements(brandFilter);
        javaScriptUtil.clickElementByJS(brandFilterList,brandName);
    }
    public void setCashbackStoreFilter(String storeName){
        List<WebElement> storeFilterList = elementUtil.getElements(cashBackStoreFilter);
        javaScriptUtil.clickElementByJS(storeFilterList,storeName);
    }

    public void setPriceInput(String minPrice,String maxPrice)  {
        List<WebElement> priceInputList = elementUtil.getElements(priceInput);
        for(WebElement element : priceInputList){
            if(elementUtil.getValueByAttribute(element,"placeholder").equalsIgnoreCase("$ min"))
                elementUtil.doSendKeys(element,minPrice);
            else if(elementUtil.getValueByAttribute(element,"placeholder").equalsIgnoreCase("$ max"))
                elementUtil.doSendKeys(element,maxPrice);
        }
    }

    public void clickOnDoneButton(){
//        WebElement element = elementUtil.getElement(doneButton);
//        javaScriptUtil.clickElementByJS(element);
            WebElement doneButton= driver.findElement(By.xpath(".//button[text()='Done']"));
            javaScriptUtil.clickElementByJS(doneButton);

    }
    public void setSortSelection(String sortOption){
        elementUtil.doClick(sortDropdownLink);
        List<WebElement> sortSelectionList = elementUtil.getElements(sortSelection);
        javaScriptUtil.clickElementByJS(sortSelectionList,sortOption);
    }
    public void scrollDownToPage() {
       javaScriptUtil.scrollIntoView(elementUtil.getElement(pageLink));
       elementUtil.waitForRequiredSec(2);
    }
    public void clickNextPage() {
        List<WebElement> paginationList = elementUtil.getElements(paginationLink);
        javaScriptUtil.clickElementByJS(paginationList,"2");
        elementUtil.waitForRequiredSec(5);
    }
}


