package movietickets.infrastructure.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import common.infrastructure.persistence.jpa.JpaGenericRepository;
import movietickets.domain.model.Movie;
import movietickets.domain.model.MovieRepository;
@Repository
@Transactional
public class JpaMovieRepository 
	extends JpaGenericRepository<Movie, Long> 
	implements MovieRepository {

	@Override
	protected Class<Movie> getEntityClass() {
		return Movie.class;
	}

	@Override
	public Movie findById(Long Id) {
		TypedQuery<Movie> query = getEntityManager().createQuery("SELECT m FROM Movie m WHERE m.id = :id", Movie.class);
		query.setParameter("id", Id);
		return query.getSingleResult();
	}

	@Override
	public Movie findByTitle(String movieTitle) {
		TypedQuery<Movie> query = getEntityManager().createQuery("SELECT m FROM Movie m WHERE m.movieTitle = :title",
				Movie.class);
		query.setParameter("title", movieTitle);
		return query.getSingleResult();
	}

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = getEntityManager().createQuery("SELECT m FROM Movie m", Movie.class);
		return query.getResultList();
	}

}
