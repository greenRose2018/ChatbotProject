package chat.controller;

import chat.model.Chatbot;
import chat.model.Movie;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;
import chat.view.ChatPanel;

public class ChatbotController
{
	private PopupDisplay display;
	private Chatbot chatbot;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Brittney Morales");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response));
		{
			response = popupChat(response);
			response = display.collectResponse(response);
		}
	}
	
	public String interactWithChatbot(String input)
	{
		return null;
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public Chatbot getChatbot()
	{
		return null;
	}
	
}
