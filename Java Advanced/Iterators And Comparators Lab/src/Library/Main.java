package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Book firstBook = new Book("Animal Farm", 2003, "George Orwell");
        Book secondBook = new Book("The Documents in the Case", 2002);
        Book thirdBook = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");


//        //second example judge submission(iterable and iterator)
//        Library library = new Library(firstBook, secondBook, thirdBook);
//
//        for (Book book : library) {
//            System.out.println(book);
//        }

//
//        //third example judge submission (comparable)
//        if (firstBook.compareTo(secondBook) > 0){
//            System.out.println(firstBook.getTitle() + " is before " + secondBook.getYear());
//        }else if (firstBook.compareTo(secondBook) < 0){
//            System.out.println(secondBook.getTitle() + " is before " + firstBook.getTitle());
//        }else {
//            System.out.println("Books are equals");
//        }


        List<Book> books = new ArrayList<Book>();

        books.add(firstBook);
        books.add(secondBook);
        books.add(thirdBook);

        books
                .stream()
                .sorted(new BookComparator())
                .forEach(System.out::println);
    }
}
