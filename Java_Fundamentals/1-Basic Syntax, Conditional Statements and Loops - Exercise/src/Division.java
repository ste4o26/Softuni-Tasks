import java.util.Scanner;
public class Division {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         int givenNumber = Integer.parseInt(sc.nextLine());

         if(givenNumber % 10 == 0){
             System.out.println("The number is divisible by 10");
         }else if(givenNumber % 7 == 0){
             System.out.println("The number is divisible by 7");
         }else if(givenNumber % 6 == 0){
             System.out.println("The number is divisible by 6");
         }else if(givenNumber % 3 ==0){
             System.out.println("The number is divisible by 3");
         }else if(givenNumber % 2 == 0){
             System.out.println("The number is divisible by 2");
         }else{
             System.out.println("Not divisible");
         }
    }
}
