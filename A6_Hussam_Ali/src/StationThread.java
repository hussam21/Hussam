

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;


public class StationThread extends Thread {
	private GUI gui;
	private String dotAnimation=".";
	public volatile boolean running=true;
	private String searchURL;
	
	
	
	public StationThread(GUI _gui){
		System.err.println("error");
		System.out.println("error");	
		this.gui=_gui;
		
	}
	
	
	public void run(){

		   System.out.println("// Stations when searching for stations containing "+gui.stationTxt.getText());
			ArrayList<Station> searchStations = new ArrayList<Station>(); // tom arraylist som kanj ha stations
			
		
			searchStations.addAll(Parser.getStationsFromURL(gui.stationTxt.getText()));
			gui.Resultat.setText("");
			for (Station s: searchStations){
				gui.Resultat.append(s.getStationName() +" number:" +s.getStationNbr()+"\n");
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
