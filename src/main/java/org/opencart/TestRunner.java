package org.opencart;

import org.opencart.managers.DataFakerManager;
import org.opencart.managers.DriverManager;
import org.opencart.managers.ScrollManager;
import org.opencart.pageobjects.AccountCreatedPafe;
import org.opencart.pageobjects.HomePage;
import org.opencart.pageobjects.RegisterPage;
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

        HomePage homePage = new HomePage(driver);
        homePage.navigatetoRegisterPageFromHeaderMenu();


        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPasword(10, 20);


        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        registerPage.switchOnThePrivacyToogle(driver);
        registerPage.clickOnContinueButton();

        AccountCreatedPafe accountCreatedPafe = new AccountCreatedPafe(driver);
        accountCreatedPafe.logOutFromTheAccount();

        driver.quit();
        System.out.println("The execution was finished");
    }



}


