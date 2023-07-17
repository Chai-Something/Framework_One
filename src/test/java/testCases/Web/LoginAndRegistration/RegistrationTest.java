package testCases.Web.LoginAndRegistration;


import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegistrationPage;
import testCases.Web.BaseTest;

@Epic("Login and Registration")
@Feature("Registration Page")
public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    String generateRandomTxt;
    @Test()
    @Description("Register a Male user")
    @Story("User can Register a new account")
    @Severity(SeverityLevel.NORMAL)
    public void registerMaleUser(){
        generateRandomTxt = registrationPage.generateRandomTxt();
        registrationPage.navigateToRegistrationPage();
        Assert.assertTrue(registrationPage.successfullyNavigatedToRegistrationPage(),"Expected and Actual text Don't match");
        registrationPage.registerMaleUser("John", "Dou", "test"+generateRandomTxt+"@testing.com","testing123");
        Assert.assertTrue(registrationPage.successfulRegistration(),"Expected and Actual text Don't match");
    }

    @Test()
    @Description("Register a Female user")
    @Story("User can Register a new account")
    @Severity(SeverityLevel.NORMAL)
    public void registerFemaleUser(){
        generateRandomTxt = registrationPage.generateRandomTxt();
        registrationPage.navigateToRegistrationPage();
        Assert.assertTrue(registrationPage.successfullyNavigatedToRegistrationPage(),"Expected and Actual text Don't match");
        registrationPage.registerFemaleUser("Jolly", "Dou", "test"+generateRandomTxt+"@testing.com","testing123");
        Assert.assertTrue(registrationPage.successfulRegistration(),"Expected and Actual text Don't match");
    }
}
