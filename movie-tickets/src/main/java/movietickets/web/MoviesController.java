package movietickets.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import movietickets.application.BookingApplicationService;
import movietickets.domain.model.Movie;
import movietickets.domain.model.NowShowing;
import movietickets.domain.model.Ticket;

@Controller
@RequestMapping("/")
public class MoviesController {

	public static final String PATH = "movies";

	private BookingApplicationService bookingApplicationService;

	@Autowired
	public MoviesController(BookingApplicationService bookingApplicationService) {
		this.bookingApplicationService = bookingApplicationService;
	}

	@RequestMapping(value = "movies", method = GET)
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

	// @RequestMapping(value = "screening", method = RequestMethod.GET)
	// public String nowShowingSchedule(Model model) {
	// return PATH + "/screening";
	// }
	@RequestMapping(value = "showScreening", method = RequestMethod.GET)
	public String showMovieScreening(@RequestParam("id") long id, Model model) {
		model.addAttribute("movieTitle", bookingApplicationService.findMovieById(id).getMovieTitle() + " (" + bookingApplicationService.findMovieById(id).getYear() + ")");
		model.addAttribute("screenings", bookingApplicationService.findMovieScreenings(id));
		return PATH + "/screening";
	}

}
