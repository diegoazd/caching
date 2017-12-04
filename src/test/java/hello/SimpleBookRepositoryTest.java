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

    @Test(timeout = 6100)
    public void shouldUseCacheForMultipleRequests() {
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");

        assertEquals(bookRepository.getByIsbn("81231211AD2").getIsbn(), "81231211AD2");
        assertEquals(bookRepository.getByIsbn("81231211AD2").getIsbn(), "81231211AD2");
        assertEquals(bookRepository.getByIsbn("81231211AD2").getIsbn(), "81231211AD2");
        assertEquals(bookRepository.getByIsbn("81231211AD2").getIsbn(), "81231211AD2");
        assertEquals(bookRepository.getByIsbn("81231211AD2").getIsbn(), "81231211AD2");
        assertEquals(bookRepository.getByIsbn("81231211AD2").getIsbn(), "81231211AD2");
        assertEquals(bookRepository.getByIsbn("81231211AD2").getIsbn(), "81231211AD2");
    }

    @Test(timeout = 3500)
    public void shouldUseCacheNoCacheForMultipleRequests() {
        BookRepository bookRepository = new SimpleBookRepository();
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");
        assertEquals(bookRepository.getByIsbn("81231211AD1").getIsbn(), "81231211AD1");
    }
}
