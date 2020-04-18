import java.util.Scanner;

public class Moving {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //read data
        int widthSpace = Integer.parseInt(sc.nextLine());
        int lengthSpace = Integer.parseInt(sc.nextLine());
        int heightSpace = Integer.parseInt(sc.nextLine());

        int totalFreeSpaces = widthSpace * lengthSpace * heightSpace;//in cubic meters
        int occupiedSpace = 0;


        boolean isDone = false;
        //moga da proverqvam v while(!str.equals("Done"))  ...
        // no za celtq trqbva da sym sazdal str izvan cikala a vytre v nego da breakvam ako occupiedSpace < totalFreeSpaces

        while (occupiedSpace < totalFreeSpaces){
            String str = sc.nextLine();

            if(str.equals("Done")){
                isDone = true;
                break;
            }
            //moga syshto da vadq mqstoto koeto zaemat kutiite ot freeSpace i da vartq cikala dokato freeSpace < 0
            int numOfCartons = Integer.parseInt(str);
            occupiedSpace += numOfCartons;

        }
        //calculate space that left or is needed and print it
        int leftSpace = Math.abs(totalFreeSpaces - occupiedSpace);

        //check if we are done or free space is full
        if(isDone){
            System.out.printf("%d Cubic meters left.", leftSpace);

        }else {
            System.out.printf("No more free space! You need %d Cubic meters more.", leftSpace);

        }
    }
}
