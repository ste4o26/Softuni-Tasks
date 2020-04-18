import java.util.Scanner;

public class TradeCommissions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String town = sc.nextLine();
        double saleQuantity = Double.parseDouble(sc.nextLine());

        boolean isSofia = town.equals("Sofia");
        boolean isVarna = town.equals("Varna");
        boolean isPlovdiv = town.equals("Plovdiv");

        boolean isSaleQuantityNegative = saleQuantity < 0;
        boolean isBetween0And500 = saleQuantity >= 0 && saleQuantity <= 500;
        boolean isBetween500And1000 = saleQuantity > 500 && saleQuantity <= 1000;
        boolean isBetween1000And10000 = saleQuantity > 1000 && saleQuantity <= 10000;


        if(!isSofia && !isVarna && !isPlovdiv){
            System.out.println("error");

        }else if(isSaleQuantityNegative){
            System.out.println("error");

        }else {

            if(isSofia){

                if(isBetween0And500){
                    saleQuantity = saleQuantity * 0.05;
                    System.out.printf("%.2f", saleQuantity);

                }else if(isBetween500And1000){
                    saleQuantity = saleQuantity * 0.07;
                    System.out.printf("%.2f", saleQuantity);

                }else if(isBetween1000And10000){
                    saleQuantity = saleQuantity * 0.08;
                    System.out.printf("%.2f", saleQuantity);

                }else{
                    saleQuantity = saleQuantity * 0.12;
                    System.out.printf("%.2f", saleQuantity);

                }

            }else if(isVarna){

                if(isBetween0And500){
                    saleQuantity = saleQuantity * 0.045;
                    System.out.printf("%.2f", saleQuantity);

                }else if(isBetween500And1000){
                    saleQuantity = saleQuantity * 0.075;
                    System.out.printf("%.2f", saleQuantity);

                }else if(isBetween1000And10000){
                    saleQuantity = saleQuantity * 0.10;
                    System.out.printf("%.2f", saleQuantity);

                }else{
                    saleQuantity = saleQuantity * 0.13;
                    System.out.printf("%.2f", saleQuantity);

                }

            }else if(isPlovdiv){


                if(isBetween0And500){
                    saleQuantity = saleQuantity * 0.055;
                    System.out.printf("%.2f", saleQuantity);

                }else if(isBetween500And1000){
                    saleQuantity = saleQuantity * 0.08;
                    System.out.printf("%.2f", saleQuantity);

                }else if(isBetween1000And10000){
                    saleQuantity = saleQuantity * 0.12;
                    System.out.printf("%.2f", saleQuantity);

                }else{
                    saleQuantity = saleQuantity * 0.145;
                    System.out.printf("%.2f", saleQuantity);

                }
            }

        }
    }
}
