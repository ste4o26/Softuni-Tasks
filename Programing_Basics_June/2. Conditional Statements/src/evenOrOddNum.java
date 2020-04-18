import  java.util.Scanner;

public class evenOrOddNum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        boolean isEvenNumber = number % 2 == 0;

        if(isEvenNumber){
            System.out.println("even");

        }else {
            System.out.println("odd");

        }
    }
}
