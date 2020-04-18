import java.util.Scanner;

public class PersonalTitles {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double age = Double.parseDouble(sc.nextLine());
        String gender = sc.nextLine();

        boolean isMr = gender.equals("m");
        boolean isMasterOrMiss = age < 16;
        boolean isMrs = gender.equals("f");

        if(isMr){
            if(isMasterOrMiss){
                System.out.println("Master");

            }else {
                System.out.println("Mr.");

            }
        }else if(isMrs){
            if(isMasterOrMiss){
                System.out.println("Miss");

            }else {
                System.out.println("Ms.");
            }
        }
    }
}
