package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;
import chat.model.CTECTwitter;
import chat.controller.IOController;

/**
 * Calling methods to build window and to start interaction with chatbot.
 * @author brittney.morales
 * @version  11/21/17 1.2
 */
public class ChatbotController
{
	private PopupDisplay display;
	private Chatbot chatbot;
	private ChatFrame appFrame;
	private CTECTwitter myTwitter;
	
	/**
	 * initialize data members
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Brittney Morales");
		myTwitter = new CTECTwitter(this);
		//View initialized after model
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	/**
	 * calls pop up to welcome the user
	 */
	public void start()
	{
//		display.displayText("Welcome to Chatbot");
//		
//		
//	//all the code below will no longer be needed	
//		String response = display.collectResponse("What do you want to talk about?");
//		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response));
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
		String results = IOController.loadFromFile(this,  "commonWords.txt");
		IOController.saveToFile(this, results, "readTet");
	}
	
	/**
	 * 
	 * @param input looks for the word "quit" to close the program/window
	 * @return
	 */
	public String interactWithChatbot(String input)
	{
		String response = "What do you want to talk about?";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		response += "\n" + chatbot.processConversation(input);
		
		return response;
	}
	
	/**
	 * checks the response of the user to talk about that specific content
	 * @param text
	 * @return
	 */
	public String useCheckers(String text)
	{
		String response = "";
		if(chatbot.contentChecker(text))
		{
			response+= "This text matches the special content\n";
		}
		if (chatbot.cuteAnimalMemeChecker(text))
		{
			response += "";
		}
		//continue will all checkers except length and quit checker
		
		return response;
	}
	
	/**
	 * exits the window and quits the program
	 */
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
	/**
	 * @deprecated Switched from the pop up display to window display to interact with chatbot.
	 * @param chat
	 * @return
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = ""; //Assigns a valid value to a variable that will be returned for the method.
		
		chatbotSays += chatbot.processConversation(chat); //gets response back from processConversation method in Chatbot 
		
		return chatbotSays;
	}
	
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	public PopupDisplay getDisplay()
	{
		return display;
	}
	
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
	
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
	
	public String search(String text)
	{
		return myTwitter.getMostCommonWord(text);
	}
	
	public String searchTopic(String text)
	{
		return myTwitter.analyzeTwitter(text);
	}
}
