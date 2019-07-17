package com.intern.services.fandango.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intern.services.fandango.model.Screen;
import com.intern.services.fandango.model.Theater;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    List<Screen> findByStyle(String name);

}