import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;

public class Homework {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    private static final String MINIONS_DB = "minions_db";
    private static final String MINIONS_TABLE = "minions";
    private static final String TOWNS_TABLE = "towns";
    private static final String VILLAINS_TABLE = "villains";
    private static final String MINIONS_VILLAINS_TABLE = "minions_villains";
    private final Scanner scan;
    private Connection connection;

    public Homework() {
        this.scan = new Scanner(System.in);
    }

    public void setConnection() {
        System.out.print("Enter username default (root):");
        String user = scan.nextLine();
        user = user.equals("") ? "root" : user;

        System.out.print("Enter password default (empty):");
        String password = scan.nextLine().trim();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        try {
            this.connection = DriverManager.getConnection(CONNECTION_URL + MINIONS_DB, props);
        } catch (SQLException throwable) {
            System.out.println("Invalid user or password");

        }

    }

    public void getVillainsNamesEx2() throws SQLException {
        String query = "select  v.name, COUNT(mv.minion_id) AS 'count' from villains AS v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "group by  v.id\n" +
                "having  `count` > 15\n" +
                "order by  `count` desc;";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("count"));
        }

    }

    public void getMinionNamesEx3() throws SQLException {
        System.out.print("Enter villain id:");
        int villainId = Integer.parseInt(scan.nextLine());
        String tableName = "villains";
        if (getEntityNameById(tableName, villainId) == null) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
        } else {
            String villainName = getEntityNameById(tableName, villainId);
            System.out.printf("Vallian: %s%n", villainName);
        }
        String query = "SELECT m.name,m.age from villains As v\n" +
                "LEFT JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "LEFT JOIN minions m on m.id = mv.minion_id\n" +
                "where v.id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);
        ResultSet resultSet = statement.executeQuery();
        int counter = 1;
        while (resultSet.next()) {
            if (resultSet.getString("name") != null) {
                System.out.printf("%2d. %-10.10s %d%n",
                        counter++,
                        resultSet.getString("name"),
                        resultSet.getInt("age"));
            }
        }
    }

    public void addMinionEx4() throws SQLException {
        System.out.print("Add minion info:");
        String[] minionInfo = scan.nextLine().split("\\s+");
        String minionName = minionInfo[0];
        int minionAge = Integer.parseInt(minionInfo[1]);
        String minionTownName = minionInfo[2];
        System.out.print("Villain Name:");
        String villainName = scan.nextLine();
        int townId = getEntityIdByName("towns", minionTownName);
        if (townId == 0) {
            insertIntoTable(TOWNS_TABLE, minionTownName);
            System.out.printf("Town %s was added to the database.%n", minionTownName);
        }
        int villainId = getEntityIdByName(VILLAINS_TABLE, villainName);
        if (villainId == 0) {
            insertIntoTable(VILLAINS_TABLE, villainName, "evil");
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }
        insertIntoTable(MINIONS_TABLE, minionName, minionAge, getEntityIdByName(TOWNS_TABLE, minionTownName));
        insertIntoTable(MINIONS_VILLAINS_TABLE,
                getEntityIdByName(MINIONS_TABLE, minionName),
                getEntityIdByName(VILLAINS_TABLE, villainName));
        System.out.printf("Successfully added %s to be minion of %s", minionName, villainName);
    }

    public void changeTownNamesCasingEx5() throws SQLException {
        System.out.print("Enter country Name:");
        String countryName = scan.nextLine();
        LinkedList<String> list = new LinkedList<>();

        String updateQuery = "update towns set name = UPPER(name) where country = ? ";
        PreparedStatement preparedStatementUpdate = connection.prepareStatement(updateQuery);
        preparedStatementUpdate.setString(1, countryName);
        preparedStatementUpdate.execute();

        String selectQuery = "select name from towns where country = ?";
        PreparedStatement preparedStatementSelect = connection.prepareStatement(selectQuery);
        preparedStatementSelect.setString(1, countryName);
        ResultSet resultSet = preparedStatementSelect.executeQuery();

        while (resultSet.next()) {
            list.add(resultSet.getString("name"));
        }
        if (list.size() > 0) {
            System.out.printf("%d town names were affected.%n", list.size());
            System.out.println(list);
        } else {
            System.out.println("No town names were affected.");
        }
    }

    public void removeVillainEx6() throws SQLException {
        System.out.print("Enter villain id:");
        int villainId = Integer.parseInt(scan.nextLine());
        int entitiesAffected = 0;
        String villainName = getEntityNameById(VILLAINS_TABLE, villainId);

        if (villainName != null) {
            //remove entities from mapping table
            String removeMappingEntitiesQuery = String.format("delete from %s where villain_id = ?", MINIONS_VILLAINS_TABLE);
            PreparedStatement deleteMappingStatement = connection.prepareStatement(removeMappingEntitiesQuery);
            deleteMappingStatement.setInt(1, villainId);
            entitiesAffected = deleteMappingStatement.executeUpdate();

            //remove villain
            String removeVillainQuery = String.format("delete from %s where id = ?", VILLAINS_TABLE);
            PreparedStatement deleteVillainStatement = connection.prepareStatement(removeVillainQuery);
            deleteVillainStatement.setInt(1, villainId);
            deleteVillainStatement.executeUpdate();

            System.out.printf("%s was deleted%n", villainName);
            System.out.printf("%d minions released%n", entitiesAffected);
        } else {
            System.out.println("No such villain was found");
        }
    }

    public void printAllMinionNamesEx7() throws SQLException {
        LinkedList<String> list = new LinkedList<>();
        String query = String.format("select name from %s", MINIONS_TABLE);
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        //adding results to list
        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }

        //printing doubles
        for (int i = 0; i < list.size() / 2; i++) {
            System.out.println(list.get(i));
            System.out.println(list.get(list.size() - 1 - i));
        }

        //printig the middle element, if the list size is odd
        if (list.size() % 2 == 1) {
            System.out.println(list.get(list.size() / 2));
        }
    }

    public void increaseMinionsAgeEx8() throws SQLException {
        System.out.print("Enter Minions ID`s (separated by space):");
        String[] ids = scan.nextLine().split("\\s+");

        String updateQuery = String.format("update %s set age = age + 1, name = LOWER(name) where id IN ", MINIONS_TABLE);
        StringBuilder sb = new StringBuilder(updateQuery);
        sb.append("(");

        //addind the list of ids to query string
        if (ids.length > 1) {
            for (int i = 0; i < ids.length - 1; i++) {
                sb.append(ids[i]).append(",");
            }
        }
        sb.append(ids[ids.length - 1]).append(")");

        PreparedStatement statement = connection.prepareStatement(sb.toString());
        statement.executeUpdate();

        String selectQuery = String.format("select id, name, age from %s", MINIONS_TABLE);
        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = selectStatement.executeQuery();
        System.out.println("id name            age");
        while (resultSet.next()) {
            System.out.printf("%2d %-15.15s %d%n", resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
        }
    }

    public void increaseAgeStoredProcedureEx9() throws SQLException {
        System.out.print("Enter minions id:");
        int minionId = Integer.parseInt(scan.nextLine());

        //create procedure
        String createProcedureQuery = "create PROCEDURE usp_get_older(minion_id INT)\n" +
                "begin\n" +
                "    update minions\n" +
                "        set age = age + 1\n" +
                "    where id = minion_id;\n" +
                "end";
        PreparedStatement createProcedureStatement = connection.prepareStatement(createProcedureQuery);
        createProcedureStatement.execute();

        //call procedure
        String query = "CALL usp_get_older(?)";
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setInt(1, minionId);
        callableStatement.execute();

        //check result
        query = "select name, age from minions where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, minionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }


    private int getEntityIdByName(String tableName, String name) throws SQLException {
        String query = String.format("select id from %s where name = ?", tableName);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next() ? resultSet.getInt("id") : 0;
    }

    private String getEntityNameById(String tableName, int entityId) throws SQLException {
        String query = String.format("select name from %s where id = ?;", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entityId);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ? resultSet.getString("name") : null;
    }

    //Insert method with different Overloading
    private void insertIntoTable(String tableName, String entityName) throws SQLException {
        String query = String.format("insert into %s (`name`) VALUES (?)", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, entityName);
        statement.execute();
    }

    private void insertIntoTable(String tableName, String entityName, int entityAge, int fkId) throws SQLException {
        String query = String.format("insert into %s (`name`, `age`,`town_id`) VALUES (?, ? , ?)", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, entityName);
        statement.setInt(2, entityAge);
        statement.setInt(3, fkId);
        statement.execute();
    }

    private void insertIntoTable(String tableName, String entityName, String evilFactor) throws SQLException {
        String query = String.format("insert into %s (`name`, `evilness_factor`) VALUES (? ,?)", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, entityName);
        statement.setString(2, evilFactor);
        statement.execute();
    }

    private void insertIntoTable(String tableName, int firstId, int secondId) throws SQLException {
        String query = String.format("insert into %s (`minion_id`, `villain_id`) values (?, ?)", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, firstId);
        statement.setInt(2, secondId);
        statement.execute();
    }
}
