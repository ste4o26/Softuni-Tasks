import java.util.Scanner;

public class metricConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double metric = Double.parseDouble(sc.nextLine());
        String metricUnit = sc.nextLine();
        String metricUnitToConvert = sc.nextLine();

        boolean isMeterToMilimeter = metricUnit.equals("m") && metricUnitToConvert.equals("mm");
        boolean isMeterToCentimeter = metricUnit.equals("m") && metricUnitToConvert.equals("cm");
        boolean isMilimeterToMeter = metricUnit.equals("mm") && metricUnitToConvert.equals("m");
        boolean isMilimeterToCentimeter = metricUnit.equals("mm") && metricUnitToConvert.equals("cm");
        boolean isCentimeterToMeter = metricUnit.equals("cm") && metricUnitToConvert.equals("m");
        boolean isCentimeterToMilimeter = metricUnit.equals("cm") && metricUnitToConvert.equals("mm");

        if(isMeterToMilimeter){
            metric = metric * 1000;
            System.out.printf("%.3f", metric);

        } else if (isMeterToCentimeter){
            metric = metric * 100;
            System.out.printf("%.3f", metric);

        } else if (isMilimeterToMeter){
            metric = metric * 0.001;
            System.out.printf("%.3f", metric);

        } else if (isMilimeterToCentimeter){
            metric = metric * 0.1;
            System.out.printf("%.3f", metric);

        } else if (isCentimeterToMeter){
            metric = metric * 0.01;
            System.out.printf("%.3f", metric);

        } else if (isCentimeterToMilimeter){
            metric = metric * 10;
            System.out.printf("%.3f", metric);

        }
    }
}
