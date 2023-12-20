package org.opencart.stepsdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.opencart.managers.DataFakerManager;
import org.opencart.managers.DriverManager;
import org.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {

    RegisterPage registerPage = new RegisterPage(DriverManager.getInstance().getDriver());
    @When("the registration form is completed with valid random data")
    public void theRegistrationFormIsCompletedWithValidRandomData() {
        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPasword(10, 20);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);

    }

    @And("the privacyToogle is enabled")
    public void thePrivacyToogleIsEnabled(WebDriver driver) {
        try {
            registerPage.switchOnThePrivacyToogle(driver);
        } catch (InterruptedException e) {
            System.out.println("Error!");
        }
    }

    @And("continueButton is clicked")
    public void continuebuttonIsClicked() throws InterruptedException {
        registerPage.clickOnContinueButton();
    }

    @And("the registration form is completed with the following data:")
    public void theRegistrationFormIsCompletedWithTheFollowingData(Map<String, String> userDetailMap) throws InterruptedException {

        String firstName = userDetailMap.get("firstName");
        if(firstName!=null && firstName.toUpperCase().equals("RANDOM")){
            firstName = DataFakerManager.getRandomName();
        }
        String lastName = userDetailMap.get("lastName");
        if(lastName!=null && lastName.toUpperCase().equals("RANDOM")){
            lastName = DataFakerManager.getRandomName();
        }
        String email = userDetailMap.get("email");
        if(email!=null && email.toUpperCase().equals("RANDOM")){
            email = DataFakerManager.getRandomEmail();
        }
        String password = userDetailMap.get("password");
        if(password!=null && password.toUpperCase().equals("RANDOM")){
            password = DataFakerManager.getRandomPasword(5, 20);
        }

registerPage.fillInTheRegisterForm(firstName,lastName,email, password);
        registerPage.clickOnContinueButton();

    }
}
