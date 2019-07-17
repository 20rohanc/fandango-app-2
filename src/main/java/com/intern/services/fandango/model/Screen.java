package com.intern.services.fandango.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "screens", catalog = "Fandango")
public class Screen implements Serializable {

	@Id
	@Column(name = "screen")
	private Integer id;
	@Column(name = "style")
	private String style;

	@ManyToOne
	@JoinColumn(name = "company")
	@JsonBackReference
	private Theater theater;
	
	@ManyToMany(mappedBy = "screens", cascade = CascadeType.PERSIST)
	private List<Movie> movies = new ArrayList<Movie>();
	
	public Screen() {

	}

	public Screen(Integer myid, String mystyle) {
		id = myid;
		style = mystyle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getStyle() {
		return style;
	}

	public Screen setStyle(String style) {
		this.style = style;
		return this;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	public void addMovie(Movie m)
	{
		movies.add(m);
	}
	
	public void deleteMovie(Movie m)
	{
		movies.remove((Movie) m);
	}
}