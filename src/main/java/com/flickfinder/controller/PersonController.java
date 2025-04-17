package com.flickfinder.controller;

import java.sql.SQLException;

import com.flickfinder.dao.MovieDAO;
import com.flickfinder.dao.PersonDAO;
import com.flickfinder.model.Movie;
import com.flickfinder.model.Person;

import io.javalin.http.Context;

public class PersonController {

	// to complete the must-have requirements you need to add the following methods:
	// getAllPeople
	// getPersonById
	// you will add further methods for the more advanced tasks; however, ensure your have completed 
	// the must have requirements before you start these.  

	private final PersonDAO personDAO;
	private final MovieDAO movieDAO;

	public PersonController(PersonDAO personDAO,MovieDAO movieDAO) {
		this.personDAO = personDAO;
		this.movieDAO = movieDAO;
	}

	public void getAllPeople(Context ctx) {
		try {
			ctx.json(personDAO.getAllPeople());
		} catch (SQLException e) {
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