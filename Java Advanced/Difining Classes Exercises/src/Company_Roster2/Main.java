package Company_Roster2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Department> departmentsMap = new HashMap<>();

        int n = Integer.parseInt(read.readLine());
        for (int i = 0; i < n; i++) {
            String inputLine = read.readLine();
            String[] tokens = inputLine.split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            Employee employee = new Employee(name, salary, position);

            if (tokens.length == 5) {
                if (Character.isDigit(tokens[4].charAt(0))) {
                    int age = Integer.parseInt(tokens[4]);
                    employee.setAge(age);
                } else {
                    String email = tokens[4];
                    employee.setEmail(email);
                }

            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee.setEmail(email);
                employee.setAge(age);
            }

            String departmentName = tokens[3];
            Department department = departmentsMap.get(departmentName);
            if (!departmentsMap.containsKey(departmentName)) {
                department = new Department();
                department.addEmployee(employee);
                departmentsMap.put(departmentName, department);
            } else {
                department.addEmployee(employee);
                departmentsMap.put(departmentName, department);
            }
        }


//        Map.Entry<String, Department> highestAverageSalaryDepartment = departmentsMap.entrySet()
//                .stream()
//                .sorted((e1, e2) -> Double.compare(e2.getValue().getAverageDepartmentSalary(), e1.getValue().getAverageDepartmentSalary()))
//                .findFirst()
//                .get();           SAME AS BELOW !!!

        Map.Entry<String, Department> highestAverageSalaryDepartment = departmentsMap
                .entrySet()
                .stream()
                .max((e1, e2) -> Double.compare(e1.getValue().getAverageDepartmentSalary(), e2.getValue().getAverageDepartmentSalary()))
                .get();

        System.out.printf("Highest Average Salary: %s%n", highestAverageSalaryDepartment.getKey());
        highestAverageSalaryDepartment
                .getValue()
                .getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
