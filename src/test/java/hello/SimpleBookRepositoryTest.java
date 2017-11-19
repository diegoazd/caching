package hello;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class SimpleBookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

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

    @Test(timeout = 3500)
    public void shouldUseCacheNoCacheForMultipleRequests() {
        BookRepository bookRepository = new SimpleBookRepository();
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