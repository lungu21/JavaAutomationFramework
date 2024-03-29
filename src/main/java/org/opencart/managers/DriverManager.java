package org.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.OpenOption;

public class DriverManager {


    private static String webDriverType = ConfigReaderManager.getProperty("browserType");
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                if(ConfigReaderManager.getProperty("isChromeIncognitoEnabled").equals(true)) {
                    options.addArguments("--incognito");
                }
                driver = new ChromeDriver(options);
                System.out.println("The Chrome Driver was initiated!");
                break;
            case "FIREFOX":

                driver = new FirefoxDriver();
                System.out.println("The FireFox Driver was initiated!");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge Driver was initiated!");
                break;
            default:
                System.out.println("There is not defined such a driver" + webDriverType);


        }
    }

    public static DriverManager getInstance(){
        if (instance == null){
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver(){
        if(driver == null){
            DriverManager.getInstance();
        }
        return driver;
    }
 public void quitTheDriver(){
        driver.quit();
        driver = null;
        instance = null;
     System.out.println("The driver is quit and the instance is reset");

 }



}

