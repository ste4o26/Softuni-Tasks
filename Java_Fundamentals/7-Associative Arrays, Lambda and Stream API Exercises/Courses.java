import java.util.*;

public class Courses {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();
        addStudentToCourses(courses, sc);
        courses
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .forEach(entry ->{
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    entry
                            .getValue()
                            .sort((name1, name2) -> name1.compareTo(name2));
                    entry.getValue().forEach(student -> System.out.printf("-- %s%n", student));
                });
    }

    static void addStudentToCourses( Map<String, List<String>> courses, Scanner sc){
        String input = sc.nextLine();
        while (!input.equals("end")){
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];
            List<String> currentCourseStudents = courses.get(courseName);//lista prisvoqva stoinostta na lista na tekushtiq kurs ako ima takyv ako nqma prisvoqva null
            if(courses.containsKey(courseName)){
               currentCourseStudents.add(studentName);//zapisvam v lista sledvashtiq student shtom ima takyyv kurs
            }else {
                currentCourseStudents = new ArrayList<>();//ako nqma takyv kurs syzdavam nov list za noviq(tekushtiq kurs)
                currentCourseStudents.add(studentName);//dobavqm studenta v lista
            }
            courses.put(courseName, currentCourseStudents);//nakraq dobavqm na poziciq kursa lista ot studenti

            input = sc.nextLine();
        }

    }
}
