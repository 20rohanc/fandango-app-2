package com.intern.services.fandango.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.services.fandango.model.Theater;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    List<Theater> findByName(String name);

}
