import java.util.Scanner;

public class Seats {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfTickets = Integer.parseInt(sc.nextLine());
        String ticketNumber;
        String seatNumber = null;

        for (int ticket = 1; ticket <= numberOfTickets; ticket++) {
            ticketNumber = sc.nextLine();
            char ticketNumberFirstCharacter = ticketNumber.charAt(0);

            if (ticketNumber.length() == 4) {
                if (ticketNumberFirstCharacter >= 'A' && ticketNumberFirstCharacter <= 'Z') {
                    System.out.printf("Seat decoded: %c%c%c%n", ticketNumber.charAt(0), ticketNumber.charAt(1), ticketNumber.charAt(2));
                } else {
                    System.out.printf("Seat decoded: %c%c%c%n", ticketNumber.charAt(3), ticketNumber.charAt(1), ticketNumber.charAt(2));
                }
            }else{
                System.out.printf("Seat decoded: %c%d%n", ticketNumber.charAt(0), (int)ticketNumber.charAt(1));
            }
        }
    }
}
