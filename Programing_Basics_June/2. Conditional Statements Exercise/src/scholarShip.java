import java.util.Scanner;

public class scholarShip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        double parentIncome = Double.parseDouble(sc.nextLine());
        double averageSuccess = Double.parseDouble(sc.nextLine());
        double minWorkSall = Double.parseDouble(sc.nextLine());


        boolean isSococialScholarship = parentIncome < minWorkSall && averageSuccess > 4.5;
        boolean isExcellentScholaship = averageSuccess >= 5.5;

        double socialScholarshipAmount = Math.floor(minWorkSall * 0.35);
        double excellentScholarshipAmount = Math.floor(averageSuccess * 25);


        if(isSococialScholarship && isExcellentScholaship){

            if(socialScholarshipAmount > excellentScholarshipAmount){
                System.out.printf("You get a Social scholarship %.0f BGN", socialScholarshipAmount);

            }else{
                System.out.printf("You get a scholarship for excellent results %.0f BGN", excellentScholarshipAmount);

            }

        }else if(isSococialScholarship && !(isExcellentScholaship)){
            System.out.printf("You get a Social scholarship %.0f BGN", socialScholarshipAmount);

        }else if(!(isSococialScholarship) && isExcellentScholaship){
            System.out.printf("You get a scholarship for excellent results %.0f BGN", excellentScholarshipAmount);

        }else{
            System.out.println("You cannot get a scholarship!");

        }

    }
}