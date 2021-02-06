package Database_Connection_Introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class MysqlDatabaseConnection {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String databasePath = "jdbc:mysql://localhost:3306/soft_uni?useSSL=true";
        Properties userProperties = new Properties();

        try {
            userProperties.setProperty("user", reader.readLine());
            userProperties.setProperty("password", reader.readLine());

            Class.forName("com.mysql.cj.jdbc.Driver");
            if(userProperties.get("user") == null || userProperties.get("password") == null){
                throw new IllegalArgumentException("All credentials are required!");
            }

        } catch (IOException | IllegalArgumentException | ClassNotFoundException exc) {
            System.out.println(
                    String.format("%s with message: %s", exc.getClass().getSimpleName(), exc.getMessage()));
            System.exit(0);
        }

        try(Connection databaseConnection = DriverManager.getConnection(databasePath, userProperties)){
            String query = "SELECT * FROM `employees` AS `e` WHERE `e`.`salary` > ?";
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);

            double givenSalary = Double.parseDouble(reader.readLine());
            preparedStatement.setDouble(1, givenSalary);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next() == true){
                String resultLine = String.format("| %-15.15s | %-15.15s | %10.2f |",
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDouble("salary"));
                System.out.println(resultLine);
            }

        }catch (SQLException sqle){
            System.out.println(
                    String.format("Exception message: %s    Exception code: %d",
                            sqle.getMessage(),
                            sqle.getErrorCode()));
            System.exit(0);
        } catch (IOException exc) {
            System.out.println(
                    String.format("%s with message: %s", exc.getClass().getSimpleName(), exc.getMessage()));
        }

    }
}

