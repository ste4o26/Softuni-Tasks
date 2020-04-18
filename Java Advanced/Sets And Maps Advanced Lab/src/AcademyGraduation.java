import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            List<Double> grades = Arrays.stream(sc.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            studentGrades.putIfAbsent(name, grades);
        }

        studentGrades
                .entrySet()
                .stream()
                .forEach(e -> {
                    String name = e.getKey();
                    System.out.printf("%s is graduated with ", name);
                    List<Double> grades = e.getValue();
                    double averageGrade = 0.0;
                    for (Double grade : grades) {
                        averageGrade += grade;
                    }
                    System.out.println(averageGrade /= grades.size());
                });
    }
}
