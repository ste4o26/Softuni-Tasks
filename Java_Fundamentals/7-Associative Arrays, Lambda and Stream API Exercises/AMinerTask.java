import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resourceQuantity = new LinkedHashMap<String, Integer>();
        mapEntries(resourceQuantity, scanner);
        printEntries(resourceQuantity);
    }

    static void printEntries(Map<String, Integer> resourceQuantity){
        for (Map.Entry<String, Integer> entry : resourceQuantity.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(), entry.getValue());
        }
    }

    static void mapEntries(Map<String, Integer> resourceQuantity, Scanner scanner){
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("stop")){
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());
            if(resourceQuantity.containsKey(resource)){
                int pastQuantity = resourceQuantity.get(resource);
                int newQuantity = pastQuantity + quantity;
                resourceQuantity.put(resource, newQuantity);
            }else {
                resourceQuantity.put(resource, quantity);
            }

            input = scanner.nextLine();
        }
    }
}
