package testCases.Web.LoginAndRegistration;

import Utilities.Constants;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testCases.Web.BaseTest;

@Epic("Login and Registration")
@Feature("Login Page")
public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test()
    @Description("Log in test valid username and password")
    @Story("Valid username and password")
    @Severity(SeverityLevel.CRITICAL)
    public void successfulLogin(){
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);
        String loggedInSuccessfully = loginPage.successfulLogin();
        Assert.assertEquals(Constants.USERNAME,loggedInSuccessfully,"Expected and Actual text Don't match");
    }

    @Test()
    @Description("Log in test invalid username and valid password")
    @Story("Invalid username and valid password")
    @Severity(SeverityLevel.CRITICAL)
    public void incorrectUsername(){
        loginPage.login(Constants.INCORRECT_USERNAME, Constants.PASSWORD);
        Assert.assertTrue(loginPage.unsuccessfulLogin(),"Logged in with incorrect details");
    }
    @Test()
    @Description("Log in test valid username and invalid password")
    @Story("Valid username and invalid password")
    @Severity(SeverityLevel.CRITICAL)
    public void incorrectPassword(){
        loginPage.login(Constants.USERNAME, Constants.INCORRECT_PASSWORD);
        Assert.assertTrue(loginPage.unsuccessfulLogin(),"Logged in with incorrect details");
    }
    @Test()
    @Description("Log in test invalid username and password")
    @Story("Invalid username and password")
    @Severity(SeverityLevel.CRITICAL)
    public void unsuccessfulLogin(){
        loginPage.login(Constants.INCORRECT_USERNAME, Constants.INCORRECT_PASSWORD);
        Assert.assertTrue(loginPage.unsuccessfulLogin(),"Logged in with incorrect details");
    }
}
