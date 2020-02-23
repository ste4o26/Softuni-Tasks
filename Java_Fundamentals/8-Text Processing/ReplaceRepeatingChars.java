import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] charArray = input.toCharArray();
        List<Character> characterList = new ArrayList<>();

        for (int i = 0; i < charArray.length; i++) {
            characterList.add(charArray[i]);
        }
        int count = 0;
        while (count < characterList.size() - 1) {
            char currentSymbol = characterList.get(count);
            char nextSymbol = characterList.get(count + 1);
            if (currentSymbol == nextSymbol) {
                characterList.remove(count);
            } else {
                count++;
            }
        }

        for (Character character : characterList) {
            System.out.print(character);
        }

    }
}
