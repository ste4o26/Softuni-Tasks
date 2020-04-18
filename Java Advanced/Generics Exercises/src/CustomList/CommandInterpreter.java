package CustomList;

public class CommandInterpreter {

    public static void executeCommand(CustomList<String> customList, String inputLine) {

        String[] tokens = inputLine.split("\\s+");
        String command = tokens[0];

        switch (command) {
            case "Add":
                String element = tokens[1];
                customList.add(element);
                break;

            case "Remove":
                int index = Integer.parseInt(tokens[1]);
                customList.remove(index);
                break;

            case "Contains":
                element = tokens[1];
                boolean isContainingBox = customList.contains(element);
                System.out.println(isContainingBox);
                break;

            case "Swap":
                int firstIndex = Integer.parseInt(tokens[1]);
                int secondIndex = Integer.parseInt(tokens[2]);
                customList.swap(firstIndex, secondIndex);
                break;

            case "Greater":
                String elementToCompareWith = tokens[1];
                int count = customList.countGreaterThan(elementToCompareWith);
                System.out.println(count);
                break;

            case "Max":
                System.out.println(customList.getMax());
                break;

            case "Min":
                System.out.println(customList.getMin());
                break;

            case "Print":
                customList.printEachElement();
                break;

            case "Sort":
                customList.sort();
        }
    }
}
