import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        NodeMap map = new NodeMap();
        String inputLine = reader.readLine();

        while (!"end".equals(inputLine)){
            String[] tokens = inputLine.split("\\s+");
            String key = tokens[0];
            String value = tokens[1];
            map.put(key, value);

            inputLine = reader.readLine();
        }

        inputLine = reader.readLine();
        String town = map.get(inputLine);
        if (town == null) {
            System.out.println("No such element!");
        } else {
            System.out.println(town);
        }
    }


    private static void printList(NodeList list) {
        Node currentNode = list.getHead();
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }
    }
}
