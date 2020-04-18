import java.util.Scanner;

public class FindTheRealQueen {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] multiArray = new char[8][8];
        fillMultiArray(multiArray, sc);
        for (int row = 0; row < multiArray.length; row++) {
            char[] array = multiArray[row];
            for (int coll = 0; coll < array.length; coll++) {
                char currentSymbol = array[coll];
                if (currentSymbol == 'q') {
                    boolean isValidQueen = checkIsValidQueen(row, coll, multiArray);
                    if (isValidQueen) {
                        System.out.println(row + " " + coll);
                    }
                }
            }
        }
    }


    static boolean checkIsValidQueen(int firstIndex, int secondIndex, char[][] multiArray) {
        if (killLeftQueens(firstIndex, secondIndex, multiArray) && killRightQueens(firstIndex, secondIndex, multiArray) &&
                killTopQueens(firstIndex, secondIndex, multiArray) && killBottomQueens(firstIndex, secondIndex, multiArray)){
            return true;
        } else {
            return false;
        }
    }

    static boolean killLeftQueens(int firstIndex, int secondIndex, char[][] multiArray) {
        boolean isValid = true;
        char[] array = multiArray[firstIndex];
        for (int coll = secondIndex - 1; coll >= 0; coll--) {
            char currentSymbol = array[coll];
            if (currentSymbol == 'q') {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    static boolean killRightQueens(int firstIndex, int secondIndex, char[][] multiArray) {
        boolean isValid = true;
        char[] array = multiArray[firstIndex];
        for (int coll = firstIndex + 1; coll < array.length; coll++) {
            char currentSymbol = array[coll];
            if (currentSymbol == 'q') {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    static boolean killTopQueens(int firstIndex, int secondIndex, char[][] multiArray) {
        boolean isValid = true;
        for (int row = firstIndex - 1; row >= 0; row--) {
            char currentSymbol = multiArray[row][secondIndex];
            if (currentSymbol == 'q') {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    static boolean killBottomQueens(int firsIndex, int secondIndex, char[][] multiArray) {
        boolean isValid = true;
        for (int row = firsIndex + 1; row < multiArray.length; row++) {
            char currentSymbol = multiArray[row][secondIndex];
            if (currentSymbol == 'q') {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    static void fillMultiArray(char[][] multiArray, Scanner sc) {
        for (int row = 0; row < multiArray.length; row++) {
            char[] array = new char[multiArray[row].length];
            String[] symbols = sc.nextLine().split("\\s+");
            for (int coll = 0; coll < array.length; coll++) {
                array[coll] = symbols[coll].charAt(0);
            }
            multiArray[row] = array;
        }
    }
}
