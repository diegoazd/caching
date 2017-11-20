package hello;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class SimpleBookRepository implements BookRepository {

    private static Logger log = Logger.getAnonymousLogger();
    Map<String, Book> cache;

    SimpleBookRepository() {
        cache = new ConcurrentHashMap<>();
    }

    @Override
    public Book getByIsbn(String isbn) {
        if(cache.containsKey(isbn)) {
            log.info("Getting key");
            return cache.get(isbn);
        }
        simulateSlowService();
        Book book = new Book(isbn, "Some book");
        cache.put(isbn, book);
        return book;
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            log.info("slow functiooooon");
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
