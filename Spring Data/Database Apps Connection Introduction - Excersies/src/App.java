import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class App {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "minions_db";

    //1 connect intellij with the database itself(mySQL in this case)
    //2 import the driver for the database connection (JDBC)
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /**
         * TODO CHANGE YOUR CREDENTIALS IN "getUserCredentials" METHOD!!!
         * OR ENTER THEM EVERY TIME YOU RUN THE APPLICATION!!!
         */

        //3 get user credentials for the database server and set them to a property file(object)
        Properties userCredentials = getUserCredentials(reader);

        //4 load the driver before establishing the connection(optional)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println(String.format("%s with message: %s", cnfe.getClass().getSimpleName(), cnfe.getMessage()));
        }

        //5 establish a connection
        try {
            Connection connection = DriverManager.getConnection(CONNECTION_STRING + DATABASE_NAME, userCredentials);
            Engine engine = new Engine(connection);
            engine.run();
        } catch (SQLException sqle) {
            System.err.println(String.format("%s with message: %s", sqle.getClass().getSimpleName(), sqle.getMessage()));
        }
    }

    private static Properties getUserCredentials(BufferedReader reader) {
        String user = "";
        String password = "";
        try {
            System.out.print("Enter username: ");
            user = reader.readLine();
            System.out.print("Enter password: ");
            password = reader.readLine();
        } catch (IOException ioe) {
            System.err.println(String.format("%s with message: %s", ioe.getClass().getSimpleName(), ioe.getMessage()));
        }

        if (user.trim().isEmpty()) { user = "root"; }
        if (password.trim().isEmpty()){ password = "mysql@P123"; }

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        return properties;
    }
}
