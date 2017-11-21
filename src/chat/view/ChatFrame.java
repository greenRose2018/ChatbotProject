package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

/**
 * 
 * @author bmor9741
 * @version 11-21-17 1.0
 */
public class ChatFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatPanel firstPanel;
	
	public ChatFrame(ChatbotController baseController)
	{
		super();
		this.setBaseController(baseController);
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
	public ChatbotController getBaseController()
	{
		return baseController;
	}
	public void setBaseController(ChatbotController baseController)
	{
		this.baseController = baseController;
	}
}
