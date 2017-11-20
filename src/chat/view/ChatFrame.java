package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatPanel firstPanel;
	
	public ChatFrame()
	{
		ChatbotController baseController = new ChatbotController();
	}
	public ChatFrame(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;
		firstPanel = new ChatPanel(baseController);
		
		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(firstPanel);
		this.setTitle("Chatbot");
		this.setSize(600, 600);
		this.setResizable(false);
		this.setVisible(true);
	}
}
