package valid_person;

public class PersonValidator {

    public PersonValidator() {
    }

    public void isValidAge(int age){
        if (age < 0 || age >120){
            throw new IllegalArgumentException("Age should be in range [0 ... 120]!");
        }
    }

    public void isValidName(String name){
        if (name == null || isEmptyName(name)){
            throw new InvalidPersonNameException("name cannot be empty or null!");
        }


        for (char symbol : name.toCharArray()) {
            if (!Character.isLetter(symbol)){
                throw new InvalidPersonNameException("name contains unallowed symbols!");
            }
        }
    }

    private boolean isEmptyName(String name) {
        if (name.isBlank()){
           return true;
        }

        return false;
    }
}
