package student_system;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> students;
    private CommandParser commandParser;

    public StudentSystem() {
        this.students = new HashMap<>();
        commandParser = new CommandParser(this.students);
    }

    public CommandParser getCommandParser() {
        return commandParser;
    }
}
