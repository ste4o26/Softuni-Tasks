import java.util.Scanner;

public class OldBoocks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //read input
        String bookName = sc.nextLine();
        int libraryCapacity = Integer.parseInt(sc.nextLine());

        int booksCounter = 0;
        boolean isRightOne = false;

        //reapeat tasks until library capacity is over
        while (booksCounter < libraryCapacity) {

            String bookToCompare = sc.nextLine();

            //check if you found the correct book
            if (bookName.equals(bookToCompare)) {
                isRightOne = true;
                break;
            }
                //increment counter
                booksCounter++;
        }


        if (isRightOne) {
            System.out.printf("You checked %d books and found it.", booksCounter);

        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", booksCounter);
        }

    }
}
