package movietickets.application;

import java.util.List;

import movietickets.domain.model.Cinema;
import movietickets.domain.model.Movie;
import movietickets.domain.model.NowShowing;
import movietickets.domain.model.Seats;
import movietickets.domain.model.Ticket;

public interface BookingApplicationService {
	
	PurchaseVerification bookTicket(Purchase purchase, List<String> seatNumbers);
	Movie findMovieByTitle(String movieTitle);
	Cinema findCinemaById(Long id);
	List<Movie> findAllMovies();
	List<NowShowing> findAllScreenings();
	List<Cinema> findAllCinemas();
	List<Seats> findAllSeats(Cinema cinema);
	void updateSeats(Ticket ticket);
}
