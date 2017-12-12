package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Pile;
import view.DownView;
import view.HeadView;

/**
 * 
 * @author MariamKonateAmeliePerez
 *
 */
public class PileController implements ActionListener {

	private HeadView headView;
	private DownView downView;
	private Pile pile;

	/**
	 * constructor
	 */
	public PileController(){
		
	}

	/**
	 * 
	 * @return HeadView
	 */
	public HeadView getHeadView() {
		return headView;
	}

	/**
	 * 
	 * @param headView
	 */
	public void setHeadView(HeadView headView) {
		this.headView = headView;
	}

	/**
	 * 
	 * @return downView
	 */
	public DownView getDownView() {
		return downView;
	}

	/**
	 * 
	 * @param downView
	 */
	public void setDownView(DownView downView) {
		this.downView = downView;
	}

	/**
	 * 
	 * @return pile
	 */
	public Pile getPile() {return pile;}

	/**
	 * 
	 * @param pile
	 */
	public void setPile(Pile pile) {this.pile = pile;}

	
	/**
	 * in case the views button is pushed
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		String Line=downView.getUserTextField().getText();
		try {
			pile.execCommand(Line);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
