import java.util.Scanner;

public class AccountBalance {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numOfInstallments = Integer.parseInt(sc.nextLine());
        double installmentQuantity;

        int count = 0;
        double sum = 0;
//moga i bez counter no v while trqbva uslovieto mi da e numOfInstallments > 0 i vseki pyt da namalqvam numOfInstallments
        while(count < numOfInstallments){
            installmentQuantity = Double.parseDouble(sc.nextLine());

            if(installmentQuantity < 0){
                System.out.println("Invalid operation!");
                break;
            }

            System.out.printf("Increase: %.2f\n", installmentQuantity);
            sum += installmentQuantity;

            count++;
        }

        System.out.printf("Total: %.2f\n", sum);
    }
}
