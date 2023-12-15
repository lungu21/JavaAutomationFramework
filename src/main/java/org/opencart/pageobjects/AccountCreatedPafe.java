package org.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPafe extends Page{

    public AccountCreatedPafe(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "dsfdsf")
    private WebElement logOutOption;

    public void logOutFromTheAccount(){
        accountIcon.click();
        logOutOption.click();
        System.out.println("The user is logged out");

    }






}
