import java.util.*;

public class CompanyUser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> companyEmployee = new TreeMap<>();
        fillCompaniesWithEmployees(companyEmployee, sc);
        companyEmployee
                .entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(id -> System.out.printf("-- %s%n", id));
                });
    }

    static void fillCompaniesWithEmployees(Map<String, List<String>> companyEmployee, Scanner sc) {
        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String companyName = tokens[0];
            String employeeID = tokens[1];
            List<String> employeesIdList = companyEmployee.get(companyName);
            if (companyEmployee.containsKey(companyName)) {
                if(!(companyEmployee.get(companyName).contains(employeeID))){
                    employeesIdList.add(employeeID);
                }
            } else {
                employeesIdList = new ArrayList<String>();
                employeesIdList.add(employeeID);
            }
            companyEmployee.put(companyName, employeesIdList);

            input = sc.nextLine();
        }
    }
}
