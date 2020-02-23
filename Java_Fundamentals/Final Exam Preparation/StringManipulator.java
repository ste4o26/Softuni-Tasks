import java.util.Scanner;

public class StringManipulator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder text = new StringBuilder(sc.nextLine());
        String inputLine = sc.nextLine();
        while (!inputLine.equals("Done")){
            String[] tokens = inputLine.split("\\s+");
            String command = tokens[0];
            String word = "";
            String symbol = "";
            switch (command){
                case "Change":
                    symbol = tokens[1];
                    String replacement = tokens[2];
                    text.replace(0, text.length(), text.toString().replaceAll(symbol, replacement));
                    System.out.println(text);
                    break;

                case "Includes":
                    word = tokens[1];
                    if(text.toString().contains(word)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;

                case "End":
                    word = tokens[1];
                    if(text.toString().endsWith(word)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;

                case "Uppercase":
                    text.replace(0, text.length(), text.toString().toUpperCase());
                    System.out.println(text);
                    break;

                case "FindIndex":
                    symbol = tokens[1];
                    int firstIndexOfSymbol = text.indexOf(symbol);
                    System.out.println(firstIndexOfSymbol);
                    break;

                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]) + startIndex;
                    String newText = text.toString().substring(startIndex, endIndex);
                    text.replace(0, text.length(), newText);
                    System.out.println(text);
                    break;
            }
           inputLine = sc.nextLine();
        }
    }
}
