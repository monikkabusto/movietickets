package movietickets.application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import movietickets.domain.model.Cinema;
import movietickets.domain.model.CinemaRepository;
import movietickets.domain.model.Movie;
import movietickets.domain.model.NowShowing;
import movietickets.domain.model.NowShowingRepository;
import movietickets.domain.model.Seats;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class BookingApplicationServiceTests {

	@Autowired
	private BookingApplicationService bookingService;
	@Autowired
	private NowShowingRepository nowShowingRepository;
	@Autowired
	private CinemaRepository cinemaRepository;

	@Before
	public void setUp() throws Exception {
		Cinema cinema1 = new Cinema("Cine Adarna", 10, 15);
		Cinema cinema2 = new Cinema("Cinecon Valley", 20, 30);
		Cinema cinema3 = new Cinema("Cinematography", 19, 17);
		cinema1.setLayout(cinemaLayout(cinema1.getMaxX(), cinema1.getMaxY()));
		cinema2.setLayout(cinemaLayout(cinema2.getMaxX(), cinema2.getMaxY()));
		cinema3.setLayout(cinemaLayout(cinema3.getMaxX(), cinema3.getMaxY()));
		cinemaRepository.save(cinema1);
		cinemaRepository.save(cinema2);
		cinemaRepository.save(cinema3);
		List<Cinema> cinemas = new ArrayList<>();
		Cinema savedCinema1 = bookingService.findCinemaById(1L);
		Cinema savedCinema2 = bookingService.findCinemaById(2L);
		Cinema savedCinema3 = bookingService.findCinemaById(3L);
		cinemas.add(savedCinema1);
		cinemas.add(savedCinema2);
		cinemas.add(savedCinema3);
		List<Movie> movies = new ArrayList<>();
		Movie movie1 = bookingService.findMovieById(1L);
		Movie movie2 = bookingService.findMovieById(2L);
		Movie movie3 = bookingService.findMovieById(3L);
		Movie movie4 = bookingService.findMovieById(4L);
		Movie movie5 = bookingService.findMovieById(5L);
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		movies.add(movie5);
		List<NowShowing> screenings = new ArrayList<>();
		for (int i = 0; i < movies.size() * cinemas.size(); i++) {
			Movie movie = movies.get(i % movies.size());
			Cinema cinema = cinemas.get(i % cinemas.size());
			NowShowing screening = new NowShowing(movie, cinema);
			screenings.add(screening);
			nowShowingRepository.save(screening);
		}
		List<NowShowing> screeningCinema1 = nowShowingRepository.findByCinemaId(savedCinema1);
		List<NowShowing> screeningCinema2 = nowShowingRepository.findByCinemaId(savedCinema2);
		List<NowShowing> screeningCinema3 = nowShowingRepository.findByCinemaId(savedCinema3);
		LocalDateTime startDate = LocalDateTime.now();
		LocalDateTime startDate1 = startDate;
		LocalDateTime startDate2 = startDate;
		LocalDateTime startDate3 = startDate;
		for (int j = 0; j < screeningCinema1.size(); j++) {
			int duration = screeningCinema1.get(j).getDuration() + 20;
			if (j == 0) {
				screeningCinema1.get(j).setSchedule(startDate1);
			} else {
				LocalDateTime schedule = startDate1.plusMinutes(duration);
				screeningCinema1.get(j).setSchedule(schedule);
				startDate1 = schedule;
			}
			System.out.println(screeningCinema1.get(j).toString());
		}
		for (int j = 0; j < screeningCinema2.size(); j++) {
			int duration = screeningCinema2.get(j).getDuration() + 20;
			if (j == 0) {
				screeningCinema2.get(j).setSchedule(startDate2);
			} else {
				LocalDateTime schedule = startDate2.plusMinutes(duration);
				screeningCinema2.get(j).setSchedule(schedule);
				startDate2 = schedule;
			}
			System.out.println(screeningCinema2.get(j).toString());
		}
		for (int j = 0; j < screeningCinema3.size(); j++) {
			int duration = screeningCinema3.get(j).getDuration() + 20;
			if (j == 0) {
				screeningCinema3.get(j).setSchedule(startDate3);
			} else {
				LocalDateTime schedule = startDate3.plusMinutes(duration);
				screeningCinema3.get(j).setSchedule(schedule);
				startDate3 = schedule;
			}
			System.out.println(screeningCinema3.get(j).toString());
		}
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testForPurchase() {
		// List<String> seats = new ArrayList<String>();
		// Purchase purchase = new Purchase(240, today(),
	}

	private static List<Seats> cinemaLayout(int maxX, int maxY) {
		List<Seats> seats = new ArrayList<Seats>();
		for (int i = 1; i <= maxY; i++) {
			for (int j = 1; j <= maxX; j++) {
				Seats seat = new Seats(true, j, i);
				seats.add(seat);
			}
		}
		return seats;
	}

	private static Date today() {
		Calendar today = Calendar.getInstance(TimeZone.getDefault());
		today.set(Calendar.HOUR_OF_DAY, 0);
		return today.getTime();
	}
}
