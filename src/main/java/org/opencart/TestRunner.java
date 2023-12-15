package org.opencart;

import org.opencart.managers.DataFakerManager;
import org.opencart.managers.DriverManager;
import org.opencart.managers.ScrollManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import javax.swing.*;

public class TestRunner {


    public static void main(String[] args) throws InterruptedException {

        //define a driver object that will be used for future actions
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://andreisecuqa.host/");

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://andreisecuqa.host/");

        Thread.sleep(5000);
        String firstName = DataFakerManager.getRandomName();
        System.out.println("The generated first name is: "+ firstName);

        String lastName = DataFakerManager.getRandomName();
        System.out.println("The generated first name is: "+ lastName);

        String email = DataFakerManager.getRandomEmail();
        System.out.println("The generated first name is: "+ email);

        String password = DataFakerManager.getRandomPasword(10,20);
        System.out.println("The generated first name is: "+ password);

        driver.switchTo().window(currentWindowName);
        driver.quit();
        System.out.println("The execution was finished");

        WebElement privacyToogle = driver.findElement(By.cssSelector("fdsdsg"));
        ScrollManager.scrollElement(driver,privacyToogle);
        privacyToogle.click();



    }

}