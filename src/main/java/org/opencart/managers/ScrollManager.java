package org.opencart.managers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollManager {

    public static void  scrollElement(WebDriver driver, WebElement element) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(500);

    }

    public static void  scrollElement( WebElement element) throws InterruptedException {
        ((JavascriptExecutor)DriverManager.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(3000);

    }
}
