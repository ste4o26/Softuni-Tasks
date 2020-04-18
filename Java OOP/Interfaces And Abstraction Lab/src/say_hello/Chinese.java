package say_hello;

public class Chinese extends BasePerson{

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return String.format("Djydjybydjy");
    }
}
