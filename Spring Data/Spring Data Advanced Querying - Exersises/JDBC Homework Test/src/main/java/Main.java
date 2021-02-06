import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Homework homework = new Homework();
        homework.setConnection();

        System.out.println("Enter the number of exercise, you want to test:");
        System.out.print("2. Get Villains Names Ex2;\n" +
                         "3. Get Minion Names Ex3;\n" +
                         "4. Add Minion Ex4;\n" +
                         "5. Change Town Names Casing Ex5;\n" +
                         "6. Remove Villain Ex6;\n" +
                         "7. Print All Minion Names Ex7;\n" +
                         "8. Increase Minions Age Ex8;\n" +
                         "9. Increase Age Stored Procedure Ex9;\n" +
                         "0. Exit\n");
        System.out.println("//Don`t forget to use fresh DATEBASE!//");
        int input = Integer.parseInt(scanner.nextLine());
        while (input != 0) {
            switch (input) {
                case 2:
                    homework.getVillainsNamesEx2();
                    break;
                case 3:
                    homework.getMinionNamesEx3();
                    break;
                case 4:
                    homework.addMinionEx4();
                    break;
                case 5:
                    homework.changeTownNamesCasingEx5();
                    break;
                case 6:
                    homework.removeVillainEx6();
                    break;
                case 7:
                    homework.printAllMinionNamesEx7();
                    break;
                case 8:
                    homework.increaseMinionsAgeEx8();
                    break;
                case 9:
                    homework.increaseAgeStoredProcedureEx9();
                    break;
                default:
                    System.out.println("Invalid number!");
            }
            System.out.println();
            System.out.println("Enter the number of exercise, you want to test:");

            input = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Thanks for the attention :)");


         homework.getVillainsNamesEx2();
         homework.getMinionNamesEx3();
         homework.addMinionEx4();
         homework.changeTownNamesCasingEx5();
         homework.removeVillainEx6();
         homework.printAllMinionNamesEx7();
         homework.increaseMinionsAgeEx8();
         homework.increaseAgeStoredProcedureEx9();
    }
}
