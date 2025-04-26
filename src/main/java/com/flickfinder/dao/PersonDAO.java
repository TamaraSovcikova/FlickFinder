package com.flickfinder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flickfinder.model.Movie;
import com.flickfinder.model.Person;
import com.flickfinder.util.Database;

public class PersonDAO {

	private final Connection connection;

	public PersonDAO() {
		Database database = Database.getInstance();
		connection = database.getConnection();
	}

	public List<Person> getAllPeople(int limit) throws SQLException {
		List<Person> people = new ArrayList<>();

		String statement = "select * from people LIMIT ?";
		PreparedStatement ps = connection.prepareStatement(statement);
		ps.setInt(1, limit);	

		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			people.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("birth")));
		}

		return people;
	}

	public Person getPersonById(int id) throws SQLException {

		String statement = "select * from people where id = ?";
		PreparedStatement ps = connection.prepareStatement(statement);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("birth"));
		}
		
		// return null if the id does not return a movie.
		return null;

	}
	
	public List<Person> getPeopleByMovieId(int movieId) throws SQLException {
		List<Person> people = new ArrayList<>();
		
		String query = """
		    SELECT people.id, people.name, people.birth 
		    FROM stars 
		    JOIN people ON stars.person_id = people.id 
		    WHERE stars.movie_id = ?
		""";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, movieId);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			people.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("birth")));
		}

		return people;
	}
}
