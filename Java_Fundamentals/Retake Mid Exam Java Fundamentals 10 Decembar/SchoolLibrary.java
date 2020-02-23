import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> booksList = Arrays.stream(sc.nextLine().split("&"))
                .collect(Collectors.toList());

        String inputLine = sc.nextLine();
        while (!inputLine.equals("Done")) {
            String[] tokens = inputLine.split(" \\| ");
            String command = tokens[0];
            String bookName = null;
            switch (command) {
                case "Add Book":
                    bookName = tokens[1];
                    if (!booksList.contains(bookName)) {
                        booksList.add(0, bookName);
                    }
                    break;

                case "Take Book":
                    bookName = tokens[1];
                    if (booksList.contains(bookName)){
                        booksList.remove(bookName);
                    }
                    break;

                case "Swap Books":
                    String firstBook = tokens[1];
                    String secondBook = tokens[2];
                    if(booksList.contains(firstBook) && booksList.contains(secondBook)){
                        for (int i = 0; i < booksList.size(); i++) {
                            if(booksList.get(i).equals(firstBook)){
                                booksList.set(i, secondBook);
                                continue;
                            }
                            if (booksList.get(i).equals(secondBook)){
                                booksList.set(i, firstBook);
                            }
                        }
                    }
                    break;

                case "Insert Book":
                    bookName = tokens[1];
                    booksList.add(bookName);//maybe if for check
                    break;

                case "Check Book":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < booksList.size()){
                        System.out.println(booksList.get(index));
                    }
                    break;
            }

            inputLine = sc.nextLine();
        }

        System.out.println(String.join(", ", booksList));
    }
}
