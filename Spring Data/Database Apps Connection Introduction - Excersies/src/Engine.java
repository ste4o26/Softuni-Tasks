import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            this.fetchVillainNamesAndMinionsCount();
//            this.fetchMinionsNamesByGivenVillainId(reader);
//            this.insertMinionToVillainMinionsList(reader);
//            this.changeTownNamesCasing(reader);
//            this.removeVillain(reader);
//            this.printAllMinionNames();
//            this.increaseMinionsAge(reader);
//            this.increaseAgeStoredProcedure(reader);
        } catch (SQLException | IOException e) {
            System.err.println(String.format("%s with message: %s", e.getClass().getSimpleName(), e.getMessage()));
            e.printStackTrace();
        }
    }

    /***    2nd task   */
    private void fetchVillainNamesAndMinionsCount() throws SQLException, IOException {
        //6 create a statement
        String query = Queries.VILLAINS_NAMES_AND_MINIONS_COUNT;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, 15);

        //7 create a result set and display the data
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(String.format("%s    %s",
                    resultSet.getString("name"),
                    resultSet.getInt("minions_count")));
        }
    }

    /***    3rd task   */
    private void fetchMinionsNamesByGivenVillainId(BufferedReader reader) throws IOException, SQLException {
        String query = Queries.MINIONS_NAMES_FOR_GIVEN_VILLAIN;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        System.out.print("Enter villain id: ");
        int villainId = Integer.parseInt(reader.readLine());
        preparedStatement.setInt(1, villainId);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            return;
        }

        int id = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Villain: %s%n%d. %s %d%n", resultSet.getString("villain_name"),
                id, resultSet.getString("minion_name"),
                resultSet.getInt("age")));

        while (resultSet.next()) {
            id++;
            String result = String.format("%d. %s %d%n", id, resultSet.getString("minion_name"),
                    resultSet.getInt("age"));
            sb.append(result);
        }

        System.out.println(sb.toString());
    }

    /***    4th task   */
    private void insertMinionToVillainMinionsList(BufferedReader reader) throws IOException, SQLException {
        //TODO ENTER MINION DETAILS SEPARATED BY SPACE!!!
        System.out.print("Minion details: ");
        List<String> minionData = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String minionName = minionData.get(0);
        int minionAge = Integer.parseInt(minionData.get(1));
        String townName = minionData.get(2);

        System.out.print("Villain name: ");
        String villainName = reader.readLine();

        if (!this.isEntityExists("villains", villainName)) {
            this.insertVillain(villainName);
            System.out.printf("Villain %s was added to the database.%n", villainName);
        } else {
            System.out.printf("Villain %s already exists!%n", villainName);
        }

        if (!this.isEntityExists("towns", townName)) {
            this.insertTown(townName);
            System.out.printf("Town %s was added to the database.%n", townName);
        } else {
            System.out.printf("Town %s already exists!%n", townName);
        }

        if (!this.isEntityExists("minions", minionName)) {
            int townId = this.getEntityIdByName("towns", townName);
            this.insertMinion(minionName, minionAge, townId);
        }

        int minionId = this.getEntityIdByName("minions", minionName);
        int villainId = this.getEntityIdByName("villains", villainName);
        if (!this.isMinionBelongsToVillain(minionId, villainId)) {
            this.hireMinion(minionId, villainId);
            System.out.printf("Successfully added %s to be minion of %s.%n", minionData.get(0), villainName);
        } else {
            System.out.printf("Minion %s already belongs to villain %s!%n", minionName, villainName);
        }
    }

    //helping method for 4th task
    private boolean isMinionBelongsToVillain(int minionId, int villainId) throws SQLException {
        String query = Queries.MINIONS_NAMES_FOR_GIVEN_VILLAIN;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getInt("minion_id") == minionId) {
                return true;
            }
        }
        return false;
    }

    //helping method for 4th task
    private int insertMinion(String name, int age, int townId) throws SQLException {
        String query = Queries.INSERT_MINIONS;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setInt(3, townId);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    //helping method for 4th task
    private int insertTown(String townName) throws SQLException {
        String query = Queries.INSERT_TOWN;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, townName);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    //helping method for 4th task
    private int insertVillain(String villainName) throws SQLException {
        String query = Queries.INSERT_VILLAIN;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, villainName);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    //helping method for 4th task
    private boolean isEntityExists(String tableName, String entityName) throws SQLException {
        String query = Queries.fetchEntityByName(tableName);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, entityName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) return true;
        return false;
    }

    //helping method for 4th task
    private int getEntityIdByName(String tableName, String entityName) throws SQLException {
        String query = Queries.fetchEntityId(tableName);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, entityName);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("id");
    }

    //helping method for 4th task
    private int hireMinion(int minionId, int villainId) throws SQLException {
        String query = Queries.VILLAIN_MINION_MAPPING;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, minionId);
        preparedStatement.setInt(2, villainId);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    /***    5th task   */
    private void changeTownNamesCasing(BufferedReader reader) throws SQLException, IOException {
        System.out.print("Enter country: ");
        String country = reader.readLine();

        String query = Queries.UPDATE_TOWNS_CASING_BY_COUNTRY;
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, country);

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        List<String> towns = this.fetchTownsByCountryName(country);
        System.out.printf("%d town names were affected.%n", rowsAffected);
        System.out.println(towns);
    }

    //helping method for 5th task
    private List<String> fetchTownsByCountryName(String country) throws SQLException {
        List<String> towns = new ArrayList<>();

        String query = Queries.FETCH_TOWNS_BY_COUNTRY;
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, country);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            towns.add(resultSet.getString("name"));
        }

        return towns;
    }

    /***    6th task   */
    private void removeVillain(BufferedReader reader) throws IOException, SQLException {
        System.out.print("Enter villain ID: ");
        int villainId = Integer.parseInt(reader.readLine());

        String villainName = this.getVillainNameById(villainId);
        if (villainName == null) {
            System.out.println("No such villain was found.");
            return;
        }

        int releasedMinions = this.releaseMinionsForVillain(villainId);

        String query = Queries.DELETE_VILLAIN_BY_ID;
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setInt(1, villainId);
        preparedStatement.executeUpdate();

        System.out.printf("%s was deleted.%n%d minions released.", villainName, releasedMinions);
    }

    //helping method for 6th task
    private String getVillainNameById(int villainId) throws SQLException {
        String query = Queries.FETCH_VILLAIN_NAME_BY_ID;
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) return null;
        return resultSet.getString("name");
    }

    //helping method for 6th task
    private int releaseMinionsForVillain(int villainId) throws SQLException {
        String query = Queries.RELEASE_ALL_MINIONS_FOR_VILLAIN;
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setInt(1, villainId);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    /***    7th task   */
    private void printAllMinionNames() throws SQLException, IOException {
        List<String> minions = new ArrayList<>();

        String query = Queries.FETCH_ALL_MINIONS;
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            minions.add(resultSet.getString("name"));
        }

        for (int i = 0; i < minions.size(); i++) {
            System.out.println(minions.remove(0));
            System.out.println(minions.remove(minions.size() - 1));
        }
    }

    /***    8th task   */
    private void increaseMinionsAge(BufferedReader reader) throws IOException, SQLException {
        //TODO ENTER MINIONS IDS SEPARATED BY SPACE!!!
        System.out.print("Enter minions ids: ");
        List<Integer> minionsIds = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String query = Queries.updateMinionsAgeWithIds(minionsIds.size());
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        for (int i = 0; i < minionsIds.size(); i++) {
            preparedStatement.setInt(i + 1, minionsIds.get(i));
        }

        preparedStatement.executeUpdate();
        this.fetchAllMinions()
                .forEach((key, value) -> System.out.printf("%s %d%n", key, value));
    }

    //helping method for 8th task
    private Map<String, Integer> fetchAllMinions() throws SQLException {
        Map<String, Integer> minionsAges = new LinkedHashMap<>();
        String query = Queries.FETCH_ALL_MINIONS;
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            minionsAges.put(resultSet.getString("name"), resultSet.getInt("age"));
        }
        return minionsAges;
    }

    /***    9th task   */
    private void increaseAgeStoredProcedure(BufferedReader reader) throws IOException, SQLException {
        System.out.print("Enter minion id: ");
        int minionId = Integer.parseInt(reader.readLine());

        String callableQuery = Queries.CALL_PROCEDURE;
        CallableStatement callableStatement = this.connection.prepareCall(callableQuery);
        callableStatement.setInt(1, minionId);
        callableStatement.execute();

        String query = Queries.FETCH_MINION_BY_ID;
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setInt(1, minionId);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(!resultSet.next()){
            System.out.println("No minions exists with given id!");
            return;
        }

        System.out.printf("%s %d%n",
                resultSet.getString("name"),
                resultSet.getInt("age"));
    }
}
