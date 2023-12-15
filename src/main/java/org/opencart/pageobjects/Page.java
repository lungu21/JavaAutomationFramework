package org.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.print.attribute.standard.Fidelity;

public abstract class Page {

     public Page(WebDriver driver){
         PageFactory.initElements(driver, this);
     }
     @FindBy(xpath= "dsfsf")
    protected WebElement accountIcon;

     @FindBy(xpath = "dsafsa")
     protected WebElement registerBtn;

    public void navigatetoRegisterPageFromHeaderMenu(){
        accountIcon.click();
        System.out.println("The account Icon wac clicked");

        registerBtn.click();
        System.out.println("The register Button was clicked");

    }


}
