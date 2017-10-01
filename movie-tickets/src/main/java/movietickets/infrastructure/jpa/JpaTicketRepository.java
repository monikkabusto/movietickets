package movietickets.infrastructure.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import common.infrastructure.persistence.jpa.JpaGenericRepository;
import movietickets.domain.model.NowShowing;
import movietickets.domain.model.Ticket;
import movietickets.domain.model.TicketRepository;
@Repository
@Transactional
public class JpaTicketRepository 
	extends JpaGenericRepository<Ticket, Long> 
	implements TicketRepository  {


	@Override
	protected Class<Ticket> getEntityClass() {
		return Ticket.class;
	}
	
	@Override
	public List<Ticket> findByScreening(NowShowing nowShowing) {
		TypedQuery<Ticket> query = getEntityManager().createQuery("SELECT t FROM Ticket t WHERE nowShowing = :id", Ticket.class);
		query.setParameter("id", nowShowing);
		return query.getResultList();
	}


}
