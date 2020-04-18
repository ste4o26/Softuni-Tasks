package valid_person;

public class Main {
    public static void main(String[] args) {


        try{
            Person peter = new Person("Peter", "Petrov", 20);
        }catch (IllegalArgumentException iae){
            System.err.println(iae.getClass().getSimpleName() + ": " + iae.getMessage());
        }

        try{
            Person alice = new Person("Alice", null , 38);
        }catch (IllegalArgumentException iae){
            System.err.println(iae.getClass().getSimpleName() + ": " + iae.getMessage());
        }


        try{
            Person noName = new Person("", "Vladimirova", 20);
        }catch (IllegalArgumentException iae){
            System.err.println(iae.getClass().getSimpleName() + ": " + iae.getMessage());
        }

        try{
            Person invalidAge = new Person("Alice", "Strahova", -1);
        }catch (IllegalArgumentException iae){
            System.err.println(iae.getClass().getSimpleName() + ": " + iae.getMessage());
        }


        try{
            Person invalidName = new Student("4arlie", "Shemov", 21);
        }catch (IllegalArgumentException iae){
            System.err.println(iae.getClass().getSimpleName() + ": " + iae.getMessage());
        }

    }
}
