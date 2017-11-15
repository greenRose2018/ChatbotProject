package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private JButton chatButton;
	private SpringLayout baseLayout;
	private JTextField inputField;
	private JTextArea chatArea;
	
	public ChatPanel(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;
	}
	
	private void setupPanel()
	{
	}
	private void setupLayout()
	{
	}
	
	private void setupListeners()
	{
	}
}
