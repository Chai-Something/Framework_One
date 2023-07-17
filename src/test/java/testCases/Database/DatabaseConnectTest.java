package testCases.Database;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ConnectToDB;

import java.sql.SQLException;

public class DatabaseConnectTest extends ConnectToDB {
    @Test()
    @Description("connection to DB test")
    @Story("User can connection to DB")
    @Severity(SeverityLevel.NORMAL)
    public void databaseConnection() {
        try {
            setUp();
            Assert.assertTrue(connection.isValid(5), "Database connection failed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
