package Company_Roster2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Department {

    private List<Employee> employees;

    public Department(){
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAverageDepartmentSalary(){
        return  this.employees
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
    }
}
