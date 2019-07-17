package com.intern.services.fandango.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.intern.services.fandango.model.Screen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters", catalog = "Fandango")
public class Theater implements Serializable{

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "company")
    private String name;
    

	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	@JsonManagedReference
    private List<Screen> screens = new ArrayList<Screen>(); 

    public Theater() {
    }

    public Theater(Integer id2, String name2) {
    	id = id2;
    	name = name2;
	}
    
    public List<Screen> getScreens() {
		return screens;
	}
    
    public void alterScreen(Screen removedScreen, Screen newScreen)
    {
    	for (int i = 0; i < screens.size(); i++)
    	{
    		if (screens.get(i).equals(removedScreen))
    		{
    			screens.set(i, newScreen);
    		}
    	}
    }

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String newname) {
        name = newname;
    }

	public void addScreen(Screen s)
	{
		screens.add(s);
	}
}