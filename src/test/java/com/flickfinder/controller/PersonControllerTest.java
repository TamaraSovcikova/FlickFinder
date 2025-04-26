package com.flickfinder.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.flickfinder.dao.MovieDAO;
import com.flickfinder.dao.PersonDAO;
import com.flickfinder.model.Movie;

import io.javalin.http.Context;

class PersonControllerTest {

	private Context ctx;
	private PersonDAO personDAO;
	private MovieDAO movieDAO;
	private PersonController personController;

	@BeforeEach
	void setUp() {
		personDAO = mock(PersonDAO.class);
		movieDAO = mock(MovieDAO.class);
		ctx = mock(Context.class);
		personController = new PersonController(personDAO, movieDAO);
	}

	@Test
	void testGetAllPeople() {
		personController.getAllPeople(ctx);
		try {
			verify(personDAO).getAllPeople(50);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testThrows500ExceptionWhenGetAllPeopleDatabaseError() throws SQLException {
		when(personDAO.getAllPeople(50)).thenThrow(new SQLException());
		personController.getAllPeople(ctx);
		verify(ctx).status(500);
	}

	@Test
	void testGetPersonById() {
		when(ctx.pathParam("id")).thenReturn("1");
		personController.getPersonById(ctx);
		try {
			verify(personDAO).getPersonById(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testThrows500ExceptionWhenGetPersonByIdDatabaseError() throws SQLException {
		when(ctx.pathParam("id")).thenReturn("1");
		when(personDAO.getPersonById(1)).thenThrow(new SQLException());
		personController.getPersonById(ctx);
		verify(ctx).status(500);
	}

	@Test
	void testThrows404ExceptionWhenNoPersonFound() throws SQLException {
		when(ctx.pathParam("id")).thenReturn("1");
		when(personDAO.getPersonById(1)).thenReturn(null);
		personController.getPersonById(ctx);
		verify(ctx).status(404);
	}

	@Test
	void testGetMoviesStarringPerson() {
		when(ctx.pathParam("id")).thenReturn("1");
		personController.getMoviesStarringPerson(ctx);
		try {
			verify(movieDAO).getMoviesStarringPerson(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
