package movietickets.domain.model;

import java.util.List;

public class Transaction {
	private List<String> bookedSeats;

	public List<String> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<String> bookedSeats) {
		this.bookedSeats=  bookedSeats;
	}

}
