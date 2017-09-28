package movietickets.domain.model;

import java.util.List;
import common.domain.model.GenericRepository;

public interface MovieRepository extends GenericRepository<Movie, Long> {

	Movie findById(Long i);
	Movie findByTitle(String movieTitle);
	List<Movie> findAll();
}
