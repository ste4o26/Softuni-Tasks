import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringExplosion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if(currentSymbol == '>'){
                result.append('>');
                int power = Character.getNumericValue(input.charAt(i + 1));

                while (power > 0 && i < input.length() - 1){
                    i++;
                    char nextSymbol = input.charAt(i);
                    if(nextSymbol == '>'){
                        result.append('>');
                        power += Character.getNumericValue(input.charAt(i+ 1));
                        continue;
                    }
                    power--;
                }
            }else {
                result.append(currentSymbol);
            }
        }
        System.out.println(result);
    }
}
