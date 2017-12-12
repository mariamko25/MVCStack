import controller.PileController;
import model.Pile;
import view.DownView;
import view.HeadView;

/**
 * 
 * @author MariamKonateAmeliePerez
 * class running our MVC and doing all the necessary connections
 */
public class Main {

    public static void main(String[] args) {
        Pile pile = new Pile();
        DownView downView = new DownView();
        HeadView headView = new HeadView();

        pile.addObserver(downView);
        pile.addObserver(headView);

        PileController pileController = new PileController();
        pileController.setDownView(downView);
        pileController.setHeadView(headView);
        pileController.setPile(pile);

        downView.addController(pileController);
        headView.addController(pileController); 

      
    }



}
