import  java.util.Scanner;

public class PipesInPool {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int poolVolume = Integer.parseInt(sc.nextLine());//in litters
        int firstPipeDebit = Integer.parseInt(sc.nextLine()); //litters per one hour
        int secondPipeDebit = Integer.parseInt(sc.nextLine()); //litters per one hour
        double pipesWorkingHours = Double.parseDouble(sc.nextLine());

        double totalLittersInsertedIntoPool = (firstPipeDebit + secondPipeDebit) * pipesWorkingHours;


        boolean isOverflow = totalLittersInsertedIntoPool > poolVolume;

        if(isOverflow){
            double littersOverflow = totalLittersInsertedIntoPool - poolVolume;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", pipesWorkingHours, littersOverflow);

        }else {
            char ch = '%';
            double percentageFullnest =  (totalLittersInsertedIntoPool / poolVolume) * 100;
            double firstPipePercentage = ((firstPipeDebit * pipesWorkingHours) / totalLittersInsertedIntoPool) * 100;
            double secondPipePercentage = ((secondPipeDebit * pipesWorkingHours) / totalLittersInsertedIntoPool) * 100;

            System.out.printf("The pool is %.2f%c full. Pipe 1: %.2f%c. Pipe 2: %.2f%c.", percentageFullnest, ch, firstPipePercentage, ch, secondPipePercentage, ch);

        }


    }
}
