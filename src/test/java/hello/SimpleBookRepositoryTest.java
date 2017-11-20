package hello;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class SimpleBookRepositoryTest {

    BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = new SimpleBookRepository();
    }

    @Test(timeout = 3500)
    public void shouldUseCacheForMultipleRequests() {
        bookRepository.getByIsbn("81231211AD1");
        bookRepository.getByIsbn("81231211AD1");
        bookRepository.getByIsbn("81231211AD1");
        bookRepository.getByIsbn("81231211AD1");
        bookRepository.getByIsbn("81231211AD1");
        bookRepository.getByIsbn("81231211AD1");
        bookRepository.getByIsbn("81231211AD1");

        assertTrue(2 > 1);
    }
}