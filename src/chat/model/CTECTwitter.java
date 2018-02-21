package chat.model;

import chat.controller.ChatbotController;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.Status;

public class CTECTwitter
{
	private ChatbotController appController;
	private Twitter chatbotTwitter;
	
	public CTECTwitter(ChatbotController appController)
	{
		this.appController = appController;
		this.chatbotTwitter = TwitterFactory.getSingleton();
		
	}
	
	public void sendTweet(String textToTweet)
	{
		
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
