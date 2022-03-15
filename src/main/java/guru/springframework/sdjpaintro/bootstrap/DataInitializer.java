package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by vpiontkovs on 3/11/2022.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        long count = bookRepository.count();
        if (count == 0) {
            Book bookDDD = new Book("Domain Driven Design", "123", "Random");

            System.out.println("Id: " + bookDDD.getId());

            Book savedDDD = bookRepository.save(bookDDD);

            System.out.println("Id: " + savedDDD.getId());

            Book bookSIA = new Book("Spring In Action", "234234", "Oriely");
            Book savedSIA = bookRepository.save(bookSIA);

            bookRepository.findAll().forEach(book -> {
                System.out.println("Book Id: " + book.getId());
                System.out.println("Book Title: " + book.getTitle());
            });
        }
    }
}
