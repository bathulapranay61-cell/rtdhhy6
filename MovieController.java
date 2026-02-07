package com.codewith.firstApp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final List<Movie> movieStore = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    // POST: Add a new movie
    @PostMapping
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {
        movie.setId(counter.getAndIncrement());
        movieStore.add(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    // GET: Get a single movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return movieStore.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .map(movie -> new ResponseEntity<>(movie, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}