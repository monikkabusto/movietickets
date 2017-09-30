package movietickets.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_SEATS")
public class Seats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private boolean seat;
	private int posX;
	private int posY;
	private String seatName;
	private String seatView;
	
	public Seats(boolean seat, int posX, int posY) {
		this.seat = seat;
		this.posX = posX;
		this.posY = posY;
		this.seatName = posY + "-" + posX;
	}
	public Seats() {
		// required by persistence layer
	}
	public int getPosX() {
		return posX;
	}
	public String getSeatName() {
		return seatName;
	}
	public String getSeatView() {
		return seatView;
	}
	public void setSeatView() {
		seatView = getAlpha(posY) + "-" + Integer.toString(posX);
	}
	public void setSeatName() {
		seatName = posY + "-" + posX;;
	}
	public int getPosY() {
		return posY;
	}
	public void setBlock() {
		seat = true;
	}
	public boolean getBlockStatus() {
		return seat;
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
