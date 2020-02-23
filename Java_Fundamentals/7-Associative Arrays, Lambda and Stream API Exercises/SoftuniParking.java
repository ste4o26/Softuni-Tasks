import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftuniParking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, String> userParkingPlace = new LinkedHashMap<>();
        printUsersState(userParkingPlace, sc);
        userParkingPlace
                .forEach((key, value) -> System.out.printf("%s => %s%n", key, value));
    }

    static void printUsersState(Map<String, String> userParkingPlace, Scanner sc){
        int numberOfCommands = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = sc.nextLine().split(" ");
            String userName = tokens[1];
            switch (tokens[0]){
                case "register":
                    String licensePlateNumber = tokens[2];
                    if(userParkingPlace.containsKey(userName)){
                        System.out.printf("ERROR: already registered with plate number %s%n", userParkingPlace.get(userName));
                    }else {
                        userParkingPlace.put(userName, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", userName, licensePlateNumber);
                    }
                    break;

                case "unregister":
                    if(userParkingPlace.containsKey(userName)){
                        userParkingPlace.remove(userName);
                        System.out.printf("%s unregistered successfully%n", userName);
                    }else {
                        System.out.printf("ERROR: user %s not found%n", userName);
                    }
                    break;
            }
        }
    }
}
