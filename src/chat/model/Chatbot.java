package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

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
		this.currentTime = null;
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
		movieList.add(new Movie(""));
		movieList.add(new Movie("Spiderman"));
		movieList.add(new Movie("Hidden Figures"));
		movieList.add(new Movie("Spy"));
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
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "you said: " + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	private String buildChatbotResponse()
	{
		String response = "";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int)(Math.random() * topics.length);
		response += "" + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		return response;
	}
	
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
	
	public boolean htmlTagChecker(String input)
	{
		String[] htmlTag = {"<B>  </B>","<P>","<I> sdadas </i>","<A HREF=\"sdfs.html\"> </a>"};
		for(String tag:htmlTag)
		{
			if(input.equals(tag))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
			if(input.equals(username))
			{
				return true;
			}
			return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		
		if(contentCheck.contains(content))
		{
			return true;
		}
		
		return false;
	}
	
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
	
	public boolean movieTitleChecker(String title)
	{
		movieList.toString();
//		if(movieList.toString().equals(title))
//		{
//			return true;
//		}
		// need help
		for(Movie movie:movieList)
		{
			if(title.equals(movie.toString()))
			{
				return true;
			}
		}
		return false;
	}
	
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

	public boolean quitChecker(String exitString)
	{
		if(exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

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
