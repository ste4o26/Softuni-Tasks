package birthday_selebration.command_manipulator;

import birthday_selebration.Robot;
import birthday_selebration.repository.Repository;

public class RobotCommand implements Command {
    private String[] tokens;
    private Repository<Robot> repository;


    public RobotCommand(String[] tokens, Repository<Robot> repository) {
        this.tokens = tokens;
        this.repository = repository;
    }

    @Override
    public void execute() {
        Robot robot = createRobot();
        addRobotToRepository(robot);
    }

    private void addRobotToRepository(Robot robot) {
        this.repository.add(robot);
    }

    private Robot createRobot() {
        String id = this.tokens[1];
        String model = this.tokens[2];
        return new Robot(id, model);
    }
}
