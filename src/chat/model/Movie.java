package chat.model;

import java.time.LocalDate;

/**
 * Movie object, gives title, genre, rating, review, releaseDate, and starScore.
 * @author brittney.morales
 * @version 11/21/17 1.2
 */
public class Movie
{
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;
	
	public Movie()
	{
		
	}
	
	public Movie(String title)
	{
		
		if(title.length() < 3)
		{
			this.title = "Title: " + title;
			
		}
		else
		{
			this.title = title;
		}
		
		this.genre = "sci-fi";
		this.ratingMPAA = "G";
		this.review = "it was a good movie";
		this.length = 100;
		this.releaseDate = LocalDate.now();
		this.starScore = 6.5;
		
	}
	
	public String getTitle()
	{
		return title;
	}

	public String getGenre()
	{
		return genre;
	}

	public String getRatingMPAA()
	{
		return ratingMPAA; // changed
	}

	public String getReview()
	{
		return review;
	}

	public int getLength()
	{
		return length; //changed
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public double getStarScore()
	{
		return starScore;
	}

	public void setTitle(String title) //added this to everything below this
	{
		this.title = title;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public void setRatingMPAA(String ratingMPAA)
	{
		this.ratingMPAA = ratingMPAA;
	}

	public void setReview(String review)
	{
		this.review = review;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public void setReleaseDate(LocalDate releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public void setStarScore(double starScore)
	{
		this.starScore = starScore;
	}
	
	public String toString()
	{
		String description = "Hi";
		return description;
	}
}
