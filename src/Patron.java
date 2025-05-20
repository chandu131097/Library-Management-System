import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Patron {
    private int id;
    private Person person;
    private HashMap<Book, LocalDateTime> booksBorrowed;
    private int numOfBooksBorrowed;

    public Patron(int id , Person person){
        this.person = person;
        this.id = id;
        this.booksBorrowed = new HashMap<>();
        this.numOfBooksBorrowed = 0;
    }

    public void addBook(Book book){
        LocalDateTime myDateObj = LocalDateTime.now();
        booksBorrowed.put(book , myDateObj);
        this.numOfBooksBorrowed++;
    }

    public boolean removeBook(String title , String author){
        Book bookToDelete = null;
        for(Book book : booksBorrowed.keySet()){
            if (book.getTitle() == title && book.getAuthor() == author){
                bookToDelete = book; break;
            }
        }
        booksBorrowed.remove(bookToDelete);
        this.numOfBooksBorrowed--;
        return (bookToDelete == null ) ? false : true;
    }

    public boolean removeBook(Book book){
        if (booksBorrowed.containsKey(book) == false) return false;
        booksBorrowed.remove(book);
        this.numOfBooksBorrowed--;

        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Book, LocalDateTime> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(HashMap<Book, LocalDateTime> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

}
