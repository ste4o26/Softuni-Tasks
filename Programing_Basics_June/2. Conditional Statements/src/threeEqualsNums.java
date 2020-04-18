import java.util.Scanner;

public class threeEqualsNums {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstNum = Integer.parseInt(sc.nextLine());
        int secondNum = Integer.parseInt(sc.nextLine());
        int tirdNum = Integer.parseInt(sc.nextLine());

        boolean areNumbersEqual = firstNum == secondNum && firstNum == tirdNum;

        if(areNumbersEqual){
            System.out.println("yes");

        }else {
            System.out.println("no");

        }
    }
}
