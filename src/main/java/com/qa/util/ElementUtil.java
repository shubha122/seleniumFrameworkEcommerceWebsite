package com.qa.util;

import com.qa.factory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementUtil {

	private WebDriver driver;
	private JavaScriptUtil jsUtil;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(driver);
	}
	
	//=============Wrapper FindElement and FindElements actions======================

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		if (Boolean.parseBoolean(DriverFactory.highlight)) {
			jsUtil.flash(element);
		}
		return element;
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doSendKeys(By locator, String value) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(value);
	}
	public void doSendKeys(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	public void doSendKeysAndEnter(By locator, String value) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(value);
		element.sendKeys(Keys.ENTER);
	}

	public void doClick(WebElement element) {
		element.click();
	}

	public void doActionsMoveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).perform();
	}
	public void doActionsMoveToElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public boolean selectRequiredItemAndSubItem(By itemLocator, By subItemLocator, String itemName, String subItemName){
		List<WebElement> itemList = getElements(itemLocator);
		List<WebElement> subItemList = getElements(subItemLocator);
		for(WebElement item : itemList){
			if(item.getText().equalsIgnoreCase(itemName)) {
				doActionsMoveToElement(item);
				waitForRequiredSec(2);
				for (WebElement subItem : subItemList) {
					if (subItem.getText().equalsIgnoreCase(subItemName)) {
						doClick(subItem);
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean verifyElementInDropDownList(By itemLocator, String value) {
		List<WebElement> itemList = getElements(itemLocator);
		for (WebElement item : itemList) {
			if (item.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public boolean waitForUrl(int timeOut, String url) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(url));
	}

	public String getValueByAttribute(WebElement element,String attributeName){
		return element.getAttribute(attributeName);
	}

	public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForRequiredSec(int timeInSec) {
		try {
			Thread.sleep(timeInSec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
