package movietickets.application;

import static org.junit.Assert.*;

import java.math.BigDecimal;
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

@Rollback(false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BookingApplicationServiceTests {

	@Autowired
	private BookingApplicationService bookingService;
	
	NowShowing nowShowing;
	Movie movie;
	Cinema cinema;
	
	@Autowired
	private NowShowingRepository nowShowingRepository;
	@Autowired
	private CinemaRepository cinemaRepository;

	@Before
	public void setUp() throws Exception {
		cinema = new Cinema("Cinema Adarna", 4, 10);
		List<Seats> seats = new ArrayList<Seats>();
		for (int i = 1; i <= cinema.getMaxY(); i++) {
			for (int j = 1; j <= cinema.getMaxX(); j++) {
				Seats seat = new Seats(true, j, i);
				seats.add(seat);
			}
		}
		cinema.setLayout(seats);
		cinemaRepository.save(cinema);
		Cinema savedCinema = bookingService.findCinemaById(1L);
		Movie movie = bookingService.findMovieByTitle("Wonder Woman");
		BigDecimal money = new BigDecimal(250);
		NowShowing screening = new NowShowing(movie, savedCinema, money);
		screening.setSchedule(2017, 10, 10, 13, 30);
		nowShowingRepository.save(screening);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testForPurchase() {
		//List<String> seats = new ArrayList<String>();
		//Purchase purchase = new Purchase(240, today(), 
	}

	@Test
	public void testBookTickets() {
		
	}
	private static Date today() {
		Calendar today = Calendar.getInstance(TimeZone.getDefault());
		today.set(Calendar.HOUR_OF_DAY, 0);
		return today.getTime();
	}
}
