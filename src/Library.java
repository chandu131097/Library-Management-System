import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Library {

    private String name;

    private List<Department> departmentList;

    private List<Patron> patronList;

    private static  int patronCount;

    public Library(String name){
        this.name = name;
        this.departmentList = new ArrayList<>();
        this.patronList = new ArrayList<>();
        patronCount = 1;
    }

    public Patron registerPatron(Person person){
        Patron patron = new Patron(patronCount , person);
        patronList.add(patron);
        patronCount++;
        return patron;
    }

    public void removePatron(Patron patron){
        patronList.remove(patron);
        patronCount--;
    }

    public void addDepartment(Department dept){
        this.departmentList.add(dept);
    }

    public void removeDepartment(Department dept){
        this.departmentList.remove(dept);
    }

    public void lendBook(Patron patron , String bookTitle){

        Department department = null;
        for(Department dept : departmentList){
            if (dept.checkBookAvailability(bookTitle) ){

                department = dept; break;
            }
        }
        if (department != null){

            Book book = department.getBook(bookTitle);
            if (book!=null){
                department.addBookToNotAvailable(book);
                patron.addBook(book);
            }
            else{
                System.out.println("Book Not available to lend");
            }
        }
        else{
            System.out.println("Book Not available to lend");
        }
    }

    public void bookCheckOut(Patron patron , String bookTitle){
        Department department = null;
        for(Department dept : departmentList){
            if (dept.checkBookNotAvailability(bookTitle) ){
                department = dept; break;
            }
        }
        if (department != null){
            Book book = department.getBook(bookTitle);
            department.addBookToAvailable(book);
            if (patron.removeBook(book)) System.out.println("Book Checked Out : "+book.getTitle());
            else System.out.println(book.getTitle() + " Not Available");
        }
        else{
            System.out.println("Book Not available to lend");
        }
    }

    public void displayDepartments(){
        System.out.println(this.name + " Departments --> ");
        for(Department dept : departmentList){
            System.out.println("Dept : " + dept.getName());
            System.out.println("Available Books : ");
            dept.displayAvailableBooks();
            System.out.println("Lent Books : ");
            dept.displayNotAvailableBooks();
            System.out.println(" ");
        }
    }

    public void displayPatrons(){
        System.out.println(this.name + "  Patrons --> ");
        for(Patron patron : patronList){
            System.out.println("Name : " + patron.getPerson().getName());
            HashMap<Book , LocalDateTime> borrowedBooks = patron.getBooksBorrowed();
            if (borrowedBooks.size()==0) System.out.println(" No Books borrowed");
            for(Book book : borrowedBooks.keySet()){
                System.out.println("borrowed book : "+book.getTitle() + " at : " + borrowedBooks.get(book));
            }
        }
    }

}
