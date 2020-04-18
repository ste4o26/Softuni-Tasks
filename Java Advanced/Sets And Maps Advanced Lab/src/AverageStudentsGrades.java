import java.util.*;

public class AverageStudentsGrades {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(sc.nextLine());
        Map<String, List<Double>> studentsGrades = new TreeMap<>();
        for (int i = 0; i < numberOfStudents; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
            List<Double> grades = studentsGrades.get(name);
            if (studentsGrades.containsKey(name)) {
                grades.add(grade);
                studentsGrades.put(name, grades);
            }else {
                grades = new ArrayList<>();
                grades.add(grade);
                studentsGrades.put(name, grades);
            }
        }

        studentsGrades.entrySet()
                .stream()
                .forEach(entry -> {
                    String name = entry.getKey();
                    List<Double> grades = entry.getValue();
                    double averageGrade = 0.0;
                    System.out.print(name + " -> ");
                    for (Double grade : grades) {
                        System.out.printf("%.2f ", grade);
                        averageGrade += grade;
                    }
                    averageGrade /= grades.size();
                    System.out.printf("(avg: %.2f)%n", averageGrade);
                });
    }
}
