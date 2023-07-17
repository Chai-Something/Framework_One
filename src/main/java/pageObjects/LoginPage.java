package pageObjects;

import Utilities.DriverListener;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    DriverListener elements = new DriverListener();
    private final By loginEmail = By.xpath("//input[@id='Email']");
    private final By loginPassword = By.xpath("//input[@id='Password']");
    private final By loginButton = By.xpath("//div[@class='buttons']/input[@type='submit']");
    private final By headerEmailLink = By.xpath("//div[@class='header-links']//a[@class='account']");
    private final By unsuccessfulLoginTxt = By.xpath("//div[@class='validation-summary-errors']");
    private final By logoutLink = By.xpath("//a[@class='ico-logout']");
    private final By loginLink = By.xpath("//a[@class='ico-login']");

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
