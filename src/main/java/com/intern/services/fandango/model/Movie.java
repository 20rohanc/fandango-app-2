package com.intern.services.fandango.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "movies", catalog = "Fandango")
public class Movie{

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "title")
	private String title;
	@Column(name = "revenue")
	private Integer revenue;
	@Column (name = "rating")
	private Integer rating;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Movie_Screen", joinColumns = @JoinColumn(name = "movie_id"),
	inverseJoinColumns = @JoinColumn(name = "screen_id"))
	@JsonBackReference
	List<Screen> screens = new ArrayList<Screen>();
	

	public Movie() {

	}

	public Movie(Integer myid, String mytitle, Integer myrevenue, Integer myrating) {
		id = myid;
		title = mytitle;
		revenue = myrevenue;
		rating = myrating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getRevenue() {
		return revenue;
	}

	public void setRevenue(Integer revenue) {
		this.revenue = revenue;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}
	public void addScreen(Screen s)
	{
		screens.add(s);
	}
	public void deleteScreen(Screen s)
	{
		screens.remove((Screen) s);
	}
}