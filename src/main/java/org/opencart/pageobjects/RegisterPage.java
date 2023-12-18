package org.opencart.pageobjects;

import org.opencart.managers.DriverManager;
import org.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page{

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "fdfdsf")
    private WebElement firstNameInput;

    @FindBy(id="dfdsfsd")
    private WebElement lastNameInput;

    @FindBy(id = "fddggd")
    private WebElement emailInput;

    @FindBy(id = "dsadsa")
    private WebElement passwordInput;

    @FindBy(css = "fdssd")
    private WebElement privacyToogle;

    @FindBy(xpath = "sfsd")
    private WebElement continueBtn;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password){
        firstNameInput.sendKeys(firstName);
        System.out.println("The entered firts name is "+ firstName);

        lastNameInput.sendKeys(lastName);
        System.out.println("The entered last name is "+ lastName);

        emailInput.sendKeys(email);
        System.out.println("The entered email is "+ email);

        passwordInput.sendKeys(password);
        System.out.println("The entered password is "+ password);

    }

    public void switchOnThePrivacyToogle(WebDriver driver) throws InterruptedException {
        ScrollManager.scrollElement(driver,privacyToogle);
        privacyToogle.click();
    }


    public void clickOnContinueButton() throws InterruptedException {
        ScrollManager.scrollElement(DriverManager.getInstance().getDriver(),continueBtn);
        continueBtn.click();
    }








}
