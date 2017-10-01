package movietickets.application;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import movietickets.domain.model.Cinema;
import movietickets.domain.model.CinemaRepository;
import movietickets.domain.model.Movie;
import movietickets.domain.model.MovieRepository;
import movietickets.domain.model.MoviesToSchedule;
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
	private TicketRepository ticketRepository;

	@Autowired
	public BookingApplicationServiceImpl(MovieRepository movieRepository, CinemaRepository cinemaRepository,
			NowShowingRepository nowShowingRepository, TicketRepository ticketRepository) {
		super();
		this.movieRepository = movieRepository;
		this.cinemaRepository = cinemaRepository;
		this.nowShowingRepository = nowShowingRepository;
		this.ticketRepository = ticketRepository;
	}

	@Override
	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
	}

	@Override
	public PurchaseVerification bookTicket(Purchase purchase, List<String> seatNumbers) {
		NowShowing movieScreening = nowShowingRepository.findById(purchase.getMovie());
		Movie movie = movieRepository.findById(movieScreening.getMovieId());
		movie.UpdateSales(movieScreening.getPrice().multiply(new BigDecimal(seatNumbers.size())));
		StringBuilder transaction = new StringBuilder();
		transaction.append(movieScreening.toString());
		for (String ticket : seatNumbers) {
			int posY = getNumber(ticket.split("-")[0]);
			int posX = Integer.parseInt(ticket.split("-")[1]);
			Ticket newTicket = new Ticket(movieScreening, posX, posY, movieScreening.getInfo());
			transaction.append(" " + newTicket.getSeatLabel());
			ticketRepository.save(newTicket);
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

	@Override
	public List<String> findAllMovieTitles() {
		List<Movie> allMovies = movieRepository.findAll();
		List<String> movieTitles = new ArrayList<>();
		for (Movie movie : allMovies) {
			movieTitles.add(movie.getTitle());
		}
		return movieTitles;
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
	public Cinema setAlphaSeats(Cinema cinema) {
		cinema = cinemaRepository.findById(1L);
		List<Seats> originalSeats = cinema.getAllSeats();
		for (Seats seat : originalSeats) {
			seat.setSeatView();
		}
		cinema.setLayout(originalSeats);
		cinemaRepository.update(cinema);
		return cinema;
	}

	@Override
	public List<NowShowing> findByMovieId(Movie movie) {
		List<NowShowing> screenings = nowShowingRepository.findByMovieId(movie);
		return screenings;
	}

	@Override
	public Cinema findCinemaById(Long id) {
		Cinema cinema = cinemaRepository.findById(id);
		return cinema;
	}

	@Override
	public List<Ticket> findTicketsByScreening(NowShowing nowShowing) {
		List<Ticket> tickets = ticketRepository.findByScreening(nowShowing);
		return tickets;

	}

	public int getNumber(String row) {
		char letter = row.charAt(0);
		int rowNumber;
		if (row.length() == 1) {
			rowNumber = (int) (letter - 'A' + 1);
		} else {
			letter = row.charAt(0);
			rowNumber = (int) (letter - 'A' + 1) * row.length();
		}
		return rowNumber;
	}

	@Override
	public List<String> scheduleMovies(MoviesToSchedule moviesToSchedule, long cinemaId) {
		Cinema cinema = cinemaRepository.findById(cinemaId);
		LocalDateTime date = nextWednesday();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime startDate = LocalDateTime.parse(getStringDate(date.getYear(), date.getMonthValue(), date.getDayOfMonth()), formatter);
		System.out.println(startDate.toString());
		List<String> scheduledMovies = new ArrayList<>();
		List<String> movies = moviesToSchedule.getMoviesToSchedule();
		System.out.println(moviesToSchedule);
		List<NowShowing> pendingMovies = new ArrayList<>();
		List<LocalDateTime> schedules = new ArrayList<>();
		for (int i = 0; i < movies.size(); i++) {
			String movie = movies.get(i);
			Movie pendingmovie = movieRepository.findByTitle(movie);
			NowShowing nowShowing = new NowShowing(pendingmovie, cinema);
			if(i == 0) {
				schedules.add(startDate);
				nowShowing.setSchedule(startDate);
			} else {
				LocalDateTime schedule = schedules.get(i-1).plusMinutes(pendingmovie.getDuration() + 15);
				schedules.add(schedule);
				nowShowing.setSchedule(schedule);
			}
			scheduledMovies.add(nowShowing.getInfo());
			pendingMovies.add(nowShowing);
			nowShowingRepository.save(nowShowing);
		}
		return scheduledMovies;
	}

	public LocalDateTime nextWednesday() {
		Calendar date = Calendar.getInstance();
		int diff = Calendar.WEDNESDAY - date.get(Calendar.DAY_OF_WEEK);
		if (!(diff > 0)) {
			diff += 7;
		}

		date.add(Calendar.DAY_OF_MONTH, diff);
		LocalDateTime wednesday = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		return wednesday;
	}

	public String getStringDate(int year, int month, int day) {
		StringBuilder sb = new StringBuilder();
		String dateString = "";
		sb.append(year + "-");
		if(month < 10) {
			sb.append("0" + month + "-");
		} else {
			sb.append(month + "-");
		}
		if(day < 10) {
			sb.append("0" + day  + " ");
		} else {
			sb.append(day + " ");
		}
		sb.append("10:30");
		dateString = sb.toString();
		return dateString;
	}

}
