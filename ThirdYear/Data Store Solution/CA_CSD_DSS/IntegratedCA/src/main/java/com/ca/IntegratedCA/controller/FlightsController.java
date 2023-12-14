package com.ca.IntegratedCA.controller;
/* INTEGRATED CA - DATA STORAGE SOLUTIONS / COMMERCIAL SOLUTIONS DESIGN
 * Xiaohui Weng - 2020387  
 * Leisly Pino 2020303 
 * Yuri Ribeiro 2020347
 * 
 * Code reference: https://www.bezkoder.com/spring-boot-thymeleaf-example/
 * Code reference: https://tests4geeks.com/blog/spring-data-boot-mongodb-example/
 * 
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ca.IntegratedCA.model.Flights;
import com.ca.IntegratedCA.model.User;
import com.ca.IntegratedCA.repository.FlightsRepository;

import jakarta.servlet.http.HttpSession;

@Controller

public class FlightsController {

	// LOGIN - MontoTemplate used for authentication
	@Autowired
	private MongoTemplate mongoTemplate;

	// Add a new User to the model for authentication
	@GetMapping({ "/login" })
	public String loginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	// find the User in the database. If the user exists redirect to index page. Else, return to login page
	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute User user, Model model, HttpSession session) {
		Query query = new Query(
				Criteria.where("username").is(user.getUsername()).and("password").is(user.getPassword()));
		User authenticatedUser = mongoTemplate.findOne(query, User.class);
		if (authenticatedUser != null) {
			session.setAttribute("user", authenticatedUser);
			return "redirect:/index";
		} else {
			model.addAttribute("loginError", "Invalid username or password");
			return "login";
		}
	}

	// FLIGHT DATASET - Flights Repository 
	@Autowired
	private FlightsRepository repository;

	public FlightsController(FlightsRepository repository) {

		this.repository = repository;
	}

	/* Controller method for displaying the index page.
	 * Get all flights from the dataset and add to a flight list
	 * Display only 10 flights per page at the time*/
	
	@GetMapping({ "/index", "/" })
	public String home(Model model, @RequestParam(defaultValue = "0") int page) {
		int pageSize = 10; // The number of items per page

		Pageable pageable = PageRequest.of(page, pageSize);

		Page<Flights> flights = repository.findAll(pageable);

		model.addAttribute("flights", flights.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", flights.getTotalPages());

		return "index";
	}

	/*Controller method that display the form for Add a new Flight data in the database */
	@GetMapping("/index/newFlight")
	public String formFlight(Model model) {
		Flights flights = new Flights();
		model.addAttribute("flights", flights);
		return "newFlight";
	}

	/*Save the new flights data to the database 
	 * Returns an message confirming the flight has been created/added*/
	@PostMapping("/index")
	public String saveFlights(@ModelAttribute("flights") Flights flights, RedirectAttributes redirectAttributes) {
		repository.save(flights);

		redirectAttributes.addFlashAttribute("AddedMessage", "Flight " + flights.get_id() + " has been added.");
		return "redirect:/index";
	}
	/*Controller method for Updating the data using an ID as reference*/
	@GetMapping("/index/update/{_id}")
	public String updateAllFlightById(@PathVariable String _id, Model model) {
		model.addAttribute("flights", repository.findById(_id).orElse(null));
		return "update";
	}
  
	/*Retrieves the existing flight data from the database then update all the properties
	 * Returns an message confirming the flight has been updated*/
	@PostMapping("/index/{_id}")
	public String updateFlight(@PathVariable String _id, @ModelAttribute("flights") Flights flight, Model model,
			RedirectAttributes redirectAttributes) {
		Flights existingFlight = repository.findById(_id).get();
		existingFlight.setYear(flight.getYear());
		existingFlight.setMonth(flight.getMonth());
		existingFlight.setDayofMonth(flight.getDayofMonth());
		existingFlight.setDepTime(flight.getDepTime());
		existingFlight.setCRSDepTime(flight.getCRSDepTime());
		existingFlight.setArrTime(flight.getArrTime());
		existingFlight.setCRSArrTime(flight.getCRSArrTime());
		existingFlight.setOrigin(flight.getOrigin());
		existingFlight.setDest(flight.getDest());
		repository.save(existingFlight);

		redirectAttributes.addFlashAttribute("updateMessage", "Flight " + _id + " has been updated.");

		return "redirect:/index";
	}

	/*Gets the request and creates a new Flights object to the model returing the search method*/
	@GetMapping("/index/search")
	public String searchFlight(Model model) {
		Flights flights = new Flights();
		model.addAttribute("flights", flights);
		return "search";

	}
	/*Controller method for Searching the data using an ID as reference
	 * return an message if flight with the given ID was not found*/
	@GetMapping("/search")
	public String search(Model model, @RequestParam String _id, RedirectAttributes redirectAttributes) {
		Flights flight = repository.findById(_id).orElse(null);
		if (flight == null) {
			redirectAttributes.addFlashAttribute("searchMessage", "Flight " + _id + " cannot be found!");
			return "redirect:/index";
		}
		Flights flights = new Flights();
		model.addAttribute("flight", flight);
		model.addAttribute("flights", flights);
		return "searchResults";
	}

	/* Method for deleting the flight data by ID*/
	@GetMapping("/index/{_id}")
	public String deleteFlightById(@PathVariable("_id") String _id, RedirectAttributes redirectAttributes) {
		repository.deleteById(_id);

		redirectAttributes.addFlashAttribute("deleteMessage", "Flight " + _id + " has been deleted.");
		return "redirect:/index";
	}

}
