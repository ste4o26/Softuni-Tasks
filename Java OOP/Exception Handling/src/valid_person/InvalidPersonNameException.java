package valid_person;

public class InvalidPersonNameException extends IllegalArgumentException {
    public InvalidPersonNameException() {
    }

    public InvalidPersonNameException(String s) {
        super(s);
    }

    public InvalidPersonNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
