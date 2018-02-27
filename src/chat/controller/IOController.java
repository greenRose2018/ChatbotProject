package chat.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class IOController
{
	public static void saveToFile(ChatbotController app, String textToSave, String path)
	{
		String savePath;
		Calendar time = Calendar.getInstance();
		if (path.indexOf(".txt") == -1)
		{
			savePath = "saved text " + time.get(Calendar.HOUR_OF_DAY) + "-" + time.get(Calendar.MINUTE) + ".txt";
			System.out.println(savePath);
		}
		else
		{
			savePath = path;
		}
		
		try
		{
			File textFile = new File(savePath);
			PrintWriter fileWriter = new PrintWriter(textFile);
			Scanner textScanner = new Scanner(textToSave);
			String currentLine = "";
			while(textScanner.hasNext())
			{
				currentLine = textScanner.nextLine();
				fileWriter.println(currentLine);
			}
			textScanner.close();
			fileWriter.close();
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		catch(Exception error)
		{
			app.handleErrors(error);
		}
	}

	public static String loadFromFile(ChatbotController app, String filename)
	{
		String results = "";
		
		try
		{
			File openFile = new File(filename);
			Scanner fileScanner = new Scanner(openFile);
			
			String currentLine = fileScanner.nextLine();
			while (fileScanner.hasNextLine())
			{
				results += currentLine + "\n";
				currentLine = fileScanner.nextLine();
			}
			results += currentLine + "\n";
			fileScanner.close();
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		return results;
	}
}
