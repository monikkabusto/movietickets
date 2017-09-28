package movietickets.domain.model;

import java.util.List;

import common.domain.model.GenericRepository;

public interface CinemaRepository extends GenericRepository<Cinema, Long> {

	Cinema findById(Long id);
	Cinema findByName(String name);
	List<Cinema> findAll();
}
