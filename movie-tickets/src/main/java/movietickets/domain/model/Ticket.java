package movietickets.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_TICKET")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private NowShowing nowShowing;
	private int posX;
	private int posY;
	private String seatLabel;
	private String movieDetails;
	
	public Ticket(NowShowing nowShowing, int posX, int posY, String movieDetails) {
		this.nowShowing = nowShowing;
		this.posX = posX;
		this.posY = posY;
		this.seatLabel = getAlpha(posY) + posX;
		this.movieDetails = movieDetails;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	
	public String getSeatLabel() {
		return seatLabel;
	}
	public void setMovieDetails(String movieDetails) {
		this.movieDetails = movieDetails;
	}
	public String getMovieDetails() {
		return movieDetails;
	}
	
	public NowShowing getNowShowing() {
		return nowShowing;
	}

	public String getTimeStamp() {
		String dateBought = LocalTime.now().toString() + LocalDate.now().toString();
		return dateBought;
	}

	public String getAlpha(int row) {
		String alpha = null;
		int letterNumber = row % 26;
		char letter = (char) (letterNumber + 'A' - 1);
		StringBuilder sb = new StringBuilder();
		sb.append(letter);
		alpha = sb.toString();
		int multiple = (row - letterNumber) / 26;
		for (int i = 0; i < multiple; i++) {
			sb.append(letter);
		}
		alpha = sb.toString();
		return alpha;
	}

}
