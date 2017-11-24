package hello;

public interface BookRepository {

    Book getByIsbn(String isbn);
    void save(String isbn, String title);

}