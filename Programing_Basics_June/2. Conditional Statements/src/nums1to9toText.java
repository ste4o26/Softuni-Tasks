import java.util.Scanner;

public class nums1to9toText {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        boolean isNumOne = number == 1;
        boolean isNumTwo = number == 2;
        boolean isNumThree = number == 3;
        boolean isNumFour = number == 4;
        boolean isNumFive = number == 5;
        boolean isNumSix = number == 6;
        boolean isNumSeven = number == 7;
        boolean isNumEight = number == 8;
        boolean isNumNine = number == 9;


        if(isNumOne){
            System.out.println("one");

        }else if(isNumTwo){
            System.out.println("two");

        }else if(isNumThree){
            System.out.println("three");

        }else if(isNumFour){
            System.out.println("four");

        }else if(isNumFive){
            System.out.println("five");

        }else if(isNumSix){
            System.out.println("six");

        }else if(isNumSeven){
            System.out.println("seven");

        }else if(isNumEight){
            System.out.println("eight");

        }else if(isNumNine){
            System.out.println("nine");

        }else {
            System.out.println("number too big");

        }
    }
}
