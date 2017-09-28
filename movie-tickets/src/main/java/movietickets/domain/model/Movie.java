package movietickets.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_MOVIE")
public class Movie {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@org.hibernate.validator.constraints.NotEmpty
	private String movieTitle;
	private Integer year;
	private String director;
	private Integer duration;
	private int sales = 0;
	private String rating;
	private String genre;
	private String castmembers;

	public Movie(String movieTitle, Integer year, String director, Integer duration, String rating,
			String genre, String castmembers) {
		super();
		this.movieTitle = movieTitle;
		this.year = year;
		this.director = director;
		this.duration = duration;
		this.rating = rating;
		this.genre = genre;
		this.castmembers = castmembers;
	}

	public Long getId() {
		return id;
	}
	
	public String getMovieTitle() {
		return movieTitle;
	}

	public Integer getYear() {
		return year;
	}

	public String getDirector() {
		return director;
	}

	public Integer getDuration() {
		return duration;
	}

	public void UpdateSales(int ticketsSold) {
		sales = sales + ticketsSold;
	}

	public String getRating() {
		return rating;
	}
	
	public String getCastMembers() {
		return castmembers;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return movieTitle + "(" + year + ")" + " directed by " + director + " starring " + castmembers;
		
	}
	
	public Movie() {
		// required by persistence layer
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((movieTitle == null) ? 0 : movieTitle.hashCode());
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
		Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (movieTitle == null) {
			if (other.movieTitle != null)
				return false;
		} else if (!movieTitle.equals(other.movieTitle))
			return false;
		return true;
	}
}
