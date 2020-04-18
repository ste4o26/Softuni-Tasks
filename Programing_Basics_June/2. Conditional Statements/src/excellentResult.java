import java.util.Scanner;

public class excellentResult {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double grade = Double.parseDouble(sc.nextLine());
        boolean isExcellentGrade = grade >= 5.5;

        if(isExcellentGrade){
            System.out.println("Excellent!");

        }
    }
}
