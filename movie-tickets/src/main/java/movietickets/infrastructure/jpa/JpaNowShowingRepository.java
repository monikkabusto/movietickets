package movietickets.infrastructure.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import common.infrastructure.persistence.jpa.JpaGenericRepository;
import movietickets.domain.model.Cinema;
import movietickets.domain.model.Movie;
import movietickets.domain.model.NowShowing;
import movietickets.domain.model.NowShowingRepository;
@Repository
@Transactional
public class JpaNowShowingRepository 
	extends JpaGenericRepository<NowShowing, Long> 
	implements NowShowingRepository  {

	@Override
	public NowShowing findById(Long id) {
		TypedQuery<NowShowing> query = getEntityManager().createQuery("SELECT n FROM NowShowing n WHERE n.id = :id", NowShowing.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	@Override
	public List<NowShowing> findByCinemaId(Cinema cinema) {
		TypedQuery<NowShowing> query = getEntityManager().createQuery("SELECT n FROM NowShowing n WHERE cinema = :id", NowShowing.class);
		query.setParameter("id", cinema);
		return query.getResultList();
	}
	@Override
	public List<NowShowing> findByMovieId(Movie movie) {
		TypedQuery<NowShowing> query = getEntityManager().createQuery("SELECT n FROM NowShowing n WHERE movie = :id", NowShowing.class);
		query.setParameter("id", movie);
		return query.getResultList();
	}

	@Override
	public List<NowShowing> findAll() {
		TypedQuery<NowShowing> query = getEntityManager().createQuery("SELECT n FROM NowShowing n", NowShowing.class);
		return query.getResultList();
	}
	
	@Override
	protected Class<NowShowing> getEntityClass() {
		return NowShowing.class;
	}
}
