package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vpiontkovs on 3/11/2022.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
