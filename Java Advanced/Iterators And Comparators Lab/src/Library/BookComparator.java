package Library;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        if (firstBook.getTitle().equals(secondBook.getTitle())) {
            return Integer.compare(firstBook.getYear(), secondBook.getYear());

//  equivalent:       return (firstBook.getYear() < secondBook.getYear() ? -1 :
//                    firstBook.getYear() > secondBook.getYear() ? 1 :
//                    0);

        } else {
            return firstBook.getTitle().compareTo(secondBook.getTitle());
        }
    }
}
