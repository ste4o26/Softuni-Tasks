import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> periodicTable = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            periodicTable.addAll(Arrays.asList(tokens));// add all elements from collection to a set/map
        }
        periodicTable.forEach(element -> System.out.print(element + " "));
    }
}
