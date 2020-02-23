import java.util.Scanner;
public class ArrayRotation2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input[] = sc.nextLine().split(" ");
        int numberOfRotations = Integer.parseInt(sc.nextLine());

        for (int currentRotation = 0; currentRotation < numberOfRotations; currentRotation++) {

            String currentNumberToGoLast = input[0];

            for (int i = 0; i < input.length; i++) {
                if(i == input.length - 1){
                    input[i] = currentNumberToGoLast;
                    break;
                }
                input[i] = input[i+1];
            }
        }

        System.out.println(String.join(" ", input));
    }
}
