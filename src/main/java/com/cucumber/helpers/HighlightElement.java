package com.cucumber.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HighlightElement {

    public static void highlightElement(WebDriver driver,WebElement element) {
        for (int i = 0; i <10; i++) {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", element);
            }
        }
}
