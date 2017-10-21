package frisky51.springframework.spring5webapp.repositories;

import frisky51.springframework.spring5webapp.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
