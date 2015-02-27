

import java.util.Calendar;
import java.util.List;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;


public class ParserThread extends Thread {
	private GUI gui;
	private String dotAnimation=".";
	public volatile boolean running=true;
	private String searchURL;
	
	
	
	public ParserThread(GUI _gui,String _searchURL){
		System.err.println("error");
		System.out.println("error");	
		this.gui=_gui;
		this.searchURL = _searchURL;
	}
	
	
	public void run(){
		/*while(running){
			System.err.println("parsing");
		
	
			try{
		
				Thread.sleep(50);
			}catch(Exception e){
				System.err.println("error");
				System.out.println("error");
			}
		
		}*/
		
		
		Journeys journeys = Parser.getJourneys(searchURL); // ta adress få tillbaka xml file från skanetrafikens databas lägg till journeys
		
		//t.running=false;
		//s.running=false;
		gui.Resultat.setText("");
		for (Journey journey : journeys.getJourneys()) {// loopar i genom alla joureys
			
			gui.Resultat.append(journey.getStartStation()+" - ");
			gui.Resultat.append(journey.getEndStation()+"");
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			gui.Resultat.append(" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late \n");
		
			
			System.out.print(journey.getStartStation()+" - ");
			System.out.print(journey.getEndStation());
			time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			System.out.println(" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late");

		
	}
	}
	/*
	 public Journeys getJourneys(String searchURL){
		 
		 return Parser.getJourneys(searchURL);
	 }
	
	
	 public List<Station>  getStationsFromURL(String text){
		 
		 return Parser.getStationsFromURL(text);
	 }
	*/
	}
