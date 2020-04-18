public class NumbersEndingIn7 {

    public static void main(String[] args) {

        for (int number = 7; number <= 997; number++) {

            if(number % 10 == 7){
                System.out.println(number);
            }
        }
    }
}
