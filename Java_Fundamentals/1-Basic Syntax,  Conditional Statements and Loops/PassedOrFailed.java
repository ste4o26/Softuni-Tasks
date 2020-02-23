import java.util.Scanner;
public class PassedOrFailed {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double studentGrade = Double.parseDouble(sc.nextLine());
        boolean isPassed = studentGrade >= 3.00;

        if(isPassed){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }
    }
}
