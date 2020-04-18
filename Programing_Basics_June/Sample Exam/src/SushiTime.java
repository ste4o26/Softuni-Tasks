import java.util.Scanner;

public class SushiTime {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String sushiType = sc.nextLine();
        String restorantName = sc.nextLine();
        int numberOfServings = Integer.parseInt(sc.nextLine());
        char takeAway = sc.nextLine().charAt(0);

        double sashimiPrice;
        double makiPrice;
        double uramakiPrice;
        double temakiPrice;

        boolean isForHome = takeAway == 'Y';
        boolean isSashimi = sushiType.equalsIgnoreCase("sashimi");
        boolean isMaki = sushiType.equalsIgnoreCase("maki");
        boolean isUramaki = sushiType.equalsIgnoreCase("uramaki");

        double totalPrice = 0;

        switch (restorantName) {
            case "Sushi Zone":
                sashimiPrice = 4.99;
                makiPrice = 5.29;
                uramakiPrice = 5.99;
                temakiPrice = 4.29;

                if(isSashimi){
                    totalPrice = Math.ceil(sashimiPrice * numberOfServings);
                }else if(isMaki){
                    totalPrice = Math.ceil(makiPrice * numberOfServings);
                }else if(isUramaki){
                    totalPrice = Math.ceil(uramakiPrice * numberOfServings);
                }else{
                    totalPrice = Math.ceil(temakiPrice * numberOfServings);
                }

                break;
            case "Sushi Time":
                sashimiPrice = 5.49;
                makiPrice = 4.69;
                uramakiPrice = 4.49;
                temakiPrice = 5.19;

                if(isSashimi){
                    totalPrice = Math.ceil(sashimiPrice * numberOfServings);
                }else if(isMaki){
                    totalPrice = Math.ceil(makiPrice * numberOfServings);
                }else if(isUramaki){
                    totalPrice = Math.ceil(uramakiPrice * numberOfServings);
                }else{
                    totalPrice = Math.ceil(temakiPrice * numberOfServings);
                }

                break;
            case "Sushi Bar":
                sashimiPrice = 5.25;
                makiPrice = 5.55;
                uramakiPrice = 6.25;
                temakiPrice = 4.75;

                if(isSashimi){
                    totalPrice = Math.ceil(sashimiPrice * numberOfServings);
                }else if(isMaki){
                    totalPrice = Math.ceil(makiPrice * numberOfServings);
                }else if(isUramaki){
                    totalPrice = Math.ceil(uramakiPrice * numberOfServings);
                }else{
                    totalPrice = Math.ceil(temakiPrice * numberOfServings);
                }

                break;
            case "Asian Pub":
                sashimiPrice = 4.50;
                makiPrice = 4.80;
                uramakiPrice = 5.50;
                temakiPrice = 5.50;

                if(isSashimi){
                    totalPrice = Math.ceil(sashimiPrice * numberOfServings);
                }else if(isMaki){
                    totalPrice = Math.ceil(makiPrice * numberOfServings);
                }else if(isUramaki){
                    totalPrice = Math.ceil(uramakiPrice * numberOfServings);
                }else{
                    totalPrice = Math.ceil(temakiPrice * numberOfServings);
                }

                break;

                default:
                    System.out.println(restorantName + " is invalid restaurant!");
                    return;
        }


        if(isForHome){
            totalPrice = (0.20 * totalPrice) + totalPrice;
            System.out.printf("Total price: %.0f lv.", totalPrice);
        }else {
            System.out.printf("Total price: %.0f lv.", totalPrice);
        }
    }
}
