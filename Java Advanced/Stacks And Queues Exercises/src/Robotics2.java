import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //1 read the input
        //1.1  read robot data
        Map<String, Integer> robotProcessTime = new LinkedHashMap<>();
        fillRobotsData(robotProcessTime, sc);

        //1.2 set all robots free (a robot is free means that his time is 0 so he can take an order to process)
        Map<String, Integer> robotWorkingTime = new LinkedHashMap<>();
        fillRobotsWorkingTime(robotWorkingTime, robotProcessTime);

        //1.3 read and convert time to seconds
        String time = sc.nextLine();
        int startingTime = convertTimeToSeconds(time);

        //1.4 fill queue with products
        ArrayDeque<String> queue = new ArrayDeque<>();
        fillQueue(queue, sc);

        //2 process data for the correct output
        while (!queue.isEmpty()) {
            startingTime++;
            String product = queue.poll();

            //this flag is for checking is a product is already assigned,
            //because without it every robot that is free will take the product for processing
            boolean isAssigned = false;

            //iterate through all robots and see who is free(not busy) and give them the product to process
            //and change the flag to be known that current product is already assigned
            for (Map.Entry<String, Integer> robot : robotWorkingTime.entrySet()) {
                int currentRobotWorkTime = robot.getValue();
                if (currentRobotWorkTime == 0 && !isAssigned) {
                    String robotName = robot.getKey();
                    robot.setValue(robotProcessTime.get(robotName));
                    isAssigned = true;
                    printRobotData(robotName, product, startingTime);
                }
                //if robot working time is not 0 the robot is busy
                if (robot.getValue() > 0){
                    robot.setValue(robot.getValue() - 1);
                }
            }

            if (!isAssigned){
                queue.offer(product);
            }
        }
    }

    static void fillRobotsData(Map<String, Integer> robotsProcessTime, Scanner sc) {
        String[] tokens = sc.nextLine().split(";");
        for (int i = 0; i < tokens.length; i++) {
            String[] robotDetails = tokens[i].split("-");
            String robotName = robotDetails[0];
            int robotTime = Integer.parseInt(robotDetails[1]);
            robotsProcessTime.putIfAbsent(robotName, robotTime);
        }
    }

    static void fillRobotsWorkingTime(Map<String, Integer> robotsWorkingTime, Map<String, Integer> robotsProcessTime) {
        for (String robot : robotsProcessTime.keySet()) {
            robotsWorkingTime.putIfAbsent(robot, 0);
        }
    }

    static void fillQueue(ArrayDeque<String> queue, Scanner sc) {
        String inputProduct = sc.nextLine();
        while (!inputProduct.equals("End")) {
            queue.offer(inputProduct);
            inputProduct = sc.nextLine();
        }
    }

    static int convertTimeToSeconds(String time) {
        String[] tokens = time.split(":");
        int hours = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2]);
        int timeInSeconds = (hours * 3600) + (minutes * 60) + seconds;
        return timeInSeconds;
    }

    static void printRobotData(String robotName, String product, int timeInSeconds){
        int hours = (timeInSeconds / 3600) % 24;
        int minutes = (timeInSeconds / 60) % 60;
        int seconds = timeInSeconds % 60;
        System.out.println(String.format("%s - %s [%02d:%02d:%02d]", robotName, product, hours, minutes, seconds));
    }
}
