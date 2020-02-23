import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
public class HouseParty2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(sc.nextLine());
        List<String> guestsNames = new ArrayList<String>();
        operateList(numberOfCommands, guestsNames, sc);
        printListOfGuests(guestsNames);
    }

    static void operateList(int numberOfCommands, List<String> guestsNames, Scanner sc){
        //"{name} is going!" -> 0 1 2
        //"{name} is not going!" -> 0 1 2 3

        //for (int currentCommandIndex = 0; currentCommandIndex < numberOfCommands; currentCommandIndex++) {
        while (numberOfCommands - 1 >= 0){
            String input = sc.nextLine();
            String[] commands = input.split("\\s+");
            if(commands[2].equals("going!")){
                String currentGuestName = commands[0];
                if(isInList(currentGuestName, guestsNames)){
                    System.out.printf("%s is already in the list!%n", currentGuestName);
                }else {
                    guestsNames.add(currentGuestName);
                }
            }else {
                String currentGuestName = commands[0];
                if(isInList(currentGuestName, guestsNames)){
                    guestsNames.remove(String.valueOf(currentGuestName));
                }else {
                    System.out.printf("%s is not in the list!%n", currentGuestName);
                }
            }
            numberOfCommands--;
        }
    }

    static boolean isInList(String guestName, List<String> guestsNames){
        for (int i = 0; i < guestsNames.size(); i++) {
            String currentGuestName = guestsNames.get(i);
           if(currentGuestName.equals(guestName)){
               return true;
           }
        }
        return false;
    }

    static void printListOfGuests(List<String> listOfGuests){
        for (int i = 0; i < listOfGuests.size(); i++) {
            String currentGuestName = listOfGuests.get(i);
            System.out.println(currentGuestName + " ");
        }
    }
}
