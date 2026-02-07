package com.codewith.firstApp.controllers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

public class Movie {
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 2, message = "Title must be at least 2 characters")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Release year is required")
    @Min(value = 1888, message = "Year must be 1888 or later")
    private Integer releaseYear;

    // Default Constructor
    public Movie() {}

    // Full Constructor
    public Movie(Long id, String title, String description, Integer releaseYear) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
    }

    // --- MANUALLY ADDED GETTERS AND SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
}