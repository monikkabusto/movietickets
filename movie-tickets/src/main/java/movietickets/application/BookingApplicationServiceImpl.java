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
import movietickets.domain.model.TicketRepository;

@Component
@Transactional
public class BookingApplicationServiceImpl implements BookingApplicationService {

	private MovieRepository movieRepository;
	private CinemaRepository cinemaRepository;
	private NowShowingRepository nowShowingRepository;
	//private TicketRepository ticketRepository;

	@Autowired
	public BookingApplicationServiceImpl(MovieRepository movieRepository, CinemaRepository cinemaRepository,
			NowShowingRepository nowShowingRepository, TicketRepository ticketRepository) {
		super();
		this.movieRepository = movieRepository;
		this.cinemaRepository = cinemaRepository;
		this.nowShowingRepository = nowShowingRepository;
		//this.ticketRepository = ticketRepository;
	}

	@Override
	public PurchaseVerification bookTicket(Purchase purchase, List<String> seatNumbers) {
		NowShowing movieScreening = nowShowingRepository.findById(purchase.getMovie());
		Movie movie = movieRepository.findById(movieScreening.getMovieId());
		movie.UpdateSales(seatNumbers.size());
		StringBuilder transaction = new StringBuilder();
		transaction.append(movieScreening.toString());

		for (String ticket : seatNumbers) {
			int posY = Integer.parseInt(ticket.split(":")[0]);
			int posX = Integer.parseInt(ticket.split(":")[1]);
			Ticket newTicket = new Ticket(movieScreening, posX, posY);
			transaction.append(" " + newTicket.getSeatLabel());
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
	public List<NowShowing> findMovieScreenings(long movieId) {
		Movie movie = movieRepository.findById(movieId);
		List<NowShowing> allScreenings = nowShowingRepository.findByMovieId(movie);
		return allScreenings;
	}
	@Transactional(readOnly = true)
	@Override
	public NowShowing findScreening(long id) {
		NowShowing screening = nowShowingRepository.findById(id);
		return screening;
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

	}

	@Transactional(readOnly = true)
	@Override
	public Movie findMovieByTitle(String movieTitle) {
		Movie movie = movieRepository.findByTitle(movieTitle);
		return movie;
	}

	@Override
	public Movie findMovieById(long id) {
		Movie movie = movieRepository.findById(id);
		return movie;
	}
	@Override
	public Cinema findCinemaById(long id) {
		Cinema cinema = cinemaRepository.findById(id);
		return cinema;
	}

	@Transactional(readOnly = true)
	@Override
	public Cinema findCinemaById(Long id) {
		Cinema cinema = cinemaRepository.findById(id);
		return cinema;
	}

	@Override
	public List<NowShowing> findByMovieId(Movie movie) {
		List<NowShowing> screenings = nowShowingRepository.findByMovieId(movie);
		return screenings;
	}

}
