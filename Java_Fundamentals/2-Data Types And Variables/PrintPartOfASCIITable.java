import java.util.Scanner;
public class PrintPartOfASCIITable {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int startingSymbol = Integer.parseInt(sc.nextLine());
        int endingSymbol = Integer.parseInt(sc.nextLine());

        for (int currentSymbol = startingSymbol; currentSymbol <= endingSymbol; currentSymbol++) {
            System.out.print((char) currentSymbol + " ");
        }
    }
}
