package movietickets.application;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
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
import movietickets.domain.model.Ticket;
import movietickets.domain.model.TicketRepository;

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
	@Autowired
	private TicketRepository ticketRepository;

	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testForPurchase() {
		// 1. Screening ID provided by UI input ; SeatLabels provided by UI input when
		// clicked from grid
		List<String> seatNumbers = new ArrayList<>();
		seatNumbers.add("1:1");
		seatNumbers.add("1:2");
		seatNumbers.add("1:3");
		seatNumbers.add("1:4");
		BigDecimal payment = new BigDecimal(200);
		// 2. Book and purchase movie ticket(s)
		Purchase newPurchase = new Purchase(payment, 10L, seatNumbers.size());
		PurchaseVerification receipt = bookingService.bookTicket(newPurchase, seatNumbers);
		System.out.println(receipt.getTransactionNumber());
		assertEquals("Respeto 2017-09-29 19:23:00.0 Cine Adarna A1 A2 A3 A4", receipt.getTransactionNumber());
	}

	private static Date today() {
		Calendar today = Calendar.getInstance(TimeZone.getDefault());
		today.set(Calendar.HOUR_OF_DAY, 0);
		return today.getTime();
	}
}
