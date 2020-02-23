import java.util.*;

public class StudentAcademy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, List<Double>> studentsGrade = new LinkedHashMap<>();
        fillStudentsMap(studentsGrade, sc);
        studentsGrade
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50)
                .sorted((entry1, entry2) -> Double.compare(entry2.getValue()
                                .stream()
                                .mapToDouble(Double::doubleValue)
                                .average()
                                .getAsDouble(),
                        entry1.getValue()
                                .stream()
                                .mapToDouble(Double::doubleValue)
                                .average()
                                .getAsDouble()))
                .forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()
                        .stream()
                        .mapToDouble(i -> i)
                        .average()
                        .getAsDouble()));

    }

    static void fillStudentsMap(Map<String, List<Double>> studentGrades, Scanner sc){
        int numberOfCommands = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String name = sc.nextLine();
            double currentGrade = Double.parseDouble(sc.nextLine());
            List<Double> currentStudentGrades = studentGrades.get(name);
            if(studentGrades.containsKey(name)){
                currentStudentGrades.add(currentGrade);
            }else {
                currentStudentGrades = new ArrayList<Double>();
                currentStudentGrades.add(currentGrade);
            }
            studentGrades.put(name, currentStudentGrades);
        }
    }
}
