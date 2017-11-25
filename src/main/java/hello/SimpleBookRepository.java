package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class SimpleBookRepository implements BookRepository {

    public static final Logger log = Logger.getAnonymousLogger();

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Book getByIsbn(String isbn) {
        return hibernateTemplate.get(Book.class, isbn);
    }

    @Override
    public void save(String isbn, String title) {
       hibernateTemplate.save(new Book(isbn, title));
    }
}
