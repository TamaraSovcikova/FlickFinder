package com.flickfinder.model;


public class MovieRating extends Movie {

	private int rating;
	private int votes;

	public MovieRating(int id, String title, int year, int rating, int votes) {
		super(id, title, year);
		this.rating = rating;
		this.votes = votes;	}

	public double getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}	

	@Override
	public String toString() {
		return super.toString() + ", rating=" + rating + ", votes=" + votes + "]";
	}
}


