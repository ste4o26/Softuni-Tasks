package ArrayCreator;

public class Main {

    public static void main(String[] args) {

        String[] allices = ArrayCreator.create(10, "Allice");
        Integer[] integers = ArrayCreator.create(5, 26);

        String[] mitkos = ArrayCreator.create(String.class, 5, "Mitko");
        Double[] doubles = ArrayCreator.create(Double.class, 10, 2.5);

        printArray(allices);
        printArray(integers);
        printArray(mitkos);
        printArray(doubles);

    }

    private static <T> void printArray(T[] items) {
        for (T item : items) {
            System.out.println(item);
        }
    }
}
