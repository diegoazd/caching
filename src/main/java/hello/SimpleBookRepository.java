package hello;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class SimpleBookRepository implements BookRepository {
    public static final Logger log = Logger.getAnonymousLogger();

    @Override
    @Cacheable(value = "books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }
    // Don't do this at home
    private void simulateSlowService() {
        try {
            log.info("Fetching new instance");
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
