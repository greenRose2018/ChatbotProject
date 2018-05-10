package chat.model;

import chat.controller.ChatbotController;

import chat.controller.IOController;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.stream.Collectors;

public class CTECTwitter
{
	private ChatbotController appController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweets;
	private List<String> tweetedWords;
	private long totalWordCount;
	private HashMap<String, Integer> wordsAndCount;
	
	public CTECTwitter(ChatbotController appController)
	{
		this.appController = appController;
		this.chatbotTwitter = TwitterFactory.getSingleton();
		this.searchedTweets = new ArrayList<Status>();
		this.tweetedWords = new ArrayList<String>();
		this.wordsAndCount = new HashMap<String, Integer>();
		this.totalWordCount = 0;
	}
	
	public void sendTweet(String textToTweet)
	{
		
		try
		{
			chatbotTwitter.updateStatus(textToTweet + "@ChatbotCTEC");
		}
		catch(TwitterException tweetError)
		{
			appController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			appController.handleErrors(otherError);
		}
	}
	
	private void collectTweets(String username)
	{
		searchedTweets.clear();
		tweetedWords.clear();
		Paging statusPage = new Paging(1,100);
		int page = 1;
		long lastID = Long.MAX_VALUE;
		
		while(page <= 10)
		{
			statusPage.setPage(page);
			try
			{
				ResponseList<Status> listedTweets = chatbotTwitter.getUserTimeline(username, statusPage);
				for(Status current : listedTweets)
				{
					if(current.getId() < lastID)
					{
						searchedTweets.add(current);
						lastID = current.getId();
					}
				}
			}
			catch(TwitterException searchTweetError)
			{
				appController.handleErrors(searchTweetError);
			}
			page++;
		}
	}
	
	public String getMostCommonWord(String username)
	{
//		analyzeTwitter(username);
		String mostCommon = "";
		collectTweets(username);
		turnStatusesToWords();
		totalWordCount = tweetedWords.size();
		String [] boring = createIgnoreWordArray();
		trimTheBoringWords(boring);
		removeBlanks();
		generateWordCount();
		
		
		ArrayList<Map.Entry<String, Integer>> sorted = sortHashMap();
		
		String mostCommonWord = sorted.get(0).getKey();
		int maxWord = 0;
		
		maxWord = sorted.get(0).getValue();
		
		mostCommon = "The most common Word in "  + username + "'s " + searchedTweets.size() + " tweets is " 
					+ mostCommonWord + ", and it was \nused " + maxWord + " times.\nThis is "
					+ (DecimalFormat.getPercentInstance().format(((double) maxWord)/totalWordCount)) +
					" of total words: " + totalWordCount + " and is " + 
					(DecimalFormat.getPercentInstance().format(((double) maxWord)/wordsAndCount.size())) +
					" of the unique words: " + wordsAndCount.size();
		
		mostCommon += "\n\n" + sortedWords();
				
		return mostCommon;
		
	}
	
	private String sortedWords()
	{
		String allWords = "";
		String [] words = new  String [wordsAndCount.size()];
		ArrayList<String> wordsList = new ArrayList<String>(wordsAndCount.keySet());
		
		for(int index = 0; index < wordsList.size(); index++)
		{
			words[index] = wordsList.get(index);
		}
		
		for( int index = 0; index < words.length - 1; index++)
		{
			int maxIndex = index;
			
			for( int inner = index + 1; inner < words.length; inner++)
			{
				if(words[inner].compareTo(words[maxIndex]) > 0)
				{
					maxIndex = inner;
				}
			}
			
			String tempMax = words[maxIndex];
			words[maxIndex] = words[index];
			words[index] = tempMax;
		}
		
		for(String word: words)
		{
			allWords += word + ", \n";
		}
		
		return allWords;
	}
	
