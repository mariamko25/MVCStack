package model;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * 
 * @author MariamKonateAmeliePerez
 *
 */
public class Pile extends Observable {

	private List <Integer> ListInteger;

	private int Head;

	private Parser parser;
	
	private Log log;
	
	/**
	 * constructor
	 */
	public Pile()
	{
		parser=new Parser();
		log= new Log();
		ListInteger =new  ArrayList<Integer> ();
	}

	/**
	 * 
	 * @return ListInteger
	 */
	public List<Integer> getListInteger() {
		return ListInteger;
	}

	/**
	 * 
	 * @param listInteger
	 */
	public void setListInteger(List<Integer> listInteger) {
		ListInteger = listInteger;
		setHead();
		//notifyObservers(ListInteger);
	}

	/**
	 * 
	 * @return parser
	 */
	public Parser getParser() {
		return parser;
	}

	/**
	 * 
	 * @param parser
	 */
	public void setParser(Parser parser) {this.parser = parser;}

	/**
	 * 
	 * @return Head
	 */
	public int getHead() {
		return Head;
	}

	/**
	 * function setting the Head of the stack
	 */
	public void setHead() {
		if(ListInteger.size()>0)
		{
			Head = ListInteger.get(0);
			notifyObservers(Head);
		}
		else
		{
			Head=0;
			notifyObservers(Head);
		}
		
		
	}

	/**
	 * 
	 * @return log
	 */
	public Log getLog() {
		return log;
	}

	/**
	 * 
	 * @param log
	 */
	public void setLog(Log log) {this.log = log;}
	
	/**
	 * function executing the command given
	 * @param Line
	 * @throws IOException
	 */
	public void execCommand(String Line) throws IOException
	{
		log.write("Command: "+Line+" at: "+ LocalTime.now() + " on "+ LocalDate.now());

		switch(parser.getCommand(Line)) {
			case "PUSH":
				ListInteger.add(parser.getNumber(Line));
				setHead();
				break;
			case "POP":
				ListInteger.remove((Object) parser.getNumber(Line));
				setHead();
				break;
			case "QUIT": 
				log.close();
				System.exit(0);
				break;
			case "CLEAR":
				ListInteger.clear();
				Head = 0;
				break;
		}
		setChanged();
		notifyObservers(ListInteger);
	}

	
	
	
	

}
