package org.opencart.stepsdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.opencart.managers.DriverManager;
import org.opencart.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver) ;
    @And("the following data is entered into the login form")
    public void theFollowingDataIsEnteredIntoTheLoginForm(List<String> userDetailsList) {
        String emailValue = userDetailsList.get(0);
        String passwordValue = userDetailsList.get(1);
        loginPage.fillInTheLoginForm(emailValue, passwordValue);

    }

}
