package telephony.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallsValidator implements Validator {

    @Override
    public void validate(String telephoneNumber) {
        if (isTelephoneNumberContainsOtherSymbolThenDigit(telephoneNumber)) {
            throw new IllegalArgumentException("Invalid number!");
        }
    }

    private boolean isTelephoneNumberContainsOtherSymbolThenDigit(String telephoneNumber) {
        String regex = "[^\\d]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telephoneNumber);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}
