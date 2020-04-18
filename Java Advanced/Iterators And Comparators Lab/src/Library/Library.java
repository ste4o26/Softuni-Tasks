package Library;

import java.util.Iterator;

//Iterable neshtoto koeto shte obhojdame -> kolekciqta koqto shte obhojdame
//Iterator mqstoto na koeto znaem do kyde sme stignali
public class Library implements Iterable<Book>{

    private Book[] books;

    public Library(Book...books) {
        this.books = books;
    }

    @Override
    //za vsqka iteraciq na foreach se vika metoda iterator
    public Iterator<Book> iterator() {
         return new LibraryIterator(books);
    }
}
