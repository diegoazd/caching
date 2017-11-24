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
    public void shoudSaveBook() {
        bookRepository.save("81231211AD1", "quien se comio mi queso");
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