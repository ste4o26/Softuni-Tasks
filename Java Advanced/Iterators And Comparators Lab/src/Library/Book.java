package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.authors = new ArrayList<>();
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    //priema argument ot tip string var args koito raboti kato masiv
    public void setAuthors(String... authors) {
        //dobavqm vsichki elementi v lista kato obrushtam masiva v list
        this.authors.addAll(Arrays.asList(authors));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        authors.forEach(author -> sb.append(author + System.lineSeparator()));
        return String.format("Book %s was wrote %d year from:%n%s", this.getTitle(), this.getYear(), sb);
    }

    @Override
    public int compareTo(Book book) {
        if (this.getTitle().compareTo(book.getTitle()) < 0) {
            return -1;
        } else if (this.getTitle().compareTo(book.getTitle()) > 0) {
            return 1;
        } else {
            if (this.getYear() < book.getYear()) {
                return -1;
            } else if (this.getYear() > book.getYear()) {
                return 1;
            } else {
                return 0;
            }

            //equivalent: return Integer.compare(this.getYear, book.getYear);
        }
    }
}
