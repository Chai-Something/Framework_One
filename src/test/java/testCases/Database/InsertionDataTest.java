package testCases.Database;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pageObjects.ConnectToDB;

public class InsertionDataTest extends ConnectToDB {
    @Test()
    @Description("Insert data into DB")
    @Story("User can Insert data into DB")
    @Severity(SeverityLevel.NORMAL)
    public void insertionInfoIntoDB() {
        setUp();
        insertInfo("203","lizzy","Mongol");
    }
}