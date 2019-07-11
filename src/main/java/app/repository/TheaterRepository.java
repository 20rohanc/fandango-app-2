package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Theater;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    List<Theater> findByName(String name);

}
