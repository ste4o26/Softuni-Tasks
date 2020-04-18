import java.util.Scanner;
public class Vacation {

    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

        //TRY TO REFUSE THE CODE


        int numberOfPeopleFromTheGroup = Integer.parseInt(sc.nextLine());
        String groupType = sc.nextLine();
        String dayOfTheStay = sc.nextLine();

        boolean isFriday = dayOfTheStay.equals("Friday");
        boolean isSaturday = dayOfTheStay.equals("Saturday");
        boolean isSunday = dayOfTheStay.equals("Sunday");

        boolean isStudent = groupType.equals("Students");
        boolean isBusiness = groupType.equals("Business");
        boolean isRegular = groupType.equals("Regular");

        boolean isStudentsDiscount = numberOfPeopleFromTheGroup >= 30;
        boolean isBusinessDiscount = numberOfPeopleFromTheGroup >= 100;
        boolean isRegularDiscount = numberOfPeopleFromTheGroup >= 10 && numberOfPeopleFromTheGroup <= 20;

        double totalPrice = 0;

        if (isFriday){
            if(isStudent){
                totalPrice = numberOfPeopleFromTheGroup * 8.45;
                if(isStudentsDiscount){
                    totalPrice *= 0.85;
                    System.out.printf("Total price: %.2f", totalPrice);
                }else {
                    System.out.printf("Total price: %.2f", totalPrice);
                }


            }else if(isBusiness){
                totalPrice = numberOfPeopleFromTheGroup * 10.90;
                if(isBusinessDiscount){
                    numberOfPeopleFromTheGroup -= 10;
                    totalPrice = numberOfPeopleFromTheGroup * 15.60;
                    System.out.printf("Total price: %.2f", totalPrice);
                }else {
                    System.out.printf("Total price: %.2f", totalPrice);
                }


            }else {//isRegular
                totalPrice = numberOfPeopleFromTheGroup * 15;
                if(isRegularDiscount){
                    totalPrice *= 0.95;
                    System.out.printf("Total price: %.2f", totalPrice);
                }else{
                    System.out.printf("Total price: %.2f", totalPrice);
                }


            }


        }else if(isSaturday){
            if(isStudent){
                totalPrice = numberOfPeopleFromTheGroup * 9.80;
                if(isStudentsDiscount){
                    totalPrice *= 0.85;
                    System.out.printf("Total price: %.2f", totalPrice);
                }else{
                    System.out.printf("Total price: %.2f", totalPrice);
                }


            }else if(isBusiness){
                totalPrice = numberOfPeopleFromTheGroup * 15.60;
                if(isBusinessDiscount){
                    numberOfPeopleFromTheGroup -= 10;
                    totalPrice = numberOfPeopleFromTheGroup * 15.60;
                    System.out.printf("Total price: %.2f", totalPrice);
                }else{
                    System.out.printf("Total price: %.2f", totalPrice);
                }


            }else {//isRegular
                totalPrice = numberOfPeopleFromTheGroup * 20;
                if(isRegularDiscount) {
                    totalPrice *= 0.95;
                    System.out.printf("Total price: %.2f", totalPrice);
                }else {
                    System.out.printf("Total price: %.2f", totalPrice);
                }

            }


        }else{//isSunday
            if(isStudent){
                totalPrice = numberOfPeopleFromTheGroup * 10.46;
                if(isStudentsDiscount){
                    totalPrice *= 0.85;
                    System.out.printf("Total price: %.2f", totalPrice);
                }else {
                    System.out.printf("Total price: %.2f", totalPrice);
                }


            }else if(isBusiness){
                totalPrice = numberOfPeopleFromTheGroup * 16;
                if(isBusinessDiscount){
                    numberOfPeopleFromTheGroup -= 10;
                    totalPrice = numberOfPeopleFromTheGroup * 15.60;
                    System.out.printf("Total price: %.2f", totalPrice);
                }else {
                    System.out.printf("Total price: %.2f", totalPrice);
                }


            }else {//isRegular
                totalPrice = numberOfPeopleFromTheGroup * 22.50;
                if(isRegularDiscount){
                    totalPrice *= 0.95;
                    System.out.printf("Total price: %.2f", totalPrice);
                }else{
                    System.out.printf("Total price: %.2f", totalPrice);
                }
            }
        }
    }
}
