package view;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

/**
 * 
 * @author MariamKonateAmeliePerez
 * class showing the DownView
 */
public class DownView extends JFrame implements Observer {

	private TextField userTextField;
	private String listInt;
	/**
	 * method to getButton
	 * @return button
	 */
	public Button getButton() {
		return button;
	}
	/**
	 * method to set button
	 * @param button
	 */
	public void setButton(Button button) {
		this.button = button;
	}
	
	/**
	 * method to get serialVersionUID
	 * @return serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * method to get userTextField
	 * @return userTextField
	 */
	public TextField getUserTextField() {
		return userTextField;
	}
	public void setUserTextField(TextField userTextField) {
		this.userTextField = userTextField;
	}

	private Button button; 
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * constructor setting DownViews param
	 */
	public DownView()
	{
		
		
		this.setTitle("DownView");
	    this.setSize(500, 300);
	    userTextField=new TextField();
	    this.add(userTextField,BorderLayout.SOUTH);  
	    button	 		= new Button("Press");
	    button.setPreferredSize(new Dimension(120, 20));
	    this.add(button,BorderLayout.EAST);
	    this.add(new list(), BorderLayout.CENTER);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.setVisible(true);
		
	 
	}
	
	/**
	 * method updating observer through observable
	 * @param o
	 * @param arg
	 */
	public void update(Observable o, Object arg) {
		@SuppressWarnings("unchecked")
		List <Integer> ListInteger=(ArrayList<Integer>) arg;
		List <Integer> LastFive=new ArrayList<Integer>();
		
		if(ListInteger.size()<=5)
		{
			for(int i=0;i<ListInteger.size();i++)
			{
				LastFive.add(ListInteger.get(i));
			}
			
		}
		else
		{
			for(int i=0;i<=4;i++)
			{
				LastFive.add(ListInteger.get(i));
			}
		}
		listInt=LastFive.toString();
	}
	
	/**
	 * method adding a controller to the view
	 * @param pileController
	 */
	public void addController(controller.PileController pileController){
		button.addActionListener(pileController);	
	}
	
	/**
	 * class updating the list
	 * @author MariamKonate
	 *
	 */
	public class list extends JPanel {
		/**
		 * version avant serialization
		 */
		private static final long serialVersionUID = 1L;
		private JLabel list;
		/**
		 * constructor
		 */
		public list() {
			setLayout(new GridBagLayout());
			list = new JLabel();
			list.setFont(new Font("Arial", Font.BOLD, 20));
			tickTock();
			add(list);
			Timer timer = new Timer(500, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tickTock();
				}
			});
			timer.setRepeats(true);
			timer.setCoalesce(true);
			timer.setInitialDelay(0);
			timer.start();
		}
		/**
		 * method updating the view in real Time
		 */
		public void tickTock() {

			list.setText(listInt);
		}
	}
	
	
	
	
}
