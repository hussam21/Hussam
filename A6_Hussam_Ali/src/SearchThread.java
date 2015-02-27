

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;


public class SearchThread extends Thread {
	private GUI gui;
	public String dotAnimation=".";
	public volatile boolean running=true;
	
	
	
	public SearchThread(GUI _gui){
		System.err.println("error");
		System.out.println("error");	
		this.gui=_gui;
		
		
	}
	
/*	
	public void run(){
		while(running){
			System.err.println("searching");
		
			gui.Resultat.setText("searching"+dotAnimation);
			dotAnimation=dotAnimation+".";
			if(dotAnimation.equals(".....")){
				dotAnimation=".";
			}
			try{
		
				Thread.sleep(50);
			}catch(Exception e){
				System.err.println("error");
				System.out.println("error");
			}
		
		}
		
	}
	*/
	
	
	
}
