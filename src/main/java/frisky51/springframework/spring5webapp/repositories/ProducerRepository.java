package frisky51.springframework.spring5webapp.repositories;

import frisky51.springframework.spring5webapp.model.Producer;
import org.springframework.data.repository.CrudRepository;

public interface ProducerRepository extends CrudRepository<Producer, Long> {
}
