package movietickets.infrastructure.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import common.infrastructure.persistence.jpa.JpaGenericRepository;
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


}
