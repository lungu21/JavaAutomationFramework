package org.opencart;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.opencart.managers.DataFakerManager;
import org.opencart.managers.DriverManager;
import org.opencart.pageobjects.AccountCreatedPafe;
import org.opencart.pageobjects.HomePage;
import org.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegistrationFlowTestSuite {
WebDriver driver;
HomePage homePage;
RegisterPage registerPage;
 static int counter = 0;
    @BeforeEach
    public void executeTheCodeBeforeEachTestFromThisClass(){
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        counter++;
        System.out.println("The test number "+ counter + "started");


    }

    @Test
    @DisplayName("The url contains success keyword after registration with valid data")
    public void registerFlowRedirectTheUserToTheCorrectUrl() throws InterruptedException {
        //define a driver object that will be used for future actions

        homePage.navigatetoRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPasword(10, 20);



        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        registerPage.switchOnThePrivacyToogle(driver);
        registerPage.clickOnContinueButton();
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());

        boolean urlContainsTheCorrectKeyWords = driver.getCurrentUrl().contains("clsajkfklsvsuccess");
        Assertions.assertTrue(urlContainsTheCorrectKeyWords,"The url "+driver.getCurrentUrl()+" contains success keyword");

        AccountCreatedPafe accountCreatedPafe = new AccountCreatedPafe(driver);
        accountCreatedPafe.logOutFromTheAccount();
    }

    @Test
    @DisplayName("The url contains rigister keyword when privacy policy is not accepted")
    public void registerFlowIsBlockedByPrivacyPolicyToogleIsNotAccepted() throws InterruptedException {
        //define a driver object that will be used for future actions


        homePage.navigatetoRegisterPageFromHeaderMenu();


        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPasword(10, 20);


        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
//      registerPage.switchOnThePrivacyToogle(driver);
        registerPage.clickOnContinueButton();
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());

        boolean urlContainsTheCorrectKeyWords = driver.getCurrentUrl().contains("clsajkfklsvsuccess");
        String errorMessage = "The url "+driver.getCurrentUrl()+" doesn't contains success keyword";
        Assertions.assertFalse(urlContainsTheCorrectKeyWords,errorMessage);

        boolean urlContainsRegisterKeyWord = driver.getCurrentUrl().contains("regist");
        Assertions.assertTrue(urlContainsRegisterKeyWord,"The url belongs to register page");


        AccountCreatedPafe accountCreatedPafe = new AccountCreatedPafe(driver);
        accountCreatedPafe.logOutFromTheAccount();

    }

    @AfterEach
    public void executeThisMethodAfterEachTestCase(){
        DriverManager.getInstance().quitTheDriver();
        System.out.println("The test number "+ counter + " was finished");

    }



}
