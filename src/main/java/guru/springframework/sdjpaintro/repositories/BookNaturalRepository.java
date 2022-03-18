package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.BookNatural;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vpiontkovs on 3/18/2022.
 */
public interface BookNaturalRepository extends JpaRepository<BookNatural, String> {
}
