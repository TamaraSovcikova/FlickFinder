package com.flickfinder.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for the MovieRating Model.
 */
public class MovieRatingTest {

    private MovieRating movieRating;

    @BeforeEach
    public void setUp() {
        movieRating = new MovieRating(1, "Inception", 2010, 9, 1000);
    }

    @Test
    public void testMovieRatingCreated() {
        assertEquals(1, movieRating.getId());
        assertEquals("Inception", movieRating.getTitle());
        assertEquals(2010, movieRating.getYear());
        assertEquals(9, movieRating.getRating());
        assertEquals(1000, movieRating.getVotes());
    }

    @Test
    public void testMovieRatingSetters() {
        movieRating.setId(2);
        movieRating.setTitle("Interstellar");
        movieRating.setYear(2014);
        movieRating.setRating(8);
        movieRating.setVotes(2000);

        assertEquals(2, movieRating.getId());
        assertEquals("Interstellar", movieRating.getTitle());
        assertEquals(2014, movieRating.getYear());
        assertEquals(8, movieRating.getRating());
        assertEquals(2000, movieRating.getVotes());
    }
}
