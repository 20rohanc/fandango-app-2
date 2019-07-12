package com.intern.services.fandango.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.services.fandango.model.Theater;
import com.intern.services.fandango.repository.TheaterRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/rest/theaters")
public class TheaterResource {

	@Autowired
	TheaterRepository theaterRepository;

	//Gets all theaters in database
	@GetMapping("/all")
	public List<String> getAll() {
		List<Theater> theaterList = theaterRepository.findAll();
		List<String> s = new ArrayList<String>();
		for (Theater t: theaterList)
		{
			s.add(t.getName());
		}
		return s;
	}

	//Gets all theaters with a certain name
	@GetMapping("/{name}")
	public List<Theater> getTheater(@PathVariable("name") final String name) {
		return theaterRepository.findByName(name);

	}

	//Gets the theater with the entered ID
	@GetMapping("/id/{id}")
	public Theater getId(@PathVariable("id") final Integer id) {
		return theaterRepository.findOne(id);
	}

	//Edits name of a specified theater
	@PutMapping("/update/{id}")
	public Theater update(@PathVariable("id") final Integer id, @RequestBody
			final String name)
	{


		Theater Theater = getId(id);
		Theater.setName(name);
		return theaterRepository.save(Theater);
	}

	//Creates a new theater
	@PostMapping("/create")
	public Theater createTheater (@RequestBody Theater theater)
	{
		return theaterRepository.save(theater);
	}

	//Deletes a specified theater
	@DeleteMapping("/delete/{id}")
	public void deleteTheater(@PathVariable("id") final Integer id) {
		theaterRepository.delete(id);
	}
}
