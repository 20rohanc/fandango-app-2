package com.intern.services.fandango.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.services.fandango.model.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByTitle(String name);

}