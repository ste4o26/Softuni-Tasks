import java.util.Scanner;

public class FruitOrVagetables {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String productName = sc.nextLine().toLowerCase();

        boolean isVegetable = productName.equals("tomato") || productName.equals("cucumber")
                                || productName.equals("pepper") || productName.equals("carrot");

        boolean isFruit = productName.equals("banana") || productName.equals("apple") || productName.equals("kiwi")
                            || productName.equals("cherry") || productName.equals("lemon") || productName.equals("grapes");


        if(isFruit){
            System.out.println("fruit");

        }else if(isVegetable){
            System.out.println("vegetable");

        }else {
            System.out.println("unknown");

        }
    }
}
