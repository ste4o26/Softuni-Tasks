package reusing_classes;

public class Main {

    public static void main(String[] args) {

        RandomArrayList<String> randomArrayList = new RandomArrayList<>();

        randomArrayList.add("one");
        randomArrayList.add("two");
        randomArrayList.add("three");

        System.out.println(randomArrayList.getRandomElement());
    }
}
