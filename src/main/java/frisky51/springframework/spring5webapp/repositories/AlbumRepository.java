package frisky51.springframework.spring5webapp.repositories;

import frisky51.springframework.spring5webapp.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {

}
