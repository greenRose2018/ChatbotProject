package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Chatbot object, includes chatbot topics: movies,shopping, memes, verbs, questions, and content.
 * @author brittney.morales
 * @version 11/21/17 1.2
 */
public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot()
	{
		
	}
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = LocalTime.now();
		this.questions = new String[10];
		this.username = username;
		this.content = " hi there, content , other content";
		this.intro = "hello my name is Brit";
		this.topics = new String[7];
		this.verbs = new String [4];
		this.followUps = new String[5];
		
		buildVerbs();
		buildShoppingList();
		buildMovieList();
		buildCuteAnimals();
		buildQuestions();
		//buildFollowups();
		//buildTopics();
	}
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "ambivlent about";
		verbs[3] = "am thinking about";
	}

	private void buildMovieList()
	{
		movieList.add(new Movie("Hello"));
		movieList.add(new Movie("Spiderman"));
		movieList.add(new Movie("Hidden Figures"));
		movieList.add(new Movie("Spy Next Door"));
		movieList.add(new Movie("Doctor Strange"));
		movieList.add(new Movie("Green Hornet"));
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("gross things");
		shoppingList.add("avacado");
		shoppingList.add("bananas");
		shoppingList.add("oranges");
		shoppingList.add("apples");
		shoppingList.add("paper");
		shoppingList.add("pencil");
		shoppingList.add("pumpkin chocolate chip cookies");
	}
	
	private void buildTopics()
	{
		
	}
	
	private void buildFollowups()
	{
		
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("floofer");
		cuteAnimalMemes.add("kittie");
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "What color do you like?";
		questions[2] = "What movies did you watch recently?";
		questions[3] = "What game did you play recently?";
		questions[4] = "What type of animals do you like?";
		questions[5] = "What is your horoscope?";
		questions[6] = "What type of icecream do you like?";
		questions[7] = "Do you play sport? If, so what sport do you play?";
		questions[8] = "Are you a good person or a bad person? If, so how?";
		questions[9] = "What type of car do you want?";
	}
	
	/**
	 * This method does calls buildChabotResponse, which randomly pulls a verb,topic,movieList,
	 * or movietitle and returns a response. 
	 * Takes the user input and combines with a generated response and returns it.
	 * @param input The user's supplied text.
	 * @return The combined user input and chatbot response 
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse +=  currentTime.getHour() + ":" + currentTime.getMinute() + " ";
		chatbotResponse += "\n" + "you said: " + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * Builds a random response using the chatbot's sentence part arrays.
	 * @return The random response of the chatbot.
	 */
	private String buildChatbotResponse()
	{
		String response = "";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int)(Math.random() * topics.length);
		response += "" + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * movieList.size());
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		
		int followup = (int) (Math.random() * 5);
		
		switch(followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
			break;
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		return response;
	}
	
	/**
	 * Checks the response length of the user input
	 * @param input user's response
	 * @return true/false if response is larger than 2
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null)
		{
			if (input != null && input.length() > 2)
			{
				validLength = true;
			}
		}
		
		return validLength;
	}
	
	/**
	 * checks for an htmlTag, by just using arrows and not worrying about what's in-between.
	 * @param input The user's response
	 * @return True if user's response is a htmlTag
	 */
	public boolean htmlTagChecker(String input)
	{
		Boolean answer = false;
		if(input == null || !input.contains("<"))
		{
			return answer;
		}
		
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">", firstOpen);
		
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = "";
		
		if(input.contains("<>") || input.indexOf("< >") > -1)
		{
			answer = false;
		}
		
		if (input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br>"))
		{
			answer = true;
		}
		
		else if (firstClose  > firstOpen)
		{
			//Others
			tagText = input.substring(firstOpen + 1,  firstClose).trim().toLowerCase();
			secondOpen = input.toLowerCase().indexOf("</" + tagText, firstClose);
			secondClose = input.toLowerCase().indexOf(firstClose + 1);
			
			if(secondClose < secondOpen)
			{
				answer = true;
			}
			else
			{
				answer = false;
			}
		}
		
		return answer;
		
		/*
		String[] htmlTag = {"<B>  </B>","<P>","<I> sdadas </i>","<A HREF=\"sdfs.html\"> </a>"};
		for(String tag:htmlTag)
		{
			if(input.equals(tag))
			{
				answer = true;
				return answer;
			}
		}*/
		
		
	}
	
	/**
	 * Checks username of user
	 * @param input
	 * @return
	 */
	public boolean userNameChecker(String input)
	{
		if(lengthChecker(input) == true)
		{
			this.username = "@codyhenrichse";
			if(input.equals(username))
			{
				return true;
			}
		}
			return false;
	}
	/**
	 * Checks if there is any content for the user input
	 * @param contentCheck
	 * @return
	 */
	public boolean contentChecker(String contentCheck)
	{
		
		if(contentCheck.contains(content))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Passes only appropriate memes and stops the chat bot from passing any inappropriate memes
	 * @param input
	 * @return
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		for(String meme:cuteAnimalMemes)
		{
			if(input.equals(meme))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if everything needed is inside the shopping list
	 * @param shoppingItem
	 * @return
	 */
	public boolean shoppingListChecker(String shoppingItem)
	{
		
		for(String item:shoppingList)
		{
			if(shoppingItem.equals(item))
			{
				return true;
			}
		}
		
//		int num = 0;
//		while(num < 4)
//		{
//			if (shoppingList.contains("protein"))
//			{
//				num+=1;
//			}
//			if(shoppingList.contains("slug bait"))
//			{
//				num+=1;
//			}
//			if(shoppingList.contains("veggies"))
//			{
//				num+=1;
//			}
//			if(shoppingList.contains("snacks"))
//			{
//				num+=1;
//			}
//			
//			return true;
//		}
		
		return false;
		
	}
	
	/**
	 * check if all required movies are inside the movieTitle list
	 * @param title
	 * @return
	 */
	public boolean movieTitleChecker(String title)
	{
		// needs work
		for(Movie movie:movieList)
		{
			if(movie.getTitle().length() > 0 && title.contains(movie.getTitle()))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks the movies for genres
	 * @param genre
	 * @return
	 */
	public boolean movieGenreChecker(String genre)
	{
		String[] movieGenre = {"Documentary", "Thriller"};
		for(String type:movieGenre)
		{
			if (genre.equals(type))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * checks for the user response of "quit", to take the action of exiting the program
	 * @param exitString
	 * @return
	 */
	public boolean quitChecker(String exitString)
	{
		if(lengthChecker(exitString) == true)
		{
			if(exitString.equalsIgnoreCase("quit"))
			{
				return true;
			}
		}		
		return false;
	}
	
	
	/**
	 * checks for random words and symbols from the user response.
	 * @param sample
	 * @return
	 */
	public boolean keyboardMashChecker(String sample)
	{
		String[] keyboardMash = {"sdf","SDF","dfg","cvb",",./","kjh","DFG","CVB","KJH"};
		for(String mash:keyboardMash)
		{
			if(sample.equals(mash))
			{
				return true;
			}
		}
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;//changed
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;//changed
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;//changed
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}

	public String toString()
	{
		String description = "1";
		return description;
	}
}
