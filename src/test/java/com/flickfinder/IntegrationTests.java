package com.flickfinder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.flickfinder.util.Database;
import com.flickfinder.util.Seeder;

import io.javalin.Javalin;

/**
 * These are our integration tests.
 * We are testing the application as a whole, including the database.
 */
class IntegrationTests {

	/**
	 * The Javalin app.*
	 */
	Javalin app;

	/**
	 * The seeder object.
	 */
	Seeder seeder;

	/**
	 * The port number. Try and use a different port number from your main
	 * application.
	 */
	int port = 6000;

	/**
	 * The base URL for our test application.
	 */
	String baseURL = "http://localhost:" + port;

	/**
	 * Bootstraps the application before each test.
	 */
	@BeforeEach
	void setUp() {
		var url = "jdbc:sqlite::memory:";
		seeder = new Seeder(url);
		Database.getInstance(seeder.getConnection());
		app = AppConfig.startServer(port);
	}

	/**
	 * Test that the application retrieves a list of all movies.
	 * Notice how we are checking the actual content of the list.
	 * At this higher level, we are not concerned with the implementation details.
	 */

	@Test
	void retrieves_a_list_of_all_movies() {
		given().when().get(baseURL + "/movies").then().assertThat().statusCode(200). // Assuming a successful
												// response returns HTTP
												// 200
				body("id", hasItems(1, 2, 3, 4, 5))
				.body("title", hasItems("The Shawshank Redemption", "The Godfather",
						"The Godfather: Part II", "The Dark Knight", "12 Angry Men"))
				.body("year", hasItems(1994, 1972, 1974, 2008, 1957));
	}

	@Test
	void retrieves_a_single_movie_by_id() {

		given().when().get(baseURL + "/movies/1").then().assertThat().statusCode(200). // Assuming a successful
												// response returns HTTP
												// 200
				body("id", equalTo(1))
				.body("title", equalTo("The Shawshank Redemption"))
				.body("year", equalTo(1994));
	}
	
	/**
	 * Test that the application retrieves a list of all people.
	 */
	@Test
	void retrieves_a_list_of_all_people() {
		given().when().get(baseURL + "/people").then().assertThat().statusCode(200)
				.body("id", hasItems(1, 2, 3, 4, 5))
				.body("name", hasItems("Tim Robbins", "Morgan Freeman", "Christopher Nolan", "Al Pacino", "Henry Fonda"));
	}

	/**
	 * Test that the application retrieves a single person by their ID.
	 */
	@Test
	void retrieves_a_single_person_by_id() {
		given().when().get(baseURL + "/people/1").then().assertThat().statusCode(200)
				.body("id", equalTo(1))
				.body("name", equalTo("Tim Robbins"));
	}
	
	@Test
	void retrieves_stars_of_movie_by_id() {
	    given()
	        .when()
	        .get(baseURL + "/movies/1/stars")
	        .then()
	        .assertThat()	
	        .statusCode(200)
	        .body("[0].name", equalTo("Tim Robbins"))
	        .body("[1].name", equalTo("Morgan Freeman"));
	}
	
	@Test
	void retrieves_movies_of_person_by_id() {
	    given()
	        .when()
	        .get(baseURL + "/people/1/movies")
	        .then()
	        .assertThat()
	        .statusCode(200)
	        .body("size()", equalTo(1))
	        .body("[0].title", equalTo("The Shawshank Redemption"));
	}
	
	@Test
	void retrieves_movies_with_default_limit() {
	    given()
	        .when()
	        .get(baseURL + "/movies")
	        .then()
	        .assertThat()
	        .statusCode(200)
	        .body("size()", equalTo(5));
	}

	@Test
	void retrieves_movies_with_custom_limit() {
	    given()
	        .when()
	        .get(baseURL + "/movies?limit=2")
	        .then()
	        .assertThat()	 
	        .statusCode(200)
	        .body("size()", equalTo(2));
	}

	@Test
	void retrieves_people_with_default_limit() {
	    given()
	        .when()
	        .get(baseURL + "/people")
	        .then()
	        .assertThat()
	        .statusCode(200)
	        .body("size()", equalTo(5));
	}

	@Test
	void retrieves_people_with_custom_limit() {
	    given()
	        .when()
	        .get(baseURL + "/people?limit=2")
	        .then()
	        .assertThat()
	        .statusCode(200)
	        .body("size()", equalTo(2));
	}
	
	@Test
	void retrieves_ratings_for_year_with_default_settings() {
	    given()
	        .when()
	        .get(baseURL + "/movies/ratings/1994")
	        .then()
	        .assertThat()
	        .statusCode(200)
	        .body("[0].rating", equalTo(9.0f))
	        .body("[0].votes", equalTo(2200000));
	}

	@Test
	void retrieves_ratings_for_year_with_custom_limit() {
	    given()
	        .when()
	        .get(baseURL + "/movies/ratings/1994?limit=1")
	        .then()
	        .assertThat()
	        .statusCode(200)
	        .body("size()", equalTo(1));
	}

	@Test
	void retrieves_ratings_for_year_with_custom_votes_threshold() {
	    given()
	        .when()
	        .get(baseURL + "/movies/ratings/1994?votes=500")
	        .then()
	        .assertThat()
	        .statusCode(200)
	        .body("[0].votes", equalTo(2200000));
	}
	
	/**
	 * Tears down the application after each test.
	 * We want to make sure that each test runs in isolation.
	 */
	@AfterEach
	void tearDown() {
		seeder.closeConnection();
		app.stop();
	}

}
