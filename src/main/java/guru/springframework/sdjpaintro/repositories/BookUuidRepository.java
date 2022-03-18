package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.BookUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by vpiontkovs on 3/18/2022.
 */
public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {
}
