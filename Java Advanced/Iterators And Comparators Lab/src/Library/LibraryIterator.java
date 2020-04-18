package Library;

import java.util.Iterator;
//syzdavam si class specialno za iteriraneto na Library
// (ili koito i da e klas kogato iskam da go iteriram dobra praktika) koito implementira Iterator
public class LibraryIterator implements Iterator<Book> {
    private Book[] books;
    private int nextIndex;

    public LibraryIterator(Book[] books) {
        this.nextIndex = 0;
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        if (this.nextIndex < books.length){
            return true;
        }else {
            return false;
        }

        //equivalent : return this.nextIndex < books.length;
    }

    @Override
    public Book next() {
        return this.books[nextIndex++];
    }
}
