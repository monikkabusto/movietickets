package movietickets.domain.model;

import java.util.List;

import common.domain.model.GenericRepository;

public interface NowShowingRepository extends GenericRepository<NowShowing, Long> {

	NowShowing findById(Long id);
	List<NowShowing> findAll();
	NowShowing findByCinemaId(Long id);
}
