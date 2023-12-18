package org.opencart.stepsdefinition;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;

public class AccountPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    @Then("the new page url contains {string} keyword")
    public void theNewPageUrlContainsKeyword(String collectedStringValue) throws InterruptedException {
        Thread.sleep(500);
        boolean urlContainsCollectString =driver.getCurrentUrl().contains(collectedStringValue);
        Assertions.assertTrue(urlContainsCollectString,"The "+ collectedStringValue + " is present within the URL");

    }
}
