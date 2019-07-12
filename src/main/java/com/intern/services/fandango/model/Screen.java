package com.intern.services.fandango.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	public void setStyle(String style) {
		this.style = style;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

}
