package movietickets.domain.model;

import java.math.BigDecimal;
import java.util.List;

public class Transaction {
	private List<String> bookedSeats;
	private long showId;
	private BigDecimal price;
	private String movieDetails;
	private BigDecimal totalCost;
	
	public int getTotalSeats() {
		return bookedSeats.size();
		
	}
	
	public BigDecimal getTotalCost() {
		totalCost = price.multiply(new BigDecimal(bookedSeats.size()));
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public void setMovieDetails(String movieDetails) {
		this.movieDetails = movieDetails;
	}

	public String getMovieDetails() {
		return movieDetails;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public List<String> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<String> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public long getNowShowing() {
		return showId;
	}

	public void setShowId(long showId) {
		this.showId = showId;
	}

	@Override
	public String toString() {
		StringBuilder transaction = new StringBuilder();
		transaction.append(movieDetails + " ");
		for (String ticket : bookedSeats) {
			transaction.append(ticket + " ");
		}
		
		BigDecimal totalAmount = getTotalCost();
		transaction.append(" Php" + totalAmount.toString());
		String transactionID = transaction.toString();
		return transactionID;

	}
	public void makeTransaction(BigDecimal price, long showId, String movieDetails) {
		this.price = price;
		this.showId = showId;
		this.movieDetails = movieDetails;
	}

}
