import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
public class SumAdjacentEqualNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        List <Double> listOfNumbers = new ArrayList<Double>();

        fillArrayList(listOfNumbers, input);
        sumAdjacentEqualsNumbers(listOfNumbers);
    }
    
    static void fillArrayList(List<Double> listOfNumbers, String[] input){
        for (int i = 0; i < input.length; i++) {
            listOfNumbers.add(Double.parseDouble(input[i]));
        }
    }

    static void sumAdjacentEqualsNumbers(List<Double> listOfNumbers){
        int i = 0;
        while (i < listOfNumbers.size() - 1){
            double sum = 0;
            if(listOfNumbers.get(i).equals(listOfNumbers.get(i + 1))){
                sum = listOfNumbers.get(i) + listOfNumbers.get(i + 1);
                listOfNumbers.set(i, sum);
                listOfNumbers.remove(i + 1);
                i = 0;
            }else {
                i++;
            }
        }

        printList(listOfNumbers);
    }

    static void printList(List<Double> listOfNumbers){
        String output = "";
        for (double element : listOfNumbers) {
            output += (new DecimalFormat("0.#").format(element) + " ");// bace kva e taq magiq :D
        }
        System.out.println(output);
    }
}
