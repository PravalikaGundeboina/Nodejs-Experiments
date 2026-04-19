package nodejs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Retrieve {
    public static void main(String[] args) {
        try {
            // Step 1: register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Step 2: connect to database
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/24wh1a05c6_pravalika",
                "root",
                "1234"
            );

            // Step 3: create statement
            Statement statement = connection.createStatement();

            // Step 4: execute SELECT query
            ResultSet rs = statement.executeQuery("SELECT * FROM employee");

            // Step 5: process result
            while (rs.next()) {
                System.out.println(
                    rs.getInt("Emp_id") + " - " +
                    rs.getString("Emp_Salary")
                );
            }

            // Step 6: close connection
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}