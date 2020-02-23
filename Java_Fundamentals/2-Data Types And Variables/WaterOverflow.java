import java.util.Scanner;
public class WaterOverflow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int waterTankCapacity = 255;
        int numberOfTimesInsertingWater = Integer.parseInt(sc.nextLine());


      //  int waterQuantity = Integer.parseInt(sc.nextLine());
        int pouredWater = 0;

        for (int i = numberOfTimesInsertingWater; i >= 1 ; i--) {

            int waterQuantity = Integer.parseInt(sc.nextLine());

            if(waterQuantity > waterTankCapacity){
                System.out.println("Insufficient capacity!");
            }else{
                waterTankCapacity -= waterQuantity;
                pouredWater += waterQuantity;
            }

        }

        System.out.println(pouredWater);
    }
}
