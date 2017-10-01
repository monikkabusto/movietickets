package movietickets.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import movietickets.application.BookingApplicationService;
import movietickets.application.Purchase;
import movietickets.domain.model.Cinema;
import movietickets.domain.model.Movie;
import movietickets.domain.model.MoviesToSchedule;
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
	@RequestMapping(method = GET, value="sales")
	public String sales(Model model) {
		model.addAttribute("movies", bookingApplicationService.findAllMovies());
		return PATH + "/sales";
	}
	@RequestMapping(method = GET, value = "login")
	public String login(Model model) {

		return "/login";
	}

	@RequestMapping(value = "book", method = GET)
	public String bookTickets(Model model) {
		model.addAttribute("movies", bookingApplicationService.findAllMovies());
		return PATH + "/book";
	}

	@RequestMapping(value = "showScreening", method = GET)
	public String showMovieScreening(@RequestParam("id") long id, Model model) {
		
		model.addAttribute("movieid", bookingApplicationService.findMovieById(id).getTitle());
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
		for (Seats seat : cinemaLayout) {
			bookedSeats.add(seat.getSeatName());
		}
		model.addAttribute("transaction", new Transaction());
		model.addAttribute("bookedSeats", bookedSeats);
		model.addAttribute("price", nowShowing.getPrice());
		model.addAttribute("showId", nowShowing.getId());
		return PATH + "/seats";
	}

	@RequestMapping(method = POST, value = "printTicket")
	public String processSeats(@ModelAttribute("transaction") Transaction bookedSeats, Model model,
			@RequestParam("price") BigDecimal price, @RequestParam("showId") long showId) {
		String movieDetails = bookingApplicationService.findScreening(showId).getMovieTitle();
		bookedSeats.makeTransaction(price, showId, movieDetails);
		model.addAttribute("tickets", bookedSeats.getBookedSeats());
		model.addAttribute("transaction", bookedSeats.toString());
		Purchase purchase = new Purchase(bookedSeats.getTotalCost(), showId, bookedSeats.getTotalSeats());
		bookingApplicationService.bookTicket(purchase, bookedSeats.getBookedSeats());
		return PATH + "/printTicket";

	}

	@RequestMapping(method = GET, value = "schedule")
	public String scheduleMovies(@ModelAttribute("MoviesToSchedule") MoviesToSchedule moviesToSchedule, Model model) {
		model.addAttribute("existingMovies", bookingApplicationService.findAllMovieTitles());
		model.addAttribute("moviesToSchedule", moviesToSchedule);
		return PATH + "/schedule";
	}
	@RequestMapping(method = POST, value = "schedule")
	public String scheduledMovies(@ModelAttribute("MoviesToSchedule") MoviesToSchedule moviesToSchedule, Model model) {
		model.addAttribute("existingMovies", bookingApplicationService.findAllMovieTitles());
		if(moviesToSchedule.getAddMovie()==true) {
			moviesToSchedule.addMovie();
			bookingApplicationService.saveMovie(moviesToSchedule.storeNewMovie());
		}
		System.out.println(moviesToSchedule.toString());
		model.addAttribute("cmd",new MoviesToSchedule());
		return "redirect:/schedule";
	}

}
