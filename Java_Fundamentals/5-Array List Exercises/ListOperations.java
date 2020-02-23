import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        operateWithTheList(listOfNumbers, sc);
        printList(listOfNumbers);
    }

    static void operateWithTheList(List<Integer> listOfNumbers, Scanner sc){
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("end")){
            String[] operations = input.split("\\s+");
            int number = 0;
            int index = -1;
            switch (operations[0]){
                case "Add":
                    number = Integer.parseInt(operations[1]);
                    listOfNumbers.add(number);
                    break;

                case "Insert":
                    number = Integer.parseInt(operations[1]);
                    index = Integer.parseInt(operations[2]);
                    if (index < 0 || index > listOfNumbers.size()){
                        System.out.println("Invalid index");
                        break;
                    }
                    listOfNumbers.add(index, number);
                    break;

                case "Remove":
                    index = Integer.parseInt(operations[1]);
                    if (index < 0 || index > listOfNumbers.size()){
                        System.out.println("Invalid index");
                        break;
                    }
                    listOfNumbers.remove(index);
                    break;

                case "Shift":
                    String directionOfShifting = operations[1];
                    int count = Integer.parseInt(operations[2]);
                    if(directionOfShifting.equalsIgnoreCase("left")){
                        shiftFromLeft(listOfNumbers, count);
                    }else {
                        shiftFromRight(listOfNumbers, count);
                    }
                    break;
            }
            input = sc.nextLine();
        }
    }


    static void shiftFromLeft(List<Integer> listOfNumbers, int count){
        for (int i = 0; i < count; i++) {
            int currentNumber = listOfNumbers.get(0);
            listOfNumbers.add(currentNumber);
            listOfNumbers.remove(0);
        }
    }

    static void shiftFromRight(List<Integer> listOfNumbers, int count){
        for (int i = 0; i < count; i++) {
            int currentNumber = listOfNumbers.get(listOfNumbers.size() - 1);
            listOfNumbers.add(0, currentNumber);
            listOfNumbers.remove(listOfNumbers.size() - 1);
        }
    }

   static void printList(List<Integer> listOfNumbers){
        for (int i = 0; i < listOfNumbers.size(); i++) {
            System.out.print(listOfNumbers.get(i) + " ");
        }
    }
}
