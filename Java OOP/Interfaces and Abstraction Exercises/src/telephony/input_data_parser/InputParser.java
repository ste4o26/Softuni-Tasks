package telephony.input_data_parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class InputParser {
    private String input;

    public InputParser(String input) {
        this.input = input;
    }

    public List<String> parse(){
        return Arrays.stream(this.input.split("\\s+"))
                .collect(Collectors.toList());
    }
}
