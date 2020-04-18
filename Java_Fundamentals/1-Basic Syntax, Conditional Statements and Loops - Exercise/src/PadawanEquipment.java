import java.util.Scanner;
public class PadawanEquipment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double moneyAmount = Double.parseDouble(sc.nextLine());
        int numberOfStudents = Integer.parseInt(sc.nextLine());
        double lightSaberPrice = Double.parseDouble(sc.nextLine());
        double robePrice = Double.parseDouble(sc.nextLine());
        double beltPrice = Double.parseDouble(sc.nextLine());

        double totalLightSaberPrice = (lightSaberPrice * Math.ceil(numberOfStudents + (numberOfStudents*0.10)));
        double totalRobePrice = robePrice * numberOfStudents;
        double totalBeltPrice = beltPrice * numberOfStudents;

        for (int i = 6; i <= numberOfStudents; i+=6) {
            totalBeltPrice -= beltPrice;
        }

        double totalEquipmentPrice = totalLightSaberPrice + totalBeltPrice + totalRobePrice;

        boolean areMoneyEnoughForTheEquipment = moneyAmount >= totalEquipmentPrice;

        if(areMoneyEnoughForTheEquipment){
            System.out.printf("The money is enough - it would cost %.2flv.", totalEquipmentPrice);
        }else{
            System.out.printf("Ivan Cho will need %.2flv more.", Math.abs(totalEquipmentPrice - moneyAmount));
        }
    }
}
