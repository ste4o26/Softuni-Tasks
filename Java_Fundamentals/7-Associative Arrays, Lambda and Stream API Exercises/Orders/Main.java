package Orders;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Product> productsMap = new LinkedHashMap<>();
        fillMap(productsMap, sc);
        productsMap
                .forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value.getTotalPrice()));
    }

    static void fillMap(Map<String, Product> products, Scanner sc){
        String input = sc.nextLine();
        while (!input.equals("buy")){
            String[] tokens = input.split(" ");
            String productName = tokens[0];
            double productPrice = Double.parseDouble(tokens[1]);
            int productQuantity = Integer.parseInt(tokens[2]);

            if(products.containsKey(productName)){
                Product productDetails = products.get(productName);
                productDetails.setQuantity(productQuantity + productDetails.getQuantity());

                if(productDetails.getPrice() != productPrice){
                    productDetails.setPrice(productPrice);
                }

                productDetails.setTotalPrice(productDetails.getPrice() * productDetails.getQuantity());
                products.put(productName, productDetails);
            }else {
                Product product = new Product(productName, productPrice, productQuantity);
                product.setTotalPrice(product.getPrice() * product.getQuantity());
                products.put(productName, product);
            }

            input = sc.nextLine();
        }
    }
}
