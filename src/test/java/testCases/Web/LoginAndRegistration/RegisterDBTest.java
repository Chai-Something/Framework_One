package testCases.Web.LoginAndRegistration;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ConnectToDB;
import pageObjects.RegistrationPage;
import testCases.Web.BaseTest;

public class RegisterDBTest extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    ConnectToDB DB = new ConnectToDB();
    String generateRandomTxt;
    @Test()
    @Description("Register a user from DB")
    @Story("User can Register a new account using DB values")
    @Severity(SeverityLevel.MINOR)
    public void registerUserFromDB(){
        generateRandomTxt = registrationPage.generateRandomTxt();
        registrationPage.navigateToRegistrationPage();
        Assert.assertTrue(registrationPage.successfullyNavigatedToRegistrationPage(),"Expected and Actual text Don't match");
        registrationPage.registerMaleUser(DB.getFirstRandomName(),DB.getLastRandomName(),
                "test"+generateRandomTxt+"@testing.com","testing123"+generateRandomTxt);
        Assert.assertTrue(registrationPage.successfulRegistration(),"Expected and Actual text Don't match");
    }
}
