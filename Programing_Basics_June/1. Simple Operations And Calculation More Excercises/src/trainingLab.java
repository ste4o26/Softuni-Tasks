import java.util.Scanner;

public class trainingLab {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double roomLen = Double.parseDouble(sc.nextLine());
        double roomWidth = Double.parseDouble(sc.nextLine());


            int workPlaceWidth = 70;
            int workPlaceLen = 120;
            int corridorWidth = 100;
            int placeForFurniture = 3;

            roomLen = roomLen * 100;
            roomWidth = roomWidth * 100;

            roomWidth = roomWidth - corridorWidth;

            double workPlacesPerRow = roomWidth / workPlaceWidth;
            double workPlacesPerCollumn = roomLen / workPlaceLen;

            double totalWorkPlaces = Math.floor(workPlacesPerCollumn) * Math.floor(workPlacesPerRow) - placeForFurniture;

            System.out.printf("%.0f", totalWorkPlaces);

        }

    }