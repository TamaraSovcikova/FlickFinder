package com.flickfinder.controller;

import java.sql.SQLException;
import java.util.List;

import com.flickfinder.dao.MovieDAO;
import com.flickfinder.dao.PersonDAO;
import com.flickfinder.model.Movie;
import com.flickfinder.model.MovieRating;
import com.flickfinder.model.Person;

import io.javalin.http.Context;

/**
 * The controller for the movie endpoints.
 * 
 * The controller acts as an intermediary between the HTTP routes and the DAO.
 * 
 * As you can see each method in the controller class is responsible for
 * handling a specific HTTP request.
 * 
 * Methods a Javalin Context object as a parameter and uses it to send a
 * response back to the client.
 * We also handle business logic in the controller, such as validating input and
 * handling errors.
 *
 * Notice that the methods don't return anything. Instead, they use the Javalin
 * Context object to send a response back to the client.
 */

public class MovieController {

	/**
	 * The movie data access object.
	 */

	private final MovieDAO movieDAO;
	private final PersonDAO personDAO;

	/**
	 * Constructs a MovieController object and initializes the movieDAO.
	 */
	public MovieController(MovieDAO movieDAO, PersonDAO personDAO) {
		this.movieDAO = movieDAO;
		this.personDAO = personDAO;
	}

	/**
	 * Returns a list of all movies in the database.
	 * 
	 * @param ctx the Javalin context
	 */
	public void getAllMovies(Context ctx) {
		int limit = 50;
		try {
			String limitParam = ctx.queryParam("limit");
			if (limitParam != null) {
			limit = Integer.parseInt(limitParam);
				if (limit <= 0) {
					ctx.status(400).result("Limit can't be a negative number");
					return;
				}
			}
			ctx.json(movieDAO.getAllMovies(limit));
		}
		catch (NumberFormatException e) {
			ctx.status(400).result("Invalid limit format");		
		} catch (SQLException e) {
			ctx.status(500);
			ctx.result("Database error");
			e.printStackTrace();
		}
	}

	/**
	 * Returns the movie with the specified id.
	 * 
	 * @param ctx the Javalin context
	 */
	public void getMovieById(Context ctx) {
	    int id = Integer.parseInt(ctx.pathParam("id"));
	    try {
	        Movie movie = movieDAO.getMovieById(id);
	        if (movie == null) {
	            ctx.status(404);
	            ctx.result("Movie not found");
	            return;
	        }
	        ctx.json(movie);
	    } catch (SQLException e) {
	        ctx.status(500);
	        ctx.result("Database error");
	        e.printStackTrace();
	    }
	}
	
	public void getPeopleByMovieId(Context ctx) {
		int movieId = Integer.parseInt(ctx.pathParam("id"));
		try {			
			ctx.json(personDAO.getPeopleByMovieId(movieId));
		} catch (SQLException e) {
			ctx.status(500).result("Database error");
			e.printStackTrace();
		}
	}
	
	public void getRatingsByYear(Context ctx) {
		int limit = 50;		
		int votes = 1000;
		int year = Integer.parseInt(ctx.pathParam("year"));		

		try {
			String limitParam = ctx.queryParam("limit");
			if (limitParam != null) {
				limit = Integer.parseInt(limitParam);
				if (limit <= 0) {
					ctx.status(400).result("Limit can't be a negative number");
					return;
				}
			}
			String votesParam = ctx.queryParam("votes");
			if (votesParam != null) {
				votes = Integer.parseInt(votesParam);
				if (votes <= 0) {
					ctx.status(400).result("Votes have to be a positive number");
					return;
				}
			}

			List<MovieRating> movies = movieDAO.getRatingsByYear(year, limit, votes);			
//			if (movies.isEmpty()) {
//			    ctx.status(404).result("No movies found for year " + year);
//			    return;
//			}			
			ctx.json(movies);
		}
		catch (NumberFormatException e) {
			ctx.status(400).result("Invalid limit format");		
		} catch (SQLException e) {
			ctx.status(500).result("Database error");
			e.printStackTrace();
		}
	}
}
