import java.util.Scanner;

public class CookieFactory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //read number of batches
        int batchesNumber = Integer.parseInt(sc.nextLine());
        //read products continuosly
        String productName = "";

        boolean hasSugar = false;
        boolean hasFlour = false;
        boolean hasEggs = false;
        int batch = 1;

        while(batch <= batchesNumber){
            productName = sc.nextLine();
            while(!(productName.equals("Bake!"))){

                switch(productName) {
                    case "sugar":
                        hasSugar = true;
                        break;

                    case "flour":
                        hasFlour = true;
                        break;

                    case "eggs":
                        hasEggs = true;
                        break;
                }

                productName = sc.nextLine();
            }

            if(hasEggs && hasFlour && hasSugar){
                System.out.printf("Baking batch number %d...%n", batch);
                hasSugar = false;
                hasFlour = false;
                hasEggs = false;
                batch++;

            }else {
                System.out.println("The batter should contain flour, eggs and sugar!");

            }
        }
        //check if the batter contain main products

        //if not print an error massage
        //and wait for another input and then again check are there all of the main products
        //otherwise print Backing batch number and set all of main products to false
        //end the program when you reach the number of cookies you need to bake
    }
}
