package movietickets.domain.model;

import java.util.List;

public class MoviesToSchedule {
	private List<String> moviesToSchedule;
	private List<String> newMovieDetails;
	private boolean addMovie;

	public void setNewMovieDetails(List<String> newMovieDetails) {
		this.newMovieDetails = newMovieDetails;
	}
	public void addMovie() {
		moviesToSchedule.add(newMovieDetails.get(0));
	}

	public List<String> getNewMovieDetails() {
		return newMovieDetails;
	}

	public void setAddMovie(boolean addMovie) {
		this.addMovie = addMovie;
	}

	public boolean getAddMovie() {
		return addMovie;
	}

	public void setMoviesToSchedule(List<String> moviesToSchedule) {
		this.moviesToSchedule = moviesToSchedule;
	}

	public List<String> getMoviesToSchedule() {
		return moviesToSchedule;
	}

	public Movie storeNewMovie() {
		String movieTitle = newMovieDetails.get(0);
		Integer year = Integer.parseInt(newMovieDetails.get(2));
		String director = newMovieDetails.get(1);
		Integer duration = Integer.parseInt(newMovieDetails.get(3));
		String rating = newMovieDetails.get(4);
		String genre = newMovieDetails.get(5);
		String castmembers = newMovieDetails.get(6);
		Movie movie = new Movie(movieTitle, year, director, duration, rating, genre, castmembers);
		return movie;
	}
	@Override
	public String toString(){
		String details = "";
		for(String detail: moviesToSchedule) {
			details = details + detail;
		}
		return details;
	}

}
