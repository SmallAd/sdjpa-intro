package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by vpiontkovs on 3/15/2022.
 */
@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = "guru.springframework.sdjpaintro.bootstrap")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MySqlIT {
    
    @Autowired
    private BookRepository bookRepository;

    @Test
    void testMySql() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }
}
