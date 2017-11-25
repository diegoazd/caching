package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Transactional
    public Book saveAndGetBook(String isbn, String title) {
        bookRepository.save(isbn, title);
        assert  bookRepository.getByIsbn(isbn).getIsbn().equals(isbn);
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bookRepository.getByIsbn(isbn);
    }
}
