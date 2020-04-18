import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Double>> shopProducts = new TreeMap<>();
        String input = sc.nextLine();
        while (!input.equals("Revision")){
            String[] tokens = input.split(",\\s+");
            String shopName = tokens[0];
            String productName = tokens[1];
            double productPrice = Double.parseDouble(tokens[2]);
            Map<String, Double> productsPrice = shopProducts.get(shopName);

            if (shopProducts.containsKey(shopName)){
                productsPrice.putIfAbsent(productName, productPrice);
                shopProducts.put(shopName, productsPrice);
            }else {
                productsPrice = new LinkedHashMap<>();
                productsPrice.put(productName, productPrice);
                shopProducts.put(shopName, productsPrice);
            }
            input = sc.nextLine();
        }

        shopProducts.entrySet()
                .stream()
                .forEach(e -> {
                    String shopName = e.getKey();
                    System.out.println(shopName + "->");
                    Map<String, Double> products = e.getValue();
                    products
                            .entrySet()
                            .forEach(p -> System.out.printf("Product: %s, Price: %.1f%n", p.getKey(), p.getValue()));
                });
    }
}
