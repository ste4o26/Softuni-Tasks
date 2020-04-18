import java.util.Scanner;

public class MagicNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //read the number
        int magicNumber = Integer.parseInt(sc.nextLine());
        int result = 0;

        //6 cifrenoto prinitrane stava s 6 vlojeni cikli
        //a za vsqka otdelna ima vuzmojna stoinost ot 1 do 9
        for (int x1 = 1; x1 <= 9; x1++) {
            for (int x2 = 1; x2 <= 9; x2++) {
                for (int x3 = 1; x3 <= 9; x3++) {
                    for (int x4 = 1; x4 <= 9; x4++) {
                        for (int x5 = 1; x5 <= 9; x5++) {
                            for (int x6 = 1; x6 <= 9; x6++) {
                                result = x1 * x2 * x3 * x4 * x5 * x6;

                                if (result == magicNumber) {
                                    System.out.printf("%s%s%s%s%s%s ", x1, x2, x3, x4, x5, x6);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
