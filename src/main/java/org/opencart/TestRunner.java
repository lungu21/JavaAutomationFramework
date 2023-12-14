package org.opencart;

import org.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import javax.swing.*;

public class TestRunner {


    public static void main(String[] args) throws InterruptedException {

        //define a driver object that will be used for future actions
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.5.3");
        String currentWindowName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://mvnrepository.com/");
        Thread.sleep(5000);
        driver.close();

        driver.switchTo().window(currentWindowName);
        driver.quit();
        System.out.println("The execution was finished");


    }

}