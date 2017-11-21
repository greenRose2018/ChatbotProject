package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Subclass of the ChatbotController, the function is to display a popup message.
 * @author brittney.morales
 * @version 11/21/17 1.2
 */
public class PopupDisplay
{
	private ImageIcon icon;
	private String windowTitle;
	
	/**
	 * gives an icon to the popup message and title of the window
	 */
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/bubble.jpg"));
		windowTitle = "Chatbot says";
	}
	
	/**
	 * initializes the popup
	 * @param message
	 */
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	/**
	 * A method to collect the response from the user
	 * @param question
	 * @return
	 */
	public String collectResponse(String question)
	{
		String answer ="";
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null,"");
		return answer;
	}

}
