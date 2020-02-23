import java.util.Scanner;
public class ZigZagArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(sc.nextLine());

        String oddArray[] = new String[numberOfLines];
        String evenArray[] = new String[numberOfLines];


        //moga da mahna index promenlivata i da razmenq usloviqta v if i else i pak shte raboti
        int index = 0;
        for (int currentLine = 1; currentLine <= oddArray.length ; currentLine++) {

            String numbers[] = sc.nextLine().split(" ");

            if (currentLine % 2 == 0){
                oddArray[index] = numbers[1];
                evenArray[index] = numbers[0];
            }else {
                oddArray[index] = numbers[0];
                evenArray[index] = numbers[1];
            }

            index++;
        }

            System.out.println(String.join(" ", oddArray));
            System.out.println(String.join(" ", evenArray));

    }
}
