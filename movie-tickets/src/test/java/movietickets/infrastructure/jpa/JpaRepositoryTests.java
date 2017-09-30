package movietickets.infrastructure.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import movietickets.domain.model.Cinema;
import movietickets.domain.model.CinemaRepository;
import movietickets.domain.model.Movie;
import movietickets.domain.model.MovieRepository;
import movietickets.domain.model.NowShowing;
import movietickets.domain.model.NowShowingRepository;
import movietickets.domain.model.Seats;
import movietickets.domain.model.Ticket;

@Rollback(false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JpaRepositoryTests {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private NowShowingRepository nowShowingRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	
	@Test
	public void populateCinema() throws Exception {
		Cinema cinema = new Cinema("3-D IMAX2", 5, 5);
		List<Seats> seats = new ArrayList<Seats>();
		for (int i = 1; i <= cinema.getMaxY(); i++) {
			for (int j = 1; j <= cinema.getMaxX(); j++) {
				Seats seat = new Seats(true, j, i);
				seats.add(seat);
			}
		}
		cinema.setLayout(seats);
		cinemaRepository.save(cinema);
		Cinema savedCinema = cinemaRepository.findByName("3-D IMAX2");
		assertNotNull(savedCinema);
		assertEquals(savedCinema.getVenue(), "3-D IMAX2");
	}

	@Test
	public void populateNowShowing() throws Exception {
		Cinema cinema = new Cinema("3-D Cinema", 5, 4);
		cinemaRepository.save(cinema);
		Movie movie = movieRepository.findById((long) 1);
		NowShowing screening = new NowShowing(movie, cinema);
		LocalDateTime sched = LocalDateTime.of(2017, 10, 10, 13, 30);
		screening.setSchedule(sched);
		nowShowingRepository.save(screening);
		NowShowing actualScreening = nowShowingRepository.findById(1L);
		assertNotNull(actualScreening);
		long movieId = actualScreening.getMovieId();
		assertEquals(movieId, 1L);
	}
	@Test
	public void findNowShowingByCinemaId() throws Exception {
		Cinema savedCinema = cinemaRepository.findById(2L);
		List<NowShowing> screenings = nowShowingRepository.findByCinemaId(savedCinema);
		for (NowShowing screening : screenings) {
			System.out.println(screening.toString());
		}
	}

	@Test
	public void testFindMovieById() throws Exception {
		Movie test = new Movie("Rick and Morty", 2007, "John", 150, "PG-13", "SciFi.Comedy", "Rick and Morty");
		movieRepository.save(test);
		Movie testSaved = movieRepository.findById((long) 4);
		System.out.println(testSaved.getMovieTitle());
		Movie movie1 = movieRepository.findById((long) 1);
		Movie movie2 = movieRepository.findById((long) 2);
		assertNotNull(movie1);
		assertEquals("Wonder Woman", movie1.getMovieTitle());
		assertEquals("Kingsman: The Golden Circle", movie2.getMovieTitle());
	}
	@Test
	public void testFindMovieByTitle() throws Exception {
		Movie movie = movieRepository.findByTitle("Kingsman: The Golden Circle");
		assertNotNull(movie);
		assertEquals("Kingsman: The Golden Circle", movie.getMovieTitle());
	}

	@Test
	public void testFindAllMovies() throws Exception {
		List<Movie> movies = movieRepository.findAll();
		List<Movie> testMovies = new ArrayList<>();
		assertNotNull(movies);
		for (Movie movie : movies) {
			testMovies.add(movie);
		}
		assertEquals("Wonder Woman", testMovies.get(0).getMovieTitle());
		assertEquals("Kingsman The Golden Circle", testMovies.get(1).getMovieTitle());
		assertEquals("Transformers The Last Knight", testMovies.get(2).getMovieTitle());
	}
}
