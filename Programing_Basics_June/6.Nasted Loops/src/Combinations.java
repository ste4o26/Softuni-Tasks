import java.util.Scanner;

public class Combinations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());
        int validCombinations = 0;

        for (int x1 = 0; x1 <= num; x1++) {
            for (int x2 = 0; x2 <= num; x2++) {
                for (int x3 = 0; x3 <= num; x3++) {
                    for (int x4 = 0; x4 <= num; x4++) {
                        for (int x5 = 0; x5 <= num; x5++) {
                            int sum = x1 + x2 + x3 + x4 + x5;
                            if(sum == num){
                                validCombinations++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(validCombinations);
    }
}
