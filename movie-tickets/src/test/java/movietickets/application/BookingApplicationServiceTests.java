package movietickets.application;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class BookingApplicationServiceTests {

	@Autowired
	private BookingApplicationService bookingService;

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
		seatNumbers.add("A-1");
		seatNumbers.add("A-2");
		seatNumbers.add("A-3");
		seatNumbers.add("A-4");
		BigDecimal payment = new BigDecimal(200);
		// 2. Book and purchase movie ticket(s)
		Purchase newPurchase = new Purchase(payment, 10L, seatNumbers.size());
		PurchaseVerification receipt = bookingService.bookTicket(newPurchase, seatNumbers);
		System.out.println(receipt.getTransactionNumber());
		assertEquals("Sep 29 2017  07:23 PM Cine Adarna A1 A2 A3 A4", receipt.getTransactionNumber());
	}
}
