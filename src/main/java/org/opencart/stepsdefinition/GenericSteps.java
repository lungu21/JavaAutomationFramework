package org.opencart.stepsdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.opencart.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    @Given("the {string} is accessed")
    public void theIsAccessed(String urlValue) {
        driver.get(urlValue);
        System.out.println("The "+ urlValue + " was accessed by the Driver ");

    }

    @Then("the following errorMessages are displayed")
    public void theFollowingErrorMessagesAreDisplayed(List<String> errorMessageList) throws InterruptedException {
        for(int i=0; i < errorMessageList.size(); i++){
            Thread.sleep(500);
            String elementXpath = ". //*[text()= "+ errorMessageList.get(i) + "]";
            WebElement errorMessageElement = driver.findElement(By.xpath(elementXpath));
           boolean isErrorMessageNumberIDisplayed = errorMessageElement.isDisplayed();
            Assertions.assertTrue(isErrorMessageNumberIDisplayed, "The error message "+ errorMessageList.get(i)+ "is displayed" );

        }
    }


    @Then("the current url contains the following keyword: {string}")
    public void theCurrentUrlContainsTheFollowingKeyword(String keyword) throws InterruptedException {
            Thread.sleep(500);
            boolean urlContainsCollectString =driver.getCurrentUrl().contains(keyword);
            Assertions.assertTrue(urlContainsCollectString,"The "+ keyword + " is present within the URL");

        }
    }





