import java.util.Scanner;

public class NumberPyramid {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int counter = 1;

        for (int row = 1; row <= n ; row++) {
            for (int collomn = 1; collomn <= row; collomn++) {
                if(counter > n){
                    break;
                }
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }
}
