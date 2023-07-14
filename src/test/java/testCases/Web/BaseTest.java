package testCases.Web;

import Utilities.DriverListener;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest {

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void startOfTest(String browserName) throws MalformedURLException
    {
        System.setProperty("browser", browserName);
        DriverListener.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void endOfTest()
    {
        DriverListener.getDriver().quit();
    }
}
