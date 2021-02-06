public class Queries {
    public static final String FETCH_ALL_TOWNS = "FROM Town";

    public static final String FETCH_EMPLOYEE_BY_FULL_NAME = "FROM Employee WHERE CONCAT(first_name, ' ', last_name) = :name";

    public static final String FETCH_EMPLOYEES_WITH_SALARY_OVER_A_GIVEN_ONE = "FROM Employee WHERE salary > :salary";

    public static final String FETCH_TOWN_BY_NAME = "FROM Town WHERE LOWER(name) = :townName";

    public static final String FETCH_EMPLOYEE_BY_LAST_NAME = "FROM Employee AS e WHERE e.lastName = :lastName";

    public static final String FETCH_EMPLOYEE_BY_ID = "FROM Employee WHERE id = :id";

    public static final String FETCH_ALL_PROJECTS_ORDERED_BY_START_DATE = "FROM Project ORDER BY startDate DESC";

    public static final String FETCH_ADDRESSES_BY_POPULATION = "FROM Address AS a " +
            "GROUP BY a.text " +
            "ORDER BY a.employees.size DESC";

    public static final String FETCH_EMPLOYEES_FROM_RESEARCH_AND_DEVELOPMENT_DEPARTMENT = "FROM Employee AS e " +
            "WHERE e.department.name = 'Research and Development' " +
            "ORDER BY e.salary ASC, " +
            "e.id ASC";

    public static final String UPDATE_ALL_EMPLOYEES_SALARY_WHERE_DEPARTMENT_IN = "UPDATE Employee AS e " +
            "SET e.salary = e.salary * 1.12 " +
            "WHERE e.department.id IN(1, 2, 4, 11)";

    public static final String FETCH_ALL_EMPLOYEES_WHERE_DEPARTMENT_IN = "FROM Employee AS e " +
            "WHERE e.department.id IN(1, 2, 4, 11)";

    public static final String FETCH_ALL_EMPLOYEES_WHERE_FIRST_NAME_LIKE = "FROM Employee AS e " +
            "WHERE LOWER(e.firstName) LIKE CONCAT(:prefix, '%')";

    public static final String FETCH_ALL_DEPARTMENTS_WITH_MAX_SALARY_NOT_IN_RANGE = "SELECT d FROM Department AS d " +
            "JOIN d.employees AS e " +
            "GROUP BY d.name " +
            "HAVING MAX(e.salary) < 30000 " +
            "OR MAX(e.salary) > 70000";

    public static final String FETCH_ADDRESSES_BY_TOWN = "FROM Address AS a " +
            "WHERE a.town.id = :townId";

    public static final String UPDATE_EMPLOYEES_WITH_ADDRESSES_TO_ANOTHER_ADDRESSES = "UPDATE FROM Employee AS e " +
            "SET e.address.id = :addressId " +
            "WHERE e.address.id IN(:addresses)";

    public static final String DELETE_ADDRESSES_IN_TOWN = "DELETE FROM Address AS a " +
            "WHERE a.town.id = :townId";

    public static final String DELETE_TOWN_BY_ID = "DELETE FROM Town AS t " +
            "WHERE t.id = :townId";
}