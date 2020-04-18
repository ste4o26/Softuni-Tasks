package telephony.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidator implements Validator {
    @Override
    public void validate(String url) {
        if (isUrlContainsDigit(url)){
            throw new IllegalArgumentException("Invalid URL!");
        }
    }

    private boolean isUrlContainsDigit(String url) {
        String regex = "\\d";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()){
            return true;
        }
        return false;
    }
}
