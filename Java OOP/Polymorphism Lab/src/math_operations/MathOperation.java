package math_operations;

public class MathOperation {

    public MathOperation(){

    }

    public int add(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    public int add(int firstNumber, int secondNumber, int thirdNumber){
        int firstTwoNumbersResult = add(firstNumber, secondNumber);
        return firstTwoNumbersResult + thirdNumber;
    }

    public int add(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber){
        int firstThreeNumbersResult = add(firstNumber, secondNumber, thirdNumber);
        return firstThreeNumbersResult + fourthNumber;
    }
}
