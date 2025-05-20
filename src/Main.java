import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library lib = new Library("Golconda Library");

        Department dept1 = new Department("Mathematics");
        Book book1 = new Book("Trigonometry", "Author-1" , "1" , 1990);
        Book book2 = new Book("Algebra", "Author-1" , "2" , 1990);
        Book book3 = new Book("Calculus", "Author-2" , "3" , 1990);
        dept1.addBookToAvailable(book1);dept1.addBookToAvailable(book2);dept1.addBookToAvailable(book3);

        Department dept2 = new Department("Political Science");
        Book book4 = new Book("Civil Services", "Author-3" , "4" , 1990);
        Book book5 = new Book("Constitution", "Author-4" , "5" , 1990);
        Book book6 = new Book("Democracy", "Author-4" , "6" , 1990);
        dept2.addBookToAvailable(book4);dept2.addBookToAvailable(book5);dept2.addBookToAvailable(book6);

        lib.addDepartment(dept1);
        lib.addDepartment(dept2);

        Person p1 = new Person("Chandra", "1111111" , "Visakhapatnam");
        Person p2 = new Person("Prashanth", "2222222" , "Karimnagar");
        Person p3 = new Person("Abhishek", "33333333" , "Chandigarh");

        Patron patron1 = lib.registerPatron(p1);
        Patron patron2 = lib.registerPatron(p2);
        Patron patron3 = lib.registerPatron(p3);


        lib.lendBook(patron1, "Trigonometry");lib.lendBook(patron1, "Democracy");

        lib.lendBook(patron2, "Algebra");lib.lendBook(patron1, "Constitution");

        System.out.println("************************************* Borrowed Books ****************");
        lib.displayDepartments();
        lib.displayPatrons();

        lib.bookCheckOut(patron1,"Democracy");
        lib.bookCheckOut(patron1,"Constitution");

        System.out.println("************************************* Checkedout Books ****************");
        lib.displayDepartments();
        lib.displayPatrons();

    }
}