package org.opencart.stepsdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.opencart.managers.DriverManager;
import org.opencart.managers.ScrollManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

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

    @When("{string} from {string} is clicked")
    public void fromIsClicked(String elementName, String elementContainingPage) {
        try {
            Class classInstance = Class.forName("com.opencart.pageobjects"+ elementContainingPage);
            Field webElementField = classInstance.getDeclaredField(elementName);
            webElementField.setAccessible(true);
            WebElement webElementToBeClicked = (WebElement) webElementField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
            ScrollManager.scrollElement(webElementToBeClicked);

        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | InterruptedException |
                 InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }

    @And("the following fields from {string} are populated with data")
    public void theFollowingFieldsFromArePopulatedWithData(String pageName, Map<String,String> fieldValueMap) throws ClassNotFoundException {
        Class classInstance = Class.forName("com.opencart.pageobjects"+ pageName);

        fieldValueMap.forEach((fieldName, valueToBeEntered) ->{
            Field webElementField = null;
            try {
                webElementField = classInstance.getDeclaredField(fieldName);
                webElementField.setAccessible(true);
                WebElement webElementTForDataInsertion = (WebElement) webElementField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
           ScrollManager.scrollElement(webElementTForDataInsertion);
             webElementTForDataInsertion.sendKeys(valueToBeEntered);
            } catch (NoSuchFieldException | InterruptedException | NoSuchMethodException | InstantiationException |
                     IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);

            }


    });};


}







