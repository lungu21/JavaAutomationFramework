package org.opencart.stepsdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.opencart.managers.DriverManager;
import org.opencart.pageobjects.HomePage;

public class HomePageSteps {

    HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());

    @Given("home Page is accessed")
    public void homePageIsAccessed() {
        DriverManager.getInstance().getDriver().get("https://andreisecuqa.host/");
    }


    @And("RegisterPage is accessed from HomePage menu")
    public void registerpageIsAccessedFromHomePageMenu() {
        homePage.navigatetoRegisterPageFromHeaderMenu();

    }


}
