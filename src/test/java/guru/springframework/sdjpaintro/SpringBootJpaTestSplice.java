package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by vpiontkovs on 3/15/2022.
 */
@DataJpaTest
public class SpringBootJpaTestSplice {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testJpaTestSplice() {
        long countBefore = bookRepository.count();

        bookRepository.save(new Book("My Book", "12345", "Self"));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }
}
