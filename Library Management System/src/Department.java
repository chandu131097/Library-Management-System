import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Department {

    private HashMap<Boolean , HashSet<Book>> books;

    private String name;
    private int numOfAvailableBooks;


    public Department(String name){
        HashSet<Book> available = new HashSet<>();
        HashSet<Book> notavailable = new HashSet<>();
        this.books = new HashMap<>();
        this.books.put(true , available);
        this.books.put(false , notavailable);
        this.numOfAvailableBooks = 0;
        this.name = name;
    }

    public HashMap<Boolean , HashSet<Book>> getBooks(){
        return this.books;
    }

    public String getName() {
        return name;
    }

    public void addBookToAvailable(Book book){
        books.get(true).add(book);
        books.get(false).remove(book);
        this.numOfAvailableBooks++;
    }

    public void addBookToNotAvailable(Book book){
        this.books.get(true).remove(book);
        this.books.get(false).add(book);
        this.numOfAvailableBooks--;
    }

    public boolean checkBookAvailability(Book book){
        HashSet<Book> bookset = books.get(true);

        return (bookset.contains(book)) ? true : false;
    }

    public boolean checkBookAvailability(String bookname){
        HashSet<Book> bookset = books.get(true);

        for(Book bookFromSet : bookset){
            if (bookFromSet.getTitle().trim().equalsIgnoreCase(bookname.trim())) return true;
        }
        return false;
    }

    public boolean checkBookNotAvailability(Book book){
        HashSet<Book> bookset = books.get(false);
        return (bookset.contains(book)) ? true : false;
    }


    public boolean checkBookNotAvailability(String bookname){
        HashSet<Book> bookset = books.get(false);

        for(Book bookFromSet : bookset){
            if (bookFromSet.getTitle().trim().equalsIgnoreCase(bookname.trim())) return true;
        }
        return false;
    }

    public void displayAvailableBooks(){
        HashSet<Book> bookset = books.get(true);
        if(bookset.size()==0) System.out.println("0 books");
        for(Book book : bookset){
            System.out.println("title : " + book.getTitle() + " Author :" + book.getAuthor());
        }
    }

    public void displayNotAvailableBooks(){
        HashSet<Book> bookset = books.get(false);
        if(bookset.size()==0) System.out.println("0 books");
        for(Book book : bookset){
            System.out.println("title : " + book.getTitle() + " Author :" + book.getAuthor());
        }
    }

    public Book getBook(String title){

        HashSet<Book> bookset = books.get(false);

        for(Book bookFromSet : bookset){
            if (bookFromSet.getTitle().trim().equalsIgnoreCase(title.trim())) return bookFromSet;
        }

        bookset = books.get(true);

        for(Book bookFromSet : bookset){
            if (bookFromSet.getTitle().trim().equalsIgnoreCase(title.trim())) return bookFromSet;
        }

        return null;
    }
}