	private ArrayList<Map.Entry<String, Integer>> sortHashMap()
	{
		ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String,Integer>>(wordsAndCount.entrySet());
		entries.sort((entry1,entry2) -> entry2.getValue().compareTo(entry1.getValue()));
		
		return entries;
	}
	
	public String analyzeTwitter(String topic)
	{
		String results = "";
		if (topic.length() < 1) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            Query query = new Query(topic);
            query.setGeoCode(new GeoLocation(40.760779, -111.891047), .5, Query.MILES);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    results += "@" + tweet.getUser().getScreenName() + " - " + tweet.getText() + "\n";
                }
            } while ((query = result.nextQuery()) != null);
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
        return results;
	}
	public String analyzeTwitterForPop(String topic)
	{
		String results  = "";
		searchedTweets.clear();
		Query twitterQuery = new Query(topic);
		int resultMax = 750;
		long lastId = Long.MAX_VALUE;
		twitterQuery.setResultType(Query.POPULAR);
		ArrayList<Status> matchingTweets = new ArrayList<Status>();
		
		while(searchedTweets.size() < resultMax)
		{
			try
			{
				QueryResult resultingTweets = chatbotTwitter.search(twitterQuery);
			}
			catch(TwitterException error)
			{
				appController.handleErrors(error);
			}
			
			twitterQuery.setMaxId(lastId -1);
		}
		
		results += "Talk about the search results";
		results += "Find a tweet that will pass on of the checkers in chatbot";
		
		int randomTweet = (int) (Math.random() * matchingTweets.size());
		results += matchingTweets.get(randomTweet);
		
		return results;
	}
	
	
	private void trimTheBoringWords(String [] boringWords)
	{
		for (int index = tweetedWords.size() - 1; index >= 0; index--)
		{
			for(int boringIndex = 0; boringIndex < boringWords.length; boringIndex++)
			{
				if(tweetedWords.get(index).equals(boringWords[boringIndex]))
				{
					tweetedWords.remove(index);
					boringIndex = boringWords.length;
				}
			}
		}
	}
	
	private void turnStatusesToWords()
	{
		for(Status currentStatus : searchedTweets)
		{
			String tweetText = currentStatus.getText();
			tweetText = tweetText.replace("\n", " ");
			String [] tweetWords = tweetText.split(" ");
			for(int index = 0; index < tweetWords.length; index++)
			{
				tweetedWords.add(removePunctuation(tweetWords[index]).trim());
			}
		}
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"() {}^[]<>-";
		
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
			
		}
		return  scrubbedString;
	}
	
	private String [] createIgnoreWordArray()
	{
		String [] boringWords;
		String fileText = IOController.loadFromFile(appController,  "commonWords.txt");
		int wordCount = 0;
		
		Scanner wordScanner = new Scanner(fileText);
		
		while(wordScanner.hasNextLine())
		{
			wordScanner.nextLine();
			wordCount++;
		}
		
		boringWords = new String [wordCount];
		wordScanner.close();
		
		//Alternative file loading method.
		// Uses the inputStream class
		//Notice the lack of try/catch
		
		wordScanner = new Scanner(this.getClass().getResourceAsStream("data/commonWords.txt"));
		for(int index = 0; index < boringWords.length; index++)
		{
			boringWords[index] = wordScanner.nextLine();
		}
		
		wordScanner.close();
		return boringWords;
	}
	
	private void removeBlanks()
	{
		for ( int index = tweetedWords.size() - 1; index >= 0; index--)
		{
			if(tweetedWords.get(index).trim().length() == 0)
			{
				tweetedWords.remove(index);
			}
		}
	}
	
	private void generateWordCount()
	{
		for( String word: tweetedWords)
		{
			if(!wordsAndCount.containsKey(word.toLowerCase()))
			{
				wordsAndCount.put(word.toLowerCase(), 1);
			}
			else
			{
				wordsAndCount.replace(word.toLowerCase(), wordsAndCount.get(word.toLowerCase()) + 1);
			}
		}
	}
}
