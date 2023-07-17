package pageObjects;

import Utilities.Constants;
import Utilities.DriverListener;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Random;

public class RegistrationPage {
    DriverListener elements = new DriverListener();

    private final By  registerButton = By.xpath("//input[@value='Register']");
    private final By registerPageHeader = By.xpath("//h1[normalize-space()='Register']");
    private final By genderRadioButtonMale = By.id("gender-male");
    private final By genderRadioButtonFemale = By.id("gender-female");
    private final By firstNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By confirmPasswordField = By.id("ConfirmPassword");
    private final By registerButton2 = By.id("register-button");
    private final By succesfullRegistrationTxt = By.xpath("//div[@class='result']");
    private final By continueBtn = By.xpath("//input[@value='Continue']");

    @Step("Navigate to the Registration page")
    public void navigateToRegistrationPage (){
        elements.getWebElement(registerButton).click();
        elements.getWebElement(genderRadioButtonMale).click();
    }
    @Step("Navigate to the Registration page")
    public Boolean successfullyNavigatedToRegistrationPage(){
        return elements.getWebElement(registerPageHeader).getText().contains("Register");
    }

    @Step("Register Male User")
    public void registerMaleUser(String fName, String lName, String email, String password){
        elements.getWebElement(genderRadioButtonMale).click();
        elements.getWebElement(firstNameField).sendKeys(fName);
        elements.getWebElement(lastNameField).sendKeys(lName);
        elements.getWebElement(emailField).sendKeys(email);
        elements.getWebElement(passwordField).sendKeys(password);
        elements.getWebElement(confirmPasswordField).sendKeys(password);
        elements.getWebElement(registerButton2).click();
    }
    @Step("Register Female User")
    public void registerFemaleUser(String fName, String lName, String email, String password){
        elements.getWebElement(genderRadioButtonFemale).click();
        elements.getWebElement(firstNameField).sendKeys(fName);
        elements.getWebElement(lastNameField).sendKeys(lName);
        elements.getWebElement(emailField).sendKeys(email);
        elements.getWebElement(passwordField).sendKeys(password);
        elements.getWebElement(confirmPasswordField).sendKeys(password);
        elements.getWebElement(registerButton2).click();
    }

    public String generateRandomTxt(){
        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 3;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(Constants.alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = Constants.alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public Boolean successfulRegistration(){
        return elements.getWebElement(succesfullRegistrationTxt).getText().contains("Your registration completed");
    }
}
