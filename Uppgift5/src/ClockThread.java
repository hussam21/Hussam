
import java.util.Calendar;



public class ClockThread implements Runnable {
	

	public ClockInterface clockinterface;
	private Calendar cal;
	private volatile boolean run;
	
	
	public ClockThread(ClockInterface cl){
		
		
		this.clockinterface = cl;
		run = true;
		
	}
	
	
	public void run() {
		
		
		// infinite loop och uppdaterar klocklogic
		while(run){
		try{
			cal = Calendar.getInstance();
			System.out.println("run thread");
			clockinterface.update(cal.get(cal.HOUR_OF_DAY), cal.get(cal.MINUTE),cal.get(cal.SECOND));
			Thread.sleep(999);
		
			
			
		}catch(Exception e){
		}
		}
	}
}
	

