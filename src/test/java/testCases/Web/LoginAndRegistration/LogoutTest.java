package testCases.Web.LoginAndRegistration;

import Utilities.Constants;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testCases.Web.BaseTest;

@Epic("Login and Registration")
@Feature("Registration Page")
public class LogoutTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test()
    @Description("Logout test")
    @Story("User can Logout")
    @Severity(SeverityLevel.CRITICAL)
    public void successfulLogout(){
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);
        loginPage.logout();
        Assert.assertTrue(loginPage.successfulLogout(),"Expected and Actual text Don't match");
    }
}
