import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //TODO 5 more tasks!!!
    public void run() {
        try {
//            this.changeCasing();
//            this.containsEmployee();
//            this.employeesWithSalaryOver50000();
//            this.employeesFromDepartment();
//            this.addingNewAddressAndUpdatingEmployee();
//            this.addressesWithEmployeeCount();
//            this.getEmployeeWithProject();
//            this.findLatestTenProjects();
//            this.increaseSalaries();
//            this.findEmployeesByFirstName();
//            this.employeesMaximumSalaries();
            this.removeTowns();
        } catch (IOException ioe) {
            System.err.printf("%s with message %s", ioe.getClass().getSimpleName(), ioe.getMessage());
        }
    }


    /**
     * Task 2 Change Casing
     */
    private void changeCasing() {
        this.entityManager
                .getTransaction()
                .begin();

        List<Town> towns = this.entityManager
                .createQuery(Queries.FETCH_ALL_TOWNS, Town.class)
                .getResultList();

        towns.stream()
                .filter(town -> town.getName().length() > 5)
                .forEach(this.entityManager::detach);

        towns
                .stream()
                .filter(town -> town.getName().length() <= 5)
                .map(town -> {
                    town.setName(town.getName().toLowerCase());
                    return town;
                })
                .forEach(this.entityManager::persist);

        this.entityManager
                .getTransaction()
                .commit();
    }

    /**
     * Task 3 Contains Employee
     */
    private void containsEmployee() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //SEPARATED WITH SINGLE SPACE!!!
        System.out.print("Enter employee full name: ");
        String name = reader.readLine().trim();

        this.entityManager
                .getTransaction()
                .begin();

        try {
            this.entityManager
                    .createQuery(Queries.FETCH_EMPLOYEE_BY_FULL_NAME, Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();

            System.out.println("Yes");
        } catch (NoResultException nre) {
            System.out.println("No");
        }

        this.entityManager.getTransaction().commit();
    }

    /**
     * Task 4 Employees with Salary Over 50 000
     */
    private void employeesWithSalaryOver50000() throws IOException {
        BigDecimal salary = new BigDecimal("50000");
        this.entityManager
                .getTransaction()
                .begin();

        this.entityManager
                .createQuery(Queries.FETCH_EMPLOYEES_WITH_SALARY_OVER_A_GIVEN_ONE, Employee.class)
                .setParameter("salary", salary)
                .getResultList()
                .forEach(employee -> System.out.println(employee.getFirstName()));

        this.entityManager
                .getTransaction()
                .commit();
    }

    /**
     * Task 5 Employees from Department
     */
    private void employeesFromDepartment() throws IOException {
        this.entityManager
                .getTransaction()
                .begin();

        this.entityManager
                .createQuery(Queries.FETCH_EMPLOYEES_FROM_RESEARCH_AND_DEVELOPMENT_DEPARTMENT, Employee.class)
                .getResultList()
                .forEach(employee -> System.out.println(String.format("%s %s from Research and Development - $%.2f",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary())));

        this.entityManager
                .getTransaction()
                .commit();
    }

    /**
     * Task 6 Adding a New Address and Updating Employee
     */
    private void addingNewAddressAndUpdatingEmployee() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter an employee last name: ");
        String lastName = reader.readLine().trim();

        this.entityManager
                .getTransaction()
                .begin();

        Town town = this.entityManager
                .createQuery(Queries.FETCH_TOWN_BY_NAME, Town.class)
                .setParameter("townName", "Sofia".toLowerCase())
                .getSingleResult();

        Address address = new Address();
        address.setText("Vitoshka 15");
        address.setTown(town);
        this.entityManager.persist(address);

        Employee employee = null;
        try {
            employee = this.entityManager
                    .createQuery(Queries.FETCH_EMPLOYEE_BY_LAST_NAME, Employee.class)
                    .setParameter("lastName", lastName)
                    .getSingleResult();

            employee.setAddress(address);
            this.entityManager.persist(employee);
        } catch (NoResultException nre) {
            System.out.printf("No such user with last name %s exists!%n", lastName);
            return;
        }

        this.entityManager
                .getTransaction()
                .commit();
    }

    /**
     * Task 7 Addresses with Employee Count
     */
    private void addressesWithEmployeeCount() throws IOException {
        List<String> addressesByPopulation = new ArrayList<>();

        this.entityManager
                .getTransaction()
                .begin();

        this.entityManager
                .createQuery(Queries.FETCH_ADDRESSES_BY_POPULATION, Address.class)
                .getResultList()
                .stream()
                .limit(10)
                .forEach(address -> addressesByPopulation.add(String.format("%s, %s - %d employees",
                        address.getText(),
                        address.getTown().getName(),
                        address.getEmployees().size())));

        addressesByPopulation
                .forEach(System.out::println);

//        addressesByPopulation
//                .stream()
//                .sorted((a1, a2) -> a2.getEmployees().size() - a1.getEmployees().size())
//                .limit(10)
//                .forEach(address -> System.out.println(String.format("%s, %s - %d employees",
//                        address.getText(),
//                        address.getTown().getName(),
//                        address.getEmployees().size())));

        this.entityManager
                .getTransaction()
                .commit();
    }

    /**
     * Task 8 Get Employee with Project
     */
    private void getEmployeeWithProject() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter employee id: ");
        int id = Integer.parseInt(reader.readLine());

        this.entityManager
                .getTransaction()
                .begin();

        Employee employee = this.entityManager
                .createQuery(Queries.FETCH_EMPLOYEE_BY_ID, Employee.class)
                .setParameter("id", id)
                .getSingleResult();

        List<String> projectsNames = employee
                .getProjects()
                .stream()
                .sorted((f, s) -> f.getName().compareTo(s.getName()))
                .map(Project::getName)
                .collect(Collectors.toList());

        System.out.println(String.format("%s %s - %s%n    %s",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle(),
                String.join("\n    ", projectsNames)));
        this.entityManager.getTransaction().commit();
    }

    /**
     * Task 9 Find Latest 10 Projects
     */
    private void findLatestTenProjects() throws IOException {
        this.entityManager
                .getTransaction()
                .begin();

        this.entityManager
                .createQuery(Queries.FETCH_ALL_PROJECTS_ORDERED_BY_START_DATE, Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream()
                .sorted((f, s) -> f.getName().compareTo(s.getName()))
                .forEach(project -> System.out.println(
                        String.format("Project name: %s%n Project Description: %s%n Project End Date: %s",
                                project.getName(),
                                project.getDescription(),
                                project.getEndDate()
                        )));

        this.entityManager
                .getTransaction()
                .commit();
    }

    /**
     * Task 10 Increase Salaries
     */
    private void increaseSalaries() throws IOException {
        this.entityManager
                .getTransaction()
                .begin();

        this.entityManager
                .createQuery(Queries.UPDATE_ALL_EMPLOYEES_SALARY_WHERE_DEPARTMENT_IN)
                .executeUpdate();

        this.entityManager
                .flush();

        this.entityManager
                .createQuery(Queries.FETCH_ALL_EMPLOYEES_WHERE_DEPARTMENT_IN, Employee.class)
                .getResultList()
                .forEach(employee -> System.out.println(
                        String.format("%s %s ($%.2f)",
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary())));

        this.entityManager
                .getTransaction()
                .commit();
    }

    /**
     * Task 11 Find Employees by First Name
     */
    private void findEmployeesByFirstName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter prefix: ");
        String prefix = reader.readLine().trim().toLowerCase();

        this.entityManager
                .getTransaction()
                .begin();

        this.entityManager
                .createQuery(Queries.FETCH_ALL_EMPLOYEES_WHERE_FIRST_NAME_LIKE, Employee.class)
                .setParameter("prefix", prefix)
                .getResultList()
                .forEach(employee -> System.out.println(
                        String.format("%s %s - %s - ($%.2f)",
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getJobTitle(),
                                employee.getSalary())));

        this.entityManager
                .getTransaction()
                .commit();
    }

    /**
     * Task 12 Employees Maximum Salaries
     */
    private void employeesMaximumSalaries() throws IOException {
        List<String> departmentsMaxSalaries = new ArrayList<>();

        this.entityManager
                .getTransaction()
                .begin();

        this.entityManager
                .createQuery(Queries.FETCH_ALL_DEPARTMENTS_WITH_MAX_SALARY_NOT_IN_RANGE, Department.class)
                .getResultList()
                .forEach(department -> departmentsMaxSalaries.add(
                        String.format("%s %.2f",
                                department.getName(),
                                department
                                        .getEmployees()
                                        .stream()
                                        .max(Comparator.comparing(Employee::getSalary))
                                        .orElseThrow(NoSuchElementException::new)
                                        .getSalary()
                        )));


        departmentsMaxSalaries.forEach(System.out::println);

        this.entityManager
                .getTransaction()
                .commit();
    }

    /**
     * Task 13 Remove Towns
     */
    private void removeTowns() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter town name: ");
        String townName = reader.readLine().trim().toLowerCase();

        this.entityManager
                .getTransaction()
                .begin();

        Town town = this.entityManager
                .createQuery(Queries.FETCH_TOWN_BY_NAME, Town.class)
                .setParameter("townName", townName.toLowerCase())
                .getSingleResult();

        List<Integer> addresses = this.entityManager
                .createQuery(Queries.FETCH_ADDRESSES_BY_TOWN, Address.class)
                .setParameter("townId", town.getId())
                .getResultList()
                .stream()
                .map(Address::getId)
                .collect(Collectors.toList());

        this.entityManager
                .createQuery(Queries.UPDATE_EMPLOYEES_WITH_ADDRESSES_TO_ANOTHER_ADDRESSES)
                .setParameter("addressId", 1)
                .setParameter("addresses", addresses)
                .executeUpdate();

        int deletedAddresses = this.entityManager
                .createQuery(Queries.DELETE_ADDRESSES_IN_TOWN)
                .setParameter("townId", town.getId())
                .executeUpdate();

        this.entityManager
                .createQuery(Queries.DELETE_TOWN_BY_ID)
                .setParameter("townId", town.getId())
                .executeUpdate();

        this.entityManager
                .getTransaction()
                .commit();

        System.out.println(String.format("%d address in %s deleted",
                deletedAddresses,
                townName));
    }
}