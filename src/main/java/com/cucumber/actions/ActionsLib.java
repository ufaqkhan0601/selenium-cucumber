package com.cucumber.actions;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.helpers.HighlightElement;
import com.cucumber.step_definitions.Hooks;

public class ActionsLib {
	public static JavascriptExecutor executor;

	public static void clickOnXButton(WebDriver driver, Properties OR) throws Exception {
		executor = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("x_icon_xpath"))));
		HighlightElement.highlightElement(driver, driver.findElement(By.xpath(OR.getProperty("x_icon_xpath"))));
		Thread.sleep(2000);
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OR.getProperty("x_icon_xpath"))));
	}

	public static void clickAndSearchInTopSearchBox(WebDriver driver, Properties OR, String item) throws Exception {
		executor = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("search_box_xpath"))));
		HighlightElement.highlightElement(driver, driver.findElement(By.xpath(OR.getProperty("search_box_xpath"))));
		Thread.sleep(2000);
		executor.executeScript("arguments[0].click();",
				driver.findElement(By.xpath(OR.getProperty("search_box_xpath"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("search_box_xpath"))).sendKeys(item);
		Thread.sleep(2000);
		HighlightElement.highlightElement(driver, driver.findElement(By.xpath(OR.getProperty("search_button_xpath"))));
		Thread.sleep(2000);
		executor.executeScript("arguments[0].click();",
				driver.findElement(By.xpath(OR.getProperty("search_button_xpath"))));

	}
	
	public static void clickItemFromTheSearchedResult(WebDriver driver, Properties OR, String item) throws Exception {
		executor = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='"+item+"']")));
		HighlightElement.highlightElement(driver, driver.findElement(By.xpath("//a[normalize-space(text())='"+item+"']")));
		Thread.sleep(2000);
		executor.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//a[normalize-space(text())='"+item+"']")));

	}
	
	public static void clickAddToCartButton(WebDriver driver, Properties OR) throws Exception {
		executor = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty("add_cart_cssselector"))));
		HighlightElement.highlightElement(driver, driver.findElement(By.cssSelector(OR.getProperty("add_cart_cssselector"))));
		Thread.sleep(2000);
//		executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(OR.getProperty("add_cart_cssselector"))));
		driver.findElement(By.cssSelector(OR.getProperty("add_cart_cssselector"))).click();
		Thread.sleep(2000);
	}
	public static void validateItemAddedInCartSuccesfully(WebDriver driver, Properties OR) throws Exception {
		executor = (JavascriptExecutor) driver;
		if(driver.findElements(By.xpath(OR.getProperty("cart_item_added_xpath"))).size()!=0)
		{
			System.out.println("Item added successfully");
		}
		else
		{
			throw new Exception("Item not added in cart successfully");
		}
	}
	public static void switchAnotherWindow(WebDriver driver, Properties OR) throws Exception {
		Set<String> allWindowHandles = driver.getWindowHandles();
		String mainWindow=driver.getTitle();
		for(String window : allWindowHandles )
		{
			driver.switchTo().window(window);
			if(!(driver.getTitle().equals(mainWindow)))
			{
				break;
			}
		}
		Hooks.driver=driver;
	}
}
