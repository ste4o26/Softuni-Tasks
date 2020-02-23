import java.util.Scanner;
public class MaxSequenceOfElements2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input[] = scanner.nextLine().split(" ");

        int seqOfNumbers[] = new int[input.length];

        for (int i = 0; i < seqOfNumbers.length; i++) {
            seqOfNumbers[i] = Integer.parseInt(input[i]);
        }



        //1 - vurtq cikal za vsichki elementi
        //2 - za vseki edin element ot masiva vurtq vtori vlojen cikal
        // s koito proverqvam dali tekushtiq element e raven s nqkoi ot sledvashtite
        //3 - purvo proverqvam dali tekushtiq element e raven na sledva]iq po red ot cikala
        //3.1 - ako e proverqvam dali nai dylgata poredica ot chisla e po malka ot tekushtata poredica koqto sum poluchil
        //i ako da prisvoqvam stojnosti na promenlivite koito sa mi nujni za da izprintiram masiva sled tova
        //3.2 - ako ne prosto breakvam cikala za da ne se osashtestvqt operacii koito shte poprechat na
        // normalnoto izpalnenie na programata
        //4 - povtori

        int longestSeq = 0;
        int bestIndex = 0;
        int currentIndex = 0;

        for (int i = 0; i < seqOfNumbers.length; i++) {
            int currentSeq = 0;

            for (int j = i; j < seqOfNumbers.length; j++) {
                if(seqOfNumbers[i] == seqOfNumbers[j]){
                    currentSeq++;
                    currentIndex = i;

                    if(currentSeq > longestSeq){
                        longestSeq = currentSeq;
                        bestIndex = currentIndex;
                    }
                }else {
                    break;
                }
            }
        }

        for (int i = bestIndex; i < longestSeq + bestIndex; i++) {
            System.out.printf("%d ", seqOfNumbers[i]);
        }
    }
}
