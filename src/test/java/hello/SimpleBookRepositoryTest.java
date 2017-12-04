package hello;

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

    @Test
    public void shouldUseCacheForMultipleRequests() {
        bookRepository.getByIsbn("81231211AD1");
        bookRepository.getByIsbn("81231211AD2");
        try {
            Thread.sleep(30000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bookRepository.getByIsbn("81231211AD1");
        bookRepository.getByIsbn("81231211AD1");
        bookRepository.getByIsbn("81231211AD2");
        bookRepository.getByIsbn("81231211AD1");
        bookRepository.getByIsbn("81231211AD2");
        bookRepository.getByIsbn("81231211AD1");
        assertNotNull(bookRepository.getByIsbn("81231211AD2"));

    }

}
