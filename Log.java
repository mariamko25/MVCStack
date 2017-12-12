package model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author MariamKonateAmeliePerez
 * implementing the log files
 */
public class Log {

	private String File="LogFile.txt";
	FileWriter Writer;
	BufferedWriter out;

	/**
	 * constructor
	 */
	Log() 
	{
		
	   try {
		Writer = new FileWriter(File);
        out = new BufferedWriter(Writer);
        
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	private static Log log = new Log();

	/**
	 * writing a line
	 * @param line
	 */
	public void write(String line) {
		try {
			out.write(line+"\n");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * method for closing the log
	 * @throws IOException
	 */
	public void close() throws IOException
	{
		out.close();
		Writer.close();
	}

	/**
	 * 
	 * @return File
	 */
	public String getFile() {
		return File;
	}

	/**
	 * 
	 * @param file
	 */
	public void setFile(String file) {
		File = file;
	}
	
	/**
	 * 
	 * @return log
	 */
	public static Log getLog() {
		return log;
	}
	
	/**
	 * 
	 * @param log
	 */
	public static void setLog(Log log) {
		Log.log = log;
	}
	
}
