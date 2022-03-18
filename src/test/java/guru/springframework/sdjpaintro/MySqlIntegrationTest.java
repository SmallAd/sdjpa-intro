package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.AuthorUuid;
import guru.springframework.sdjpaintro.domain.BookNatural;
import guru.springframework.sdjpaintro.domain.BookUuid;
import guru.springframework.sdjpaintro.domain.composite.AuthorComposite;
import guru.springframework.sdjpaintro.domain.composite.AuthorEmbedded;
import guru.springframework.sdjpaintro.domain.composite.NameId;
import guru.springframework.sdjpaintro.repositories.AuthorCompositeRepository;
import guru.springframework.sdjpaintro.repositories.AuthorEmbeddedRepository;
import guru.springframework.sdjpaintro.repositories.AuthorUuidRepository;
import guru.springframework.sdjpaintro.repositories.BookNaturalRepository;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import guru.springframework.sdjpaintro.repositories.BookUuidRepository;
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
public class MySqlIntegrationTest {
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookUuidRepository bookUuidRepository;

    @Autowired
    private AuthorUuidRepository authorUuidRepository;

    @Autowired
    private BookNaturalRepository bookNaturalRepository;

    @Autowired
    private AuthorCompositeRepository authorCompositeRepository;

    @Autowired
    private AuthorEmbeddedRepository authorEmbeddedRepository;

    @Test
    void testAuthorEmbedded() {
        NameId nameId = new NameId("Vadim", "P");
        AuthorEmbedded authorEmbedded = new AuthorEmbedded(nameId);
        authorEmbedded.setCountry("RU");

        AuthorEmbedded saved = authorEmbeddedRepository.save(authorEmbedded);
        assertThat(saved).isNotNull();

        AuthorEmbedded fetched = authorEmbeddedRepository.getById(nameId);
        assertThat(fetched).isNotNull();
    }

    @Test
    void testAuthorComposite() {
        NameId nameId = new NameId("Vadim", "P");
        AuthorComposite authorComposite = new AuthorComposite();
        authorComposite.setFirstName(nameId.getFirstName());
        authorComposite.setLastName(nameId.getLastName());
        authorComposite.setCountry("RU");

        AuthorComposite saved = authorCompositeRepository.save(authorComposite);
        assertThat(saved).isNotNull();

        AuthorComposite fetched = authorCompositeRepository.getById(nameId);
        assertThat(fetched).isNotNull();
    }

    @Test
    void testBookNatural() {
        BookNatural bookNatural = new BookNatural();
        bookNatural.setTitle("My Book");

        BookNatural saved = bookNaturalRepository.save(bookNatural);

        BookNatural fetched = bookNaturalRepository.getById(saved.getTitle());

        assertThat(fetched).isNotNull();
    }

    @Test
    void testBookUuid() {
        BookUuid saved = bookUuidRepository.save(new BookUuid());
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();

        BookUuid fetched = bookUuidRepository.getById(saved.getId());
        assertThat(fetched).isNotNull();
    }

    @Test
    void testAuthorUuid() {
        AuthorUuid saved = authorUuidRepository.save(new AuthorUuid());
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();

        AuthorUuid fetched = authorUuidRepository.getById(saved.getId());
        assertThat(fetched).isNotNull();
    }

    @Test
    void testMySql() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }
}
