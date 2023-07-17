package pageObjects;

import Utilities.Constants;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.sql.*;

public class ConnectToDB {

    protected Connection connection;
    protected Statement statement;
    protected ResultSet resultSet;
    @Step("Connect to DB")
    public void setUp() {
        try {
            connection = DriverManager.getConnection(Constants.DB_URL,Constants.DB_user,Constants.DB_password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Step("Close DB")
    public void tearDown() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Step("Get FirstName from DB")
    public String getFirstRandomName(){
        try {
            setUp();
            resultSet = statement.executeQuery("SELECT first_name FROM sakila.actor ORDER BY RAND ( ) LIMIT 1 ");
            resultSet.next();
            return resultSet.getString("first_name");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Get LastName from DB")
    public String getLastRandomName(){
        try {
            setUp();
            resultSet = statement.executeQuery("SELECT last_name FROM sakila.actor ORDER BY RAND ( ) LIMIT 1 ");
            resultSet.next();
            return resultSet.getString("last_name");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Display All information from DB table: actor")
    public void displayInfo(){
        try {
            resultSet = statement.executeQuery("SELECT * FROM sakila.actor");
            while (resultSet.next()) {
                int id = resultSet.getInt("actor_id");
                String fname = resultSet.getString("first_name");
                String lname = resultSet.getString("last_name");
                System.out.println("ID: " + id + ", First Name: " + fname + ", Last Name: " + lname);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Step("Insert information on DB table: actor")
    public void insertInfo(String id, String fName, String lName){
        try {
            String insertQuery = "INSERT INTO sakila.actor (actor_id, first_name, last_name) VALUES ("+id+",'"+fName+"','"+lName+"')";
            int rowsAffected = statement.executeUpdate(insertQuery);
            Assert.assertEquals(rowsAffected, 1, "Data insertion failed!");
            System.out.println("Data insertion successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
