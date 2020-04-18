import java.util.Scanner;

public class usdToBgn {
    public static void main(String[] args){

            Scanner sc = new Scanner(System.in);

            double leva = Double.parseDouble(sc.nextLine());
            double course = 1.79549; // 1 usd = 1.79549 lv

            double usd = leva*course;

            System.out.printf("%.2f", usd);
    }
}
