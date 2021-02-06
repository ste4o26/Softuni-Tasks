public class Queries {

    public static final String VILLAINS_NAMES_AND_MINIONS_COUNT = "select v.name, count(m.id) as minions_count\n" +
            "from villains as v\n" +
            "inner join minions_villains as m_v\n" +
            "on m_v.villain_id = v.id\n" +
            "inner join minions as m\n" +
            "on m_v.minion_id = m.id\n" +
            "group by v.name\n" +
            "having minions_count > ?\n" +
            "order by minions_count desc;";


    public static final String MINIONS_NAMES_FOR_GIVEN_VILLAIN = "select v.name as villain_name,\n" +
            "m.id as minion_id,\n" +
            "m.name as minion_name,\n" +
            "m.age\n" +
            "from villains as v\n" +
            "inner join minions_villains m_v\n" +
            "on v.id = m_v.villain_id\n" +
            "inner join minions m\n" +
            "on m_v.minion_id = m.id\n" +
            "where v.id = ?;";

    public static final String INSERT_MINIONS = "insert into minions (name, age, town_id)\n" +
            "values (?, ?, ?)";

    public static final String VILLAIN_MINION_MAPPING = "insert into minions_villains (minion_id, villain_id)\n" +
            "values (?, ?)";

    public static final String FETCH_TOWNS_BY_COUNTRY = "select name from towns\n" +
            "where country = ?";

    public static final String UPDATE_TOWNS_CASING_BY_COUNTRY = "update towns\n" +
            "set name = upper(name)\n" +
            "where country = ?";

    public static final String RELEASE_ALL_MINIONS_FOR_VILLAIN = "delete from minions_villains\n" +
            "where villain_id = ?";

    public static final String DELETE_VILLAIN_BY_ID = "delete from villains\n" +
            "where id = ?";

    public static final String FETCH_VILLAIN_NAME_BY_ID = "select name from villains\n" +
            "where id = ?";

    public static final String FETCH_ALL_MINIONS = "select name, age from minions";

    public static final String CALL_PROCEDURE = "call usp_get_older(?)";

    public static final String FETCH_MINION_BY_ID = "select name, age from minions\n" +
            "where id = ?";

    public static final String INSERT_TOWN = "insert into towns (name)\n" +
            "values (?)";

    public static final String INSERT_VILLAIN = "insert into villains (name, evilness_factor)\n" +
            "values (?, 'evil');";

    public static String updateMinionsAgeWithIds(int idsCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idsCount; i++) {
            sb.append("?,");
        }

        return String.format("update minions set age = age + 1, name = lower(name) where id in(%s)", sb.deleteCharAt(sb.length() - 1).toString());
    }

    public static String fetchEntityByName(String tableName) {
        return String.format("select * from %s where name = ?", tableName);
    }

    public static String fetchEntityId(String tableName) {
        return String.format("select id from %s where name = ?", tableName);
    }
}
