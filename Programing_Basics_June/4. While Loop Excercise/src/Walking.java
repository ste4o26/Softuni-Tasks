import java.util.Scanner;

public class Walking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int stepsGoal = 10000;
        int stepsGone = 0;
        String tired = null;
        int totalSteps = 0;

        boolean isGoalReached = false;

        while (totalSteps < stepsGoal){

            tired = sc.nextLine();

            if(tired.equals("Going home")){
                int stepsToHome = Integer.parseInt(sc.nextLine());
                totalSteps += stepsToHome;

                break;
            }


            stepsGone = Integer.parseInt(tired);
            totalSteps += stepsGone;
        }

        int stepsToReachGoal = Math.abs(stepsGoal - totalSteps);

        if(totalSteps >= stepsGoal){
            isGoalReached = true;
        }

        if(isGoalReached){
            System.out.println("Goal reached! Good job!");

        }else {
            System.out.printf("%d more steps to reach goal.", stepsToReachGoal);

        }
    }
}
