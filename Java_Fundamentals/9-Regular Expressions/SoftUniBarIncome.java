import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String regex = "%(?<customer>[A-z][a-z]+)%[^\\|\\$\\.%]*?<(?<product>\\w+)>[^\\|\\$\\.%]*?\\|(?<quantity>\\d+)\\|[^\\|\\$\\.%]*?(?<price>\\d+\\.?\\d*)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalIncome = 0;
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String customerName = matcher.group("customer");
                String productName = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double productPrice = Double.parseDouble(matcher.group("price"));
                double customerTotalPrice = productPrice * quantity;
                totalIncome += customerTotalPrice;
                System.out.printf("%s: %s - %.2f%n", customerName, productName, customerTotalPrice);
            }
            input = sc.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
