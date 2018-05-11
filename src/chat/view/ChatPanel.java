package chat.view;

import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The JPanel subclass for the chatbot project.
 * @author brittney.morales
 * @version 11-21-17 1.2
 */
public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private JButton chatButton;
	private JButton searchButton;
	private JButton searchTopicBtn;
	private JButton saveBtn;
	private JButton loadBtn;
	private JButton tweetBtn;
	private JButton checkerButton;
	private JButton exitButton;
	private JButton randomButton;
	private JLabel infoLabel;
	private SpringLayout baseLayout;
	private JTextField inputField;
	private JTextArea chatArea;
	private JScrollPane chatScrollPane;
	

	/**
	 * Initializes GUI data members, also calling Panel, layout, and listeners methods
	 * @param baseController
	 */
	public ChatPanel(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;

		// initialize GUI data members
		chatButton = new JButton("Chat", new ImageIcon(getClass().getResource("/chat/view/images/chat.png")));
		searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chat/view/images/search.png")));
		searchTopicBtn = new JButton("Search Topic");
		saveBtn = new JButton("Save", new ImageIcon(getClass().getResource("/chat/view/images/save.png")));
		loadBtn = new JButton("Load", new ImageIcon(getClass().getResource("/chat/view/images/load.png")));
		tweetBtn = new JButton("Tweet", new ImageIcon(getClass().getResource("/chat/view/images/bird.png")));
		exitButton = new JButton("Exit");
		randomButton = new JButton("Random, Click me");
		infoLabel = new JLabel("Type here to chat with Chatbot");
		checkerButton = new JButton("check");
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, searchTopicBtn, 6, SpringLayout.SOUTH, searchButton);
		baseLayout.putConstraint(SpringLayout.WEST, searchTopicBtn, 0, SpringLayout.WEST, randomButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, searchTopicBtn, 66, SpringLayout.SOUTH, searchButton);
		baseLayout.putConstraint(SpringLayout.EAST, searchTopicBtn, 104, SpringLayout.WEST, randomButton);
		chatScrollPane = new JScrollPane();
		inputField = new JTextField(25);
		chatArea = new JTextArea(10, 25);

		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	/**
	 * sets up the window with color,layout, and adds components to the ChatFrame
	 */
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(baseLayout);
		//buttons
		this.add(chatButton);
		this.add(exitButton);
		this.add(randomButton);
		this.add(checkerButton);
		this.add(searchTopicBtn);
		this.add(infoLabel);
		this.add(saveBtn);
		this.add(loadBtn);
		this.add(searchButton);
		this.add(tweetBtn);
		
		//text area
		this.add(inputField);
		this.add(chatScrollPane);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);

	}

	
	/**
	 * the constraint on the components on the Frame
	 */
	private void setupLayout()
	{
		
		baseLayout.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -10, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetBtn, 6, SpringLayout.SOUTH, chatScrollPane);
		baseLayout.putConstraint(SpringLayout.NORTH, searchButton, 6, SpringLayout.SOUTH, chatScrollPane);
		baseLayout.putConstraint(SpringLayout.SOUTH, tweetBtn, -161, SpringLayout.NORTH, infoLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, searchButton, -161, SpringLayout.NORTH, infoLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, infoLabel, 39, SpringLayout.NORTH, saveBtn);
		baseLayout.putConstraint(SpringLayout.EAST, infoLabel, -330, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, randomButton, 24, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, randomButton, 0, SpringLayout.NORTH, checkerButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, checkerButton, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, checkerButton, -13, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -13, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		baseLayout.putConstraint(SpringLayout.WEST, loadBtn, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, loadBtn, -6, SpringLayout.NORTH, saveBtn);
		baseLayout.putConstraint(SpringLayout.WEST, tweetBtn, 6, SpringLayout.EAST, searchButton);
		baseLayout.putConstraint(SpringLayout.EAST, tweetBtn, -299, SpringLayout.EAST, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, searchButton, 0, SpringLayout.WEST, randomButton);
		baseLayout.putConstraint(SpringLayout.EAST, searchButton, -409, SpringLayout.EAST, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, exitButton, 0, SpringLayout.NORTH, randomButton);
		baseLayout.putConstraint(SpringLayout.WEST, exitButton, 35, SpringLayout.EAST, randomButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, saveBtn, -6, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, saveBtn, 0, SpringLayout.EAST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -2, SpringLayout.SOUTH, this);
		
		
	}

	/**
	 * Listening for the components to take action once they are clicked
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = baseController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		
		saveBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		loadBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String usernameToSearch = inputField.getText();
				
				chatArea.setText(baseController.search(usernameToSearch));
			}
		});
		searchTopicBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String usernameToSearch = inputField.getText();
				
				chatArea.setText(baseController.searchTopic(usernameToSearch));
			}
		});
		tweetBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.tweet(inputField.getText());
			}
		});

		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = baseController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});

		exitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeRandomColor();
			}

		});
		
		randomButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeRandomColor();
			}
		});
		
	}

	/**
	 * A method to change the Background color of the Frame
	 */
	private void changeRandomColor()
	{
		int red = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);

		this.setBackground(new Color(red, green, blue));
	}
}
