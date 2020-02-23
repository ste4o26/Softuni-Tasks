import java.util.*;
import java.util.stream.Collectors;

public class ListOfProducts {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfProducts = Integer.parseInt(sc.nextLine());
        List<String> listOfProducts = new ArrayList<String>();
        fillList(numberOfProducts, listOfProducts, sc);
        Collections.sort(listOfProducts);
        printList(listOfProducts);
    }

    static void printList(List<String> list){
        for (int i = 0; i < list.size(); i++){
            System.out.printf("%d.%s%n", i + 1, list.get(i));
        }
    }

    static void fillList(int numberOfProducts, List<String> list, Scanner sc){
        for (int i = 0; i < numberOfProducts; i++) {
            String product = sc.nextLine();
            list.add(product);
        }
    }
}
