package com.intern.services.fandango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.services.fandango.model.Movie;
import com.intern.services.fandango.model.Screen;
import com.intern.services.fandango.model.Theater;
import com.intern.services.fandango.repository.MovieRepository;
import com.intern.services.fandango.repository.ScreenRepository;
import com.intern.services.fandango.repository.TheaterRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class Controller {

	@Autowired
	TheaterRepository theaterRepository;

	@Autowired
	ScreenRepository screenRepository;

	@Autowired
	MovieRepository movieRepository;

	// Gets all theaters in database
	@GetMapping("/theaters/all")
	public List<String> getAll() {
		List<Theater> theaterList = theaterRepository.findAll();
		List<String> s = new ArrayList<String>();
		for (Theater t : theaterList) {
			s.add(t.getName());
		}
		return s;
	}
	
	@GetMapping("/theaters/screens/all")
	public List<Screen> getAllScreens(){
		return screenRepository.findAll();
	}

	// Gets all theaters with a certain name
	@GetMapping("/theaters/{name}")
	public List<Theater> getTheater(@PathVariable("name") final String name) {
		return theaterRepository.findByName(name);

	}

	// Gets the theater with the entered ID
	@GetMapping("/theaters/id/{id}")
	public Theater getId(@PathVariable("id") final Integer id) {
		return theaterRepository.findOne(id);
	}

	@GetMapping("/theaters/id/{id}/screen/{screen}")
	public Screen getScreen(@PathVariable("id") final Integer id, @PathVariable("screen") final Integer screen) {
		return screenRepository.findOne(screen);
	}

	// Edits name of a specified theater
	@PutMapping("/theaters/update/{id}")
	public Theater update(@PathVariable("id") final Integer id, @RequestBody final String name) {

		Theater Theater = getId(id);
		Theater.setName(name);
		return theaterRepository.save(Theater);
	}

	@PutMapping("/theaters/update/{id}/{screen}")
	public Screen update(@PathVariable("id") final Integer id, @PathVariable("screen") final Integer screen,
			@RequestBody final String name) {
		Screen Screen = getScreen(id, screen);
		Screen.setStyle(name);
		return screenRepository.save(Screen);
	}

	// Creates a new theater
	@PostMapping("/theaters/create")
	public Theater createTheater(@RequestBody Theater theater) {
		return theaterRepository.save(theater);
	}

	@PostMapping("/theaters/create/{id}")
	public Screen createScreen(@PathVariable("id") final Integer id, @RequestBody Screen screen) {
		screen.setTheater(getId(id));
		List<Movie> movieList = screen.getMovies();
		for (int i = 0; i < movieList.size(); i++)
		{
			Movie m = movieList.get(i);
			m.addScreen(screen);
		}
		
		screen.setMovies(movieList);
		return screenRepository.save(screen);
	}

	// Deletes a specified theater
	@DeleteMapping("/theaters/delete/{id}")
	public void deleteTheater(@PathVariable("id") final Integer id) {
		theaterRepository.delete(id);
	}

	@DeleteMapping("/theaters/delete/{id}/{screen}")
	public void deleteScreen(@PathVariable("id") final Integer id, @PathVariable("screen") final Integer screen) {
		screenRepository.delete(screen);
	}

	// Gets all movies in database
	@GetMapping("/movies/all")
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	// Gets all movies with a certain name
	@GetMapping("/movies/{name}")
	public List<Movie> getMovie(@PathVariable("name") final String name) {
		return movieRepository.findByTitle(name);

	}

	// Gets the movie with the entered ID
	@GetMapping("/movies/id/{id}")
	public Movie getMovieId(@PathVariable("id") final Integer id) {
		return movieRepository.findOne(id);
	}
	
	@PostMapping("/movies/create")
	public Movie createMovie(@RequestBody Movie movie) {
		List<Screen> screenList = movie.getScreens();
		for (int i = 0; i < screenList.size(); i++)
		{
			Screen s = screenList.get(i);
			s.addMovie(movie);
		}
		movie.setScreens(screenList);
		return movieRepository.save(movie);
	}
	
	@PutMapping("/broadcast/theater/{theater}/screen/{screen}/movie/{movie}")
	public void broadcast(@PathVariable("theater") final Integer theater, @PathVariable("screen") final Integer screen, @PathVariable("movie") final Integer movie)
	{
		Screen s = getScreen(theater, screen);
		Movie m = getMovieId(movie);
		s.addMovie(m);
		m.addScreen(s);
		screenRepository.save(s);
		movieRepository.save(m);
	}
	
	@PutMapping("/terminate/theater/{theater}/screen/{screen}/movie/{movie}")
	public void terminate(@PathVariable("theater") final Integer theater, @PathVariable("screen") final Integer screen, @PathVariable("movie") final Integer movie)
	{
		Screen s = getScreen(theater, screen);
		Movie m = getMovieId(movie);
		s.deleteMovie(m);
		m.deleteScreen(s);
		screenRepository.save(s);
		movieRepository.save(m);
	}
	
	@PutMapping("/movies/update-rating/{id}")
	public Movie updateMovieRating(@PathVariable("id") final Integer id, @RequestBody final int rating) {

		Movie Movie = getMovieId(id);
		Movie.setRating(rating);
		return movieRepository.save(Movie);
	}
	@PutMapping("/movies/update-revenue/{id}")
	public Movie updateMovieRevenue(@PathVariable("id") final Integer id, @RequestBody final int revenue) {

		Movie Movie = getMovieId(id);
		Movie.setRevenue(revenue);
		return movieRepository.save(Movie);
	}
	
	@DeleteMapping("/movies/delete/{id}")
	public void deleteMovie(@PathVariable("id") final Integer id) {
		movieRepository.delete(id);
	}
}
