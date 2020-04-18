package Listy_Iterator;

public class CommandExecutor {


    public static void executeCommand(String input, CustomList elements) {

        String[] tokens = input.split("\\s+");
        String command = tokens[0];
        switch (command) {
            case "Move":
                System.out.println(elements.move());
                break;

            case "Print":
                if (elements.getSize() <= 0) {
                    System.out.println("Invalid Operation!");
                }else {
                    System.out.println(elements.getCurrentElement());
                }
                break;

            case "HasNext":
                System.out.println(elements.hasNext());
                break;

            case "PrintAll":
                for (String element : elements) {
                    System.out.print(element + " ");
                }
                System.out.println();
        }
    }
}
