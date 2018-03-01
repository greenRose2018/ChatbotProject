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
import java.util.ArrayList;
import java.text.DecimalFormat;

public class CTECTwitter
{
	private ChatbotController appController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweeets;
	private List<String> weetedWords;
	
	public CTECTwitter(ChatbotController appController)
	{
		this.appController = appController;
		this.chatbotTwitter = TwitterFactory.getSingleton();
		
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
	
//	private String[] createIgnoredWordArray()
//	{
//		
//	}
//	
//	private void collectTweets(String username)
//	{
//		
//	}
//	
//	public String getMostCommonWord(String user)
//	{
//		
//	}
//	
//	private void removeEmptyText()
//	{
//		
//	}
	
}
