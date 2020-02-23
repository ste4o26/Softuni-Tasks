import java.util.Scanner;
public class BeerKegs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfKegs = Integer.parseInt(sc.nextLine());

        double kegVolume = 0;
        String biggestKegModel = "";
        double maxVolume = Integer.MIN_VALUE;

        for (int kegCounter = 0; kegCounter < numberOfKegs; kegCounter++) {

            String kegModel = sc.nextLine();
            double kegRadius = Double.parseDouble(sc.nextLine());
            int kegHeight = Integer.parseInt(sc.nextLine());

            kegVolume = Math.PI * (kegRadius * kegRadius) * kegHeight;

            if(kegVolume > maxVolume){
                maxVolume = kegVolume;
                biggestKegModel = kegModel;
            }
        }

        System.out.println(biggestKegModel);




    }
}
