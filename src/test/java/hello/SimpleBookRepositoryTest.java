package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class SimpleBookRepositoryTest {
    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Autowired
    BookService bookService;

    @Test
    public void shouldSeeFirstLevelCache() {
        String isbn = generateString();
        Book book = bookService.saveAndGetBook(isbn, "quien se comio mi queso");
        assertEquals(isbn, book.getIsbn());

    }

    private String generateString() {
        final String random = generateRandomString(new StringBuilder());
        System.out.println(random);
        return random;
    }

    private String generateRandomString(StringBuilder sb) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();
    }

}