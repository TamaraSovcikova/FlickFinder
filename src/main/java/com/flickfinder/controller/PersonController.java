package com.flickfinder.controller;

import java.sql.SQLException;

import com.flickfinder.dao.MovieDAO;
import com.flickfinder.dao.PersonDAO;
import com.flickfinder.model.Movie;
import com.flickfinder.model.Person;

import io.javalin.http.Context;

public class PersonController {

	private final PersonDAO personDAO;
	private final MovieDAO movieDAO;

	public PersonController(PersonDAO personDAO,MovieDAO movieDAO) {
		this.personDAO = personDAO;
		this.movieDAO = movieDAO;
	}

	public void getAllPeople(Context ctx) {
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
			ctx.json(personDAO.getAllPeople(limit));
		}
		catch (NumberFormatException e) {
			ctx.status(400).result("Invalid limit format");		
		}
		catch (SQLException e) {
			ctx.status(500);
			ctx.result("Database error");
			e.printStackTrace();
		}
	}

	public void getPersonById(Context ctx) {

		int id = Integer.parseInt(ctx.pathParam("id"));
		try {
			Person person = personDAO.getPersonById(id);
			if (person  == null) {
				ctx.status(404);
				ctx.result("Person not found");
				return;
			}
			ctx.json(personDAO.getPersonById(id));
		} catch (SQLException e) {
			ctx.status(500);
			ctx.result("Database error");
			e.printStackTrace();
		}
}
	
	public void getMoviesStarringPerson(Context ctx) {
		int personId = Integer.parseInt(ctx.pathParam("id"));
		try {			
			ctx.json(movieDAO.getMoviesStarringPerson(personId));
		} catch (SQLException e) {
			ctx.status(500).result("Database error");
			e.printStackTrace();
		}
	}
}