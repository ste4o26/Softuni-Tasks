import java.util.Scanner;

public class Salary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfTabs = Integer.parseInt(sc.nextLine());
        double salary = Double.parseDouble(sc.nextLine());
        boolean isLoseSalary = false;


        for (int i = 0; i < numberOfTabs; i++) {
            String websiteName = sc.nextLine().toLowerCase();
            if(websiteName.equals("facebook")){
                salary -= 150;
            }else if(websiteName.equals("instagram")){
                salary -= 100;
            }else if( websiteName.equals("reddit")){
                salary -= 50;
            }

            if(salary <= 0){
                isLoseSalary = true;
                break;
            }
        }

        if(isLoseSalary){
            System.out.println("You have lost your salary.");
        }else{
            System.out.println((int)salary);
        }
    }
}
