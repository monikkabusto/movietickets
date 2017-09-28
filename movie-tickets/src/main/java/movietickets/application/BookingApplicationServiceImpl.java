package movietickets.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import movietickets.domain.model.Cinema;
import movietickets.domain.model.CinemaRepository;
import movietickets.domain.model.Movie;
import movietickets.domain.model.MovieRepository;
import movietickets.domain.model.NowShowing;
import movietickets.domain.model.NowShowingRepository;
import movietickets.domain.model.Seats;
import movietickets.domain.model.Ticket;

@Component
@Transactional
public class BookingApplicationServiceImpl implements BookingApplicationService {

	private MovieRepository movieRepository;
	private CinemaRepository cinemaRepository;
	private NowShowingRepository nowShowingRepository;

	@Autowired
	public BookingApplicationServiceImpl(MovieRepository movieRepository, CinemaRepository cinemaRepository,
			NowShowingRepository nowShowingRepository) {
		super();
		this.movieRepository = movieRepository;
		this.cinemaRepository = cinemaRepository;
		this.nowShowingRepository = nowShowingRepository;
	}

	@Override
	public PurchaseVerification bookTicket(Purchase purchase, List<String> seatNumbers) {
		NowShowing movie = nowShowingRepository.findById(purchase.getMovie());
		StringBuilder transaction = new StringBuilder();
		transaction.append(movie.toString());

		for(String ticket : seatNumbers){
			int posY = Integer.parseInt(ticket.split(":")[0]);
			int posX = Integer.parseInt(ticket.split(":")[1]);
			Ticket newTicket = new Ticket(movie, posX, posY);
			transaction.append(newTicket.getSeatLabel());
		}
		String transactionID = transaction.toString();
		return new PurchaseVerification(transactionID);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Movie> findAllMovies() {
		List<Movie> allMovies = movieRepository.findAll();
		return allMovies;
	}

	@Transactional(readOnly = true)
	@Override
	public List<NowShowing> findAllScreenings() {
		List<NowShowing> allScreenings = nowShowingRepository.findAll();
		return allScreenings;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cinema> findAllCinemas() {
		List<Cinema> allCinemas = cinemaRepository.findAll();
		return allCinemas;
	}

	@Override
	public List<Seats> findAllSeats(Cinema cinema) {
		List<Seats> seatLayout = cinema.getAllSeats();
		return seatLayout;
	}

	@Override
	public void updateSeats(Ticket ticket) {
		// TODO Auto-generated method stub

	}
	@Transactional(readOnly = true)
	@Override
	public Movie findMovieByTitle(String movieTitle) {
		Movie movie = movieRepository.findByTitle(movieTitle);
		return movie;
	}
	@Transactional(readOnly = true)
	@Override
	public Cinema findCinemaById(Long id) {
		Cinema cinema = cinemaRepository.findById(id);
		return cinema;
	}

}
