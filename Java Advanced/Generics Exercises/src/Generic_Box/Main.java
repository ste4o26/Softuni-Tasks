package Generic_Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        //Box of Integers
        for (int i = 0; i < n; i++) {
            int inputData = Integer.parseInt(reader.readLine());
            Box<Integer> integerBox = new Box<>(inputData);
            //splitvam rezultata poneje testovete v judge sa bez printiraneto na class a getClass() vrushta rezultat s class zalepen otpred
            //po tozi nachin ssled splita na 0 index imam prazen string a na 1 index rezultata
            System.out.println(integerBox.toString().split("class ")[1]);
        }


        //Box of Strings
        for (int i = 0; i < n; i++) {
            String inputData = reader.readLine();
            Box<String> integerBox = new Box<>(inputData);
            //splitvam rezultata poneje testovete v judge sa bez printiraneto na class a getClass() vrushta rezultat s class zalepen otpred
            //po tozi nachin ssled splita na 0 index imam prazen string a na 1 index rezultata
            System.out.println(integerBox.toString().split("class ")[1]);
        }
    }
}
