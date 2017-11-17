package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

public class ChatbotController
{
	private PopupDisplay display;
	private Chatbot chatbot;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Brittney Morales");
		//View initialized after model
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		display.displayText("Welcome to Chatbot");
		
		
	//all the code below will no longer be needed	
		//String response = display.collectResponse("What do you want to talk about?");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response));
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	}
	
	public String interactWithChatbot(String input)
	{
		String response = "What do you want to talk about?";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		response += chatbot.processConversation(input);
		
		return response;
	}
	
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
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
}
