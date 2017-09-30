package movietickets.domain.model;

import java.util.List;

import common.domain.model.GenericRepository;

public interface TicketRepository extends GenericRepository<Ticket, Long> {

	List<Ticket> findByScreening(NowShowing nowShowing);

	
}
