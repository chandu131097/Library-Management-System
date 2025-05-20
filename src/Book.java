public class Book {

    private String title;
    private String author;
    private String ISBN;
    private int publicationYear;

    public Book(String title , String author , String ISBN , int publicationYear){
        this.author = author;
        this.ISBN = ISBN;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
