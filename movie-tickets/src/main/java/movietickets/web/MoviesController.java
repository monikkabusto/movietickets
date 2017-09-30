package movietickets.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import movietickets.application.BookingApplicationService;
import movietickets.domain.model.NowShowing;

@Controller
@RequestMapping("/")
public class MoviesController {

	public static final String PATH = "movies";

	private BookingApplicationService bookingApplicationService;

	@Autowired
	public MoviesController(BookingApplicationService bookingApplicationService) {
		this.bookingApplicationService = bookingApplicationService;
	}
	
	@RequestMapping(value = "movies", method=GET)
	public String nowShowing(Model model) {
		model.addAttribute("movies", bookingApplicationService.findAllMovies());
		model.addAttribute("screenings", bookingApplicationService.findAllScreenings());
		return PATH + "/list";
	}
	@RequestMapping(value = "book", method=GET)
	public String bookTickets(Model model) {
		return PATH + "/book";
	}
	
}
