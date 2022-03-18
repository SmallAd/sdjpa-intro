package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.composite.AuthorEmbedded;
import guru.springframework.sdjpaintro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vpiontkovs on 3/18/2022.
 */
public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}
