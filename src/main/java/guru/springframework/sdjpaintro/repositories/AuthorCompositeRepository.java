package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.composite.AuthorComposite;
import guru.springframework.sdjpaintro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vpiontkovs on 3/18/2022.
 */
public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
