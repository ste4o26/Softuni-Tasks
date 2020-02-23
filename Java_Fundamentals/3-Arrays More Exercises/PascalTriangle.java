import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        printArray(n);

    }

    static void printArray(int n) {
        int[] previous = new int[n];

        for (int currentRow = 1; currentRow <= n; currentRow++) {

            if (currentRow == 1) {
                previous[0] = 1;
                System.out.println(previous[0]);
                continue;
            } else if (currentRow == 2) {
                previous[0] = 1;
                previous[1] = 1;
                for (int element : previous) {
                    System.out.print(element + " ");
                }
                System.out.println();
                continue;
            } else {
                int[] next = new int[currentRow];
                for (int i = 0; i < currentRow; i++) {

                    if (i == 0) {
                        next[i] = 1;
                        System.out.print(next[i] + " ");
                        continue;
                    } else if (i == currentRow - 1) {
                        next[i] = 1;
                        System.out.println(next[i]);
                        continue;
                    } else {
                        next[i] = previous[i] + previous[i - 1];
                        System.out.print(next[i] + " ");
                    }
                }
                previous = next;
            }
        }
    }
}

