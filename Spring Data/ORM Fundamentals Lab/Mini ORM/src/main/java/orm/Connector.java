package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    private static Connection connection;

    public static void createConnection(String databaseName, String user, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        connection = DriverManager.getConnection(String.format("%s%s", CONNECTION_URL, databaseName), properties);
    }

    public static Connection getConnection() {
        return connection;
    }
}
