import java.util.Scanner;

public class tailoringWorkshop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tables = Integer.parseInt(sc.nextLine());
        double tableLen = Double.parseDouble(sc.nextLine());
        double tableWidth = Double.parseDouble(sc.nextLine());
        int clothePriceUSD = 7;
        int coverPriceUSD = 9;

        double tableClotheArea =  (tableLen + 2 * 0.30) * (tableWidth + 2 * 0.30);
        double tableCoverArea  = (tableLen/2)*(tableLen/2);

        double totalTableClotheArea = tables * tableClotheArea;
        double totalTableCoverArea = tables * tableCoverArea;

        double tableClothePriceUSD = totalTableClotheArea * clothePriceUSD;
        double tableCoverPriceUSD = totalTableCoverArea * coverPriceUSD;

        double totalPriceUSD = tableClothePriceUSD + tableCoverPriceUSD;
        double course = 1.85;

        double totalPriceBGN = totalPriceUSD * course;

        System.out.printf("%.2f USD \n%.2f BGN", totalPriceUSD, totalPriceBGN);
    }
}
