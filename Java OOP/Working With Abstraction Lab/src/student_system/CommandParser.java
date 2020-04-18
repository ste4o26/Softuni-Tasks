package student_system;

import java.util.Map;

public class CommandParser {
    private Map<String, Student> students;

    public CommandParser(Map<String, Student> students) {
        this.students = students;
    }

    public void parseCommand(String[] args) {
        String command = args[0];
        String name = args[1];
        switch (command) {
            case "Create":
                int age = Integer.parseInt(args[2]);
                double grade = Double.parseDouble(args[3]);
                if (!students.containsKey(name)) {
                    Student student = new Student(name, age, grade);
                    students.put(name, student);
                }
                break;

            case "Show":
                if (students.containsKey(name)) {
                    Student student = students.get(name);
                    StringBuilder view = new StringBuilder();
                    view.append(String.format("%s is %s years old.", student.getName(), student.getAge()));

                    if (student.getGrade() >= 5.00) {
                        view.append(" Excellent student.");
                    } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                        view.append(" Average student.");
                    } else {
                        view.append(" Very nice person.");
                    }

                    System.out.println(view.toString());
                }
                break;
        }
    }
}