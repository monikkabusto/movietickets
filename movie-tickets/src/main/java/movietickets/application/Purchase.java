package movietickets.application;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Purchase {
	private final BigDecimal payment;
	private Date date;
	private final long movie;
	private final int numberOfSeats;

	public Purchase(BigDecimal payment, long movie, int numberOfSeats) {
		super();
		this.payment = payment;
		date = today();
		this.movie = movie;
		this.numberOfSeats = numberOfSeats;
	}

	public Date getDate() {
		return date;
	}
	public BigDecimal getPayment() {
		return payment;
	}
	public long getMovie() {
		return movie;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	private static Date today() {
		Calendar today = Calendar.getInstance(TimeZone.getDefault());
		today.set(Calendar.HOUR_OF_DAY, 0);
		return today.getTime();
	}
}
