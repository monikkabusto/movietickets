package movietickets.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import movietickets.application.BookingApplicationService;
import movietickets.domain.model.Cinema;
import movietickets.domain.model.Member;
import movietickets.domain.model.NowShowing;
import movietickets.domain.model.Seats;
import movietickets.domain.model.Transaction;

@Controller
@RequestMapping("/")
public class MoviesController {

	public static final String PATH = "movies";

	private BookingApplicationService bookingApplicationService;

	@Autowired
	public MoviesController(BookingApplicationService bookingApplicationService) {
		this.bookingApplicationService = bookingApplicationService;
	}

	@RequestMapping(method = GET)
	public String nowShowing(Model model) {
		model.addAttribute("movies", bookingApplicationService.findAllMovies());
		model.addAttribute("screenings", bookingApplicationService.findAllScreenings());
		return PATH + "/list";
	}

	@RequestMapping(value = "book", method = GET)
	public String bookTickets(Model model) {
		model.addAttribute("movies", bookingApplicationService.findAllMovies());
		return PATH + "/book";
	}

	@RequestMapping(value = "showScreening", method = RequestMethod.GET)
	public String showMovieScreening(@RequestParam("id") long id, Model model) {
		model.addAttribute("movieid", id);
		model.addAttribute("movieTitle", bookingApplicationService.findMovieById(id).getMovieTitle());
		model.addAttribute("screenings", bookingApplicationService.findMovieScreenings(id));
		return PATH + "/screening";
	}

	@RequestMapping(value = "cinemaSeats", method = RequestMethod.GET)
	public String displayAccountSummary(@RequestParam("screeningSched") long screeningId, Model model) {
		NowShowing nowShowing = bookingApplicationService.findScreening(screeningId);
		long cinemaId = nowShowing.getCinemaId();
		Cinema cinema = bookingApplicationService.findCinemaById(cinemaId);
		cinema = bookingApplicationService.setAlphaSeats(cinema);
		List<Seats> cinemaLayout = bookingApplicationService.findAllSeats(cinema);
		List<String> bookedSeats = new ArrayList<>();
		for(Seats seat : cinemaLayout) {
			bookedSeats.add(seat.getSeatName());
		}
		model.addAttribute("transaction", new Transaction());
		model.addAttribute("bookedSeats", bookedSeats);
		model.addAttribute("title", nowShowing.getMovieTitle() + " " + nowShowing.toString());
		model.addAttribute("maxY", cinema.getMaxY());
		model.addAttribute("maxX", cinema.getMaxX());
		return PATH + "/seats";
	}

	@RequestMapping(method = RequestMethod.POST, value = "printTicket")
	public String processSeats(@ModelAttribute("transaction") Transaction bookedSeats, Model model) {
		model.addAttribute("tickets", bookedSeats.getBookedSeats());
		for(String seats: bookedSeats.getBookedSeats()) {
			System.out.println(seats);
		}
		return PATH + "/printTicket";

	}

}
