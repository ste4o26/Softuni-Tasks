import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> furnitureList = new ArrayList<>();
        double totalPrice = validateFurniturePrice(sc, furnitureList);
        System.out.println("Bought furniture: ");
        furnitureList.forEach(e -> System.out.println(e));
        System.out.printf("Total money spend: %.2f", totalPrice);

    }
    static double validateFurniturePrice(Scanner sc, List<String> furnitureList){
        String regex = ">>(?<name>[A-Za-z]+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        String input = sc.nextLine();
        double totalPrice = 0;

        while (!input.equals("Purchase")){
            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                String furnitureName = matcher.group("name");
                furnitureList.add(furnitureName);
                double furniturePrice = Double.parseDouble(matcher.group("price"));
                int furnitureQuantity = Integer.parseInt((matcher.group("quantity")));
                totalPrice += furniturePrice * furnitureQuantity;
            }

            input = sc.nextLine();
        }

        return totalPrice;
    }
}
