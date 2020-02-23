    import java.util.Scanner;
    public class RefactoringPrimeChecker {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int rangeOfNumbers = Integer.parseInt(sc.nextLine());

            for (int currentNumber = 2; currentNumber <= rangeOfNumbers; currentNumber++) {
                boolean isPrimeNumber = true;
                for (int divider = 2; divider < currentNumber; divider++) {
                    if (currentNumber % divider == 0){
                        isPrimeNumber = false;
                       break;
                    }
                }
                System.out.printf("%d -> %b%n", currentNumber, isPrimeNumber);
            }

        }
    }
