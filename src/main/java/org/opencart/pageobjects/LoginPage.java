package org.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id = "dsad")
    private WebElement emailInput;

    @FindBy(id = "sdsad")
    private WebElement passwordInput;

    @FindBy(id = "dsada")
    private WebElement loginButton;


    public void fillInTheLoginForm( String email, String password){
        emailInput.sendKeys(email);
        System.out.println("Entered mail: "+ email);
        passwordInput.sendKeys(password);
        System.out.println("Entered password: " + password);

    }
    public void clickonLoginButton(){

        loginButton.click();
        System.out.println("The login button was clicked");
    }



}
