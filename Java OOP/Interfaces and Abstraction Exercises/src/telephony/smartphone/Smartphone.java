package telephony.smartphone;

import telephony.validator.CallsValidator;
import telephony.validator.UrlValidator;
import telephony.validator.Validator;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;
    private Validator validator;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public List<String> getNumbers() {
        return this.numbers;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    @Override
    public String browse() {
        this.validator = new UrlValidator();
        StringBuilder sb = new StringBuilder();

        for (String url : this.urls) {
            try {
                validator.validate(url);
                sb.append(String.format("Browsing: %s!", url));
            } catch (IllegalArgumentException iae) {
                String message = iae.getMessage();
                sb.append(message);
            }

            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String call() {
        this.validator = new CallsValidator();
        StringBuilder sb = new StringBuilder();

        for (String telephoneNumber : this.numbers) {
            try {
                validator.validate(telephoneNumber);
                sb.append(String.format("Calling... %s", telephoneNumber));
            } catch (IllegalArgumentException iae) {
                String message = iae.getMessage();
                sb.append(message);
            }

            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }


}
