package movietickets.infrastructure.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import common.infrastructure.persistence.jpa.JpaGenericRepository;
import movietickets.domain.model.Cinema;
import movietickets.domain.model.CinemaRepository;
@Repository
@Transactional
public class JpaCinemaRepository 
	extends JpaGenericRepository<Cinema, Long> 
	implements CinemaRepository  {

	@Override
	public Cinema findById(Long id) {
		TypedQuery<Cinema> query = getEntityManager().createQuery("SELECT c FROM Cinema c WHERE c.id = :id", Cinema.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	@Override
	public Cinema findByName(String name) {
		TypedQuery<Cinema> query = getEntityManager().createQuery("SELECT c FROM Cinema c WHERE c.venue = :venue", Cinema.class);
		query.setParameter("venue", name);
		return query.getSingleResult();
	}


	@Override
	public List<Cinema> findAll() {
		TypedQuery<Cinema> query = getEntityManager().createQuery("SELECT c FROM Cinema c", Cinema.class);
		return query.getResultList();
	}

	@Override
	protected Class<Cinema> getEntityClass() {
		return Cinema.class;
	}

	
}
