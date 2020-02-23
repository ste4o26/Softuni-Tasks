import java.util.Scanner;
public class FloatingEquality {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double firstNumber = Double.parseDouble(sc.nextLine());
        double secondNumber = Double.parseDouble(sc.nextLine());

        double differenceBetweenBothNumbers = Math.abs(firstNumber - secondNumber);
        double precisionEps = 0.000001;

        if(differenceBetweenBothNumbers < precisionEps){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
