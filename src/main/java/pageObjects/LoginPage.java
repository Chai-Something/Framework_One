package pageObjects;

import Utilities.DriverListener;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    DriverListener elements = new DriverListener();
    private By loginEmail = By.xpath("//input[@id='Email']");
    private By loginPassword = By.xpath("//input[@id='Password']");
    private By loginButton = By.xpath("//div[@class='buttons']/input[@type='submit']");
    private By headerEmailLink = By.xpath("//div[@class='header-links']//a[@class='account']");
    private By unsuccessfulLoginTxt = By.xpath("//div[@class='validation-summary-errors']");
    private By logoutLink = By.xpath("//a[@class='ico-logout']");
    private By loginLink = By.xpath("//a[@class='ico-login']");

    @Step("Enter login Details with username {0} and password {1}")
    public void login(String email, String password) {
        elements.getWebElement(loginEmail).sendKeys(email);
        elements.getWebElement(loginPassword).sendKeys(password);
        elements.getWebElement(loginButton).click();
    }
    @Step("Verify user is Logged in")
    public String successfulLogin(){
        return elements.getWebElement(headerEmailLink).getText();
    }
    @Step("Verify user is not Logged in")
    public boolean unsuccessfulLogin(){
        return elements.getWebElement(unsuccessfulLoginTxt).getText().contains("Login was unsuccessful");
    }
    @Step("Verify user is not Logged in")
    public void logout(){
        elements.getWebElement(logoutLink).click();
    }
    @Step("Verify user is not Logged in")
    public boolean successfulLogout(){
        return elements.getWebElement(loginLink).getText().contains("Log in");
    }

}
