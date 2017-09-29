package movietickets.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_CINEMA")
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String venue;
	private int maxX;
	private int maxY;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="cinema_id")
	private List<Seats> seats;
	public Cinema(String venue, int maxX, int maxY) {
		this.venue = venue;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	public Cinema() {
		// required by persistence layer
	}
	public List<Seats> getAllSeats() {
		return seats;
	}
	public void setLayout(int maxX, int maxY) {
		List<Seats> seats = new ArrayList<Seats>();
		for (int i = 1; i <= maxY; i++) {
			for (int j = 1; j <= maxX; j++) {
				Seats seat = new Seats(true, j, i);
				seats.add(seat);
			}
		}
		this.seats = seats;
	}
	public String getVenue() {
		return venue;
	}
	public int getMaxX() {
		return maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	
}
