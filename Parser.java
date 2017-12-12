package model;
import java.util.Scanner;

/**
 * 
 * @author MariamKonateAmeliePerez
 * class implementing the parser
 * 
 */
public class Parser {

	/**
	 * constructor
	 */
	Parser()
	{
		
	}
	
	/**
	 * 
	 * @param Line
	 * @return command
	 */
	public String getCommand(String Line) {
		String command="";
		if(!Line.isEmpty())
		{
		Scanner scan= new Scanner(Line);
		String sample=scan.next();
		scan.close();
		if(sample.equalsIgnoreCase("push"))
			command = "PUSH";
		else if(sample.equalsIgnoreCase("clear"))
			command = "CLEAR";
		else if(sample.equalsIgnoreCase("pop"))
			command = "POP";
		else if(sample.equalsIgnoreCase("quit"))
			command = "QUIT";
		else
			throw new IllegalArgumentException("Your command is incorrect, please try again");
		}
		return command;
		
	}

	/**
	 * 
	 * @param Line
	 * @return number
	 */
	public int getNumber(String Line) {
		int number=0;
		if(!getCommand(Line).equals(""))
		{
			@SuppressWarnings("resource")
			Scanner scan= new Scanner(Line);
			scan.next();
			if(scan.hasNextInt())
			{
				number=scan.nextInt();
			}
		}
		return number;
	}
	
}
