package pageObjects;

import Utilities.DriverListener;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegistrationPage {
    DriverListener elements = new DriverListener();

    private By registerButton = By.xpath("//input[@value='Register']");
    private By registerPageHeader = By.xpath("//h1[normalize-space()='Register']");
    private By genderRadioButtonMale = By.id("gender-male");
    private By genderRadioButtonFemale = By.id("gender-female)");
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By registerButton2 = By.id("register-button");

    @Step("Register Male User")
    public void RegisterMaleUser(){
        elements.getWebElement(genderRadioButtonMale).click();
        elements.getWebElement(firstNameField).sendKeys("email");
        elements.getWebElement(lastNameField).sendKeys("email");
        elements.getWebElement(emailField).sendKeys("email");
        elements.getWebElement(passwordField).sendKeys("email");
        elements.getWebElement(confirmPasswordField).sendKeys("email");
        elements.getWebElement(registerButton2).click();
    }
    @Step("Register Female User")
    public void RegisterFemaleUser(){
        elements.getWebElement(genderRadioButtonMale).click();
        elements.getWebElement(firstNameField).sendKeys("email");
        elements.getWebElement(lastNameField).sendKeys("email");
        elements.getWebElement(emailField).sendKeys("email");
        elements.getWebElement(passwordField).sendKeys("email");
        elements.getWebElement(confirmPasswordField).sendKeys("email");
        elements.getWebElement(registerButton2).click();
    }
}
