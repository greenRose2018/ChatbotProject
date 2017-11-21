package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

/**
 * The JFrame subclass for the chatbot project. 
 * @author brittney.morales
 * @version 11-21-17 1.2
 */
public class ChatFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatPanel firstPanel;
	
	/**
	 * Setups up the frame for panel
	 * @param baseController
	 */
	public ChatFrame(ChatbotController baseController)
	{
		super();
		this.setBaseController(baseController);
		firstPanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * setting the values for the Frame
	 */
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
