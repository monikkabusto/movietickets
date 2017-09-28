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
	
	public Seats(boolean seat, int posX, int posY) {
		this.seat = seat;
		this.posX = posX;
		this.posY = posY;
	}
	public int getPosX() {
		return posX;
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
}
