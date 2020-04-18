package Company_Roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, List<Employee>> departmentSalary = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String inputLine = reader.readLine();
            String[] tokens = inputLine.split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            List<Employee> employees = departmentSalary.get(department);

            if (tokens.length == 4) {
                Employee employee = new Employee(name, salary, position, department);
                addEmployeeToMap(departmentSalary, employees, employee);

            } else if (tokens.length == 5) {
                String email = tokens[4];
                Employee employee = new Employee(name, salary, position, department, email);
                addEmployeeToMap(departmentSalary, employees, employee);

            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                Employee employee = new Employee(name, salary, position, department, email, age);
                addEmployeeToMap(departmentSalary, employees, employee);
            }
        }


        String bestDepartment = null;
        double bestAverageSalarySum = Integer.MIN_VALUE;
        for (Map.Entry<String, List<Employee>> entry : departmentSalary.entrySet()) {
            String department = entry.getKey();
            List<Employee> employees = entry.getValue();
            double averageSalarySum = 0;
            for (Employee employee : employees) {
                double salary = employee.getSalary();
                averageSalarySum += salary;
            }

            averageSalarySum /= employees.size();

            if (averageSalarySum > bestAverageSalarySum) {
                bestAverageSalarySum = averageSalarySum;
                bestDepartment = department;
            }
        }

        System.out.printf("Highest Average Salary: %s%n", bestDepartment);
        List<Employee> employees = departmentSalary.get(bestDepartment);
        employees.stream()
                .sorted((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()))
                        .forEach(employee -> System.out.printf("%s %.2f %s %d%n",
                        employee.getName(),
                        employee.getSalary(),
                        employee.getEmail(),
                        employee.getAge()));
    }

    private static void addEmployeeToMap(Map<String, List<Employee>> departmentSalary, List<Employee> employees, Employee employee) {
        String department = employee.getDepartment();
        if (!departmentSalary.containsKey(department)) {
            employees = new ArrayList<>();
            employees.add(employee);
            departmentSalary.put(department, employees);
        } else {
            employees.add(employee);
            departmentSalary.put(department, employees);
        }
    }
}
