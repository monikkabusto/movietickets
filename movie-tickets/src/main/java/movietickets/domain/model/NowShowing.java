package movietickets.domain.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import common.LocalDateTimeAttributeConverter;

@Entity
@Table(name = "T_NOWSHOWING")
public class NowShowing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Movie movie;
	@ManyToOne(fetch = FetchType.LAZY)
	private Cinema cinema;
	@Transient
	private LocalDateTime schedule;
	private Timestamp dateAndTime;
	private BigDecimal price;
	@Transient
	private long movieId;
	@Transient
	private long cinemaId;
	public static final int AFTER_CREDITS_AND_CLEANUP = 15;

	public NowShowing(Movie movie, Cinema cinema) {
		this.movie = movie;
		this.cinema = cinema;
		this.movieId = movie.getId();
		this.cinemaId = cinema.getId();
	}

	public Long getId() {
		return id;
	}

	public int getDuration() {
		return movie.getDuration();
	}

	public String getMovieTitle() {
		return movie.getMovieTitle();
	}

	public Long getMovieId() {
		return movie.getId();
	}

	public Long getCinemaId() {
		return cinema.getId();
	}

	public Cinema getCinema() {
		return cinema;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public LocalDateTime getSchedule() {
		return schedule;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
		return dateAndTime.toLocalDateTime().format(formatter).toString() + " " + cinema.getVenue();
	}

	public String getInfo() {
		return movie.getMovieTitle() + " " + dateAndTime.toString() + " " + cinema.getVenue();
	}

	public void setSchedule(LocalDateTime dateTime) {
		LocalDate showingDate = dateTime.toLocalDate();
		LocalTime time = dateTime.toLocalTime();
		schedule = LocalDateTime.of(showingDate, time);
		LocalDateTimeAttributeConverter converter = new LocalDateTimeAttributeConverter();
		dateAndTime = converter.convertToDatabaseColumn(schedule);
	}

	public NowShowing() {
		// required by persistence layer
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NowShowing other = (NowShowing) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
