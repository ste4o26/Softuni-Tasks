import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        String input = sc.nextLine();
        while (!input.equals("PARTY")){
            if (Character.isDigit(input.charAt(0))){
                vipGuests.add(input);
            }else {
                regularGuests.add(input);
            }
            input = sc.nextLine();
        }

        input = sc.nextLine();
        while (!input.equals("END")){
            if (Character.isDigit(input.charAt(0))){
                vipGuests.remove(input);
            }else {
                regularGuests.remove(input);
            }
            input = sc.nextLine();
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        vipGuests.forEach(System.out::println);
        regularGuests.forEach(System.out::println);
    }
}
