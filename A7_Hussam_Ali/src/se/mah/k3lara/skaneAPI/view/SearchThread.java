package se.mah.k3lara.skaneAPI.view;

public class SearchThread extends Thread{

private GUI gui;
	
	private boolean running = true;
	
	public SearchThread(GUI _GUI){
		this.gui = _GUI;
	}
	
	public void run() {
		while (running == true){
			
			
			try{
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Updating!");
			gui.UpdateLabels();
		}		
	}

}
