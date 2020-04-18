import java.util.Scanner;

public class Bus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfPassengersAtBegin = Integer.parseInt(sc.nextLine());
        int numberOfStops = Integer.parseInt(sc.nextLine());
        int totalNumberOfPassengers = numberOfPassengersAtBegin;
        int passengersAtStop;
        int passengersOffAtStop;

        for (int stop = 1; stop <= numberOfStops; stop++) {
            int controlers = 0;
            passengersOffAtStop = Integer.parseInt(sc.nextLine());
            passengersAtStop = Integer.parseInt(sc.nextLine());

            if(stop % 2 == 0){
                controlers -= 2;
            }else{
                controlers += 2;
            }

            totalNumberOfPassengers = totalNumberOfPassengers - passengersOffAtStop + passengersAtStop + controlers;
        }

        System.out.printf("The final number of passengers is : %d", totalNumberOfPassengers);
    }
}
