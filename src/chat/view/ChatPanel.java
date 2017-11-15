package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		//initialize GUI data members
		chatButton = new JButton("chat");
		baseLayout = new SpringLayout();
		inputField = new JTextField(25);
		chatArea = new JTextArea(10, 25);
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(baseLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		
	}
	
	private void setupLayout()
	{
		//TextArea
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		//TextField
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, 0, SpringLayout.SOUTH, chatButton);
		//Btn SpringLayout
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -34, SpringLayout.SOUTH, this);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
	}
	
}
