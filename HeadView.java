package view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author MariamKonateAmeliePerez
 * class representing the HeadView
 * it shows the head of the stack in real time
 */
public class HeadView extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5785430987871985006L;
	private int headint;

	/**
	 * @param o
	 * @param arg
	 * observer method of updating the view
	 */
	public void update(Observable o, Object arg) {
		@SuppressWarnings("unchecked")
		List <Integer> ListInteger=(ArrayList<Integer>)arg;
		if(ListInteger.size()>0)
		{
			headint=ListInteger.get(ListInteger.size()-1);
		}
		else
		{
			headint=0;
		}
		
	}

	

	public void addController(controller.PileController pileController){}
	
	/**
	 * constructor
	 */
	public HeadView()
	{
		
		this.setTitle("HeadView");
	    this.setSize(300, 200);
	    this.add(new head(), BorderLayout.CENTER);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.setVisible(true);
	}
	
	/**
	 * class with an updating method
	 * @author MariamKonateAmeliePerez
	 *
	 */
	public class head extends JPanel {
		/**
		 * version avant serialization
		 */
		private static final long serialVersionUID = 1L;
		private JLabel head;
		
		/**
		 * constructor setting parameters
		 */
		public head() {
			setLayout(new GridBagLayout());
			head = new JLabel();
			head.setFont(new Font("Arial", Font.BOLD, 20));
			tickTock();
			add(head);
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
		 * functions with updating methods
		 */
		public void tickTock() {

			head.setText(""+headint);
		}
	}
}
