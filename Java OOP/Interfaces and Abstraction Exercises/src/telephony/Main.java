package telephony;

import telephony.input_data_parser.InputParser;
import telephony.input_data_parser.TelephoneNumberParser;
import telephony.input_data_parser.UrlsParser;
import telephony.smartphone.Smartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = parseDataFromInput(reader);
        List<String> urls = parseDataFromInput(reader);

        Smartphone smartphone = new Smartphone(numbers, urls);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }

    private static List<String> parseDataFromInput(BufferedReader reader) throws IOException {
        String input = reader.readLine();

        InputParser inputParser;
        if (areTelephoneNumbers(input)) {
            inputParser = new TelephoneNumberParser(input);
        } else {
            inputParser = new UrlsParser(input);
        }

        return inputParser.parse();
    }

    //NAI VEROQTNO SHTE RABOTI SAMO ZA TEKUSHTIQ SLUCHEI PONEJE SE NADQVAM JUDGE DA NQMA TEST V KOITO PURVIOQ SIMVOL NA PURVIQ URL E CIFRA :D
    private static boolean areTelephoneNumbers(String input) {
        return Character.isDigit(input.charAt(0));
    }
}
