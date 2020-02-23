import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        manipulatingListAdvanced(listOfNumbers, sc);
    }

    static void manipulatingListAdvanced(List<Integer> list, Scanner sc){
        String[] input = sc.nextLine().split("\\s+");
        while (!(input[0].equalsIgnoreCase("end"))){
            String command = input[0];
            int number = 0;
            int sum = 0;
            switch (command){
                case "Contains":
                    number = Integer.parseInt(input[1]);
                    prntIsContainingNumber(list, number);
                    break;

                case "Print":
                    String isEven = input[1];
                    if(isEven.equalsIgnoreCase("even")){
                        printAllEvenNumbers(list);
                    }else {
                        printAllOddNumbers(list);
                    }
                    break;

                case "Get":
                    sum = getSumOfAllElements(list);
                    System.out.println(sum);
                    break;

                case "Filter":
                    String condition = input[1];
                    number = Integer.parseInt(input[2]);
                    printFilteredNumbers(list, number, condition);
                    break;
            }
            input = sc.nextLine().split("\\s+");
        }

    }

    static void printFilteredNumbers(List<Integer> list, int number, String condition){
        //<', '>', ">=", "<=
        switch (condition){
            case "<":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) < number){
                        System.out.print(list.get(i) + " ");
                    }
                }
                System.out.println();
                break;

            case ">":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) > number){
                        System.out.print(list.get(i) + " ");
                    }
                }
                System.out.println();
                break;

            case ">=":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) >= number){
                        System.out.print(list.get(i) + " ");
                    }
                }
                System.out.println();
                break;

            case "<=":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) <= number){
                        System.out.print(list.get(i) + " ");
                    }
                }
                System.out.println();
                break;
        }
    }

    static void prntIsContainingNumber(List<Integer> list, int number){
        boolean isContain = false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(number)){
                isContain = true;
                break;
            }
        }
        if(isContain){
            System.out.println("Yes");
        }else {
            System.out.println("No such number");
        }
    }

    static void printAllEvenNumbers(List<Integer> list){
        List<Integer> listOfEvenNumbers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0){
                listOfEvenNumbers.add(list.get(i));
            }
        }

        printList(listOfEvenNumbers);
    }

    static void printAllOddNumbers(List<Integer> list){
        List<Integer> listOfOddNumbers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(!(list.get(i) % 2 == 0)){
                listOfOddNumbers.add(list.get(i));
            }
        }

        printList(listOfOddNumbers);
    }

    static int getSumOfAllElements(List<Integer> list){
        int sumOfAllElements = 0;
        for (int element : list) {
            sumOfAllElements += element;
        }
        return sumOfAllElements;
    }




    static void printList(List<Integer> list){
        for (int element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}
