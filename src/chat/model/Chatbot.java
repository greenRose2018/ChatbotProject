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
		this.questions = null;
		this.username = username;
		this.content = null;
		this.intro = null;
		this.topics = new String[7];
		this.verbs = new String [4];
		this.followUps = new String[5];
		
		buildVerbs();
		buildShoppingList();
		buildMovieList();
		buildCuteAnimals();
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
		//movieList.add(new Movie("Spy"));
		movieList.add(new Movie("Doctor Strange"));
		movieList.add(new Movie("Green Hornet"));
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("slug bait");
		shoppingList.add("gross things");
		shoppingList.add("avacado");
		shoppingList.add("bananas");
		shoppingList.add("oranges");
		shoppingList.add("apples");
		shoppingList.add("paper");
		shoppingList.add("pencil");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pepe");
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("floofer");
		cuteAnimalMemes.add("kittie");
	}
	
	private void buildQuestions()
	{
		
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
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
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
}
