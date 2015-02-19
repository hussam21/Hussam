import java.awt.Color;


public class ClockLogic implements ClockInterface {

	public digitalClockGUI clockGUI;
	public int alarmHour;
	public int alarmMinute;
	public Thread thread;
	public final int hourMax = 24;
	public final int hourMin = 0;
	public final int minuteMax = 59;
	public final int minuteMin = 0;
	private int minutesMin;
	
	@Override
	public void update(int hours, int minutes, int seconds) {
    clockGUI.Clock.setText(String.format("%02d",hours) + ":" +String.format("%02d", minutes)+ ":" + String.format("%02d", seconds));
   
    
    
    
    // kollar om alarm = tiden för att få igång larmet
	if(alarmHour == hours && alarmMinute == minutes){
	
		clockGUI.contentPane.setBackground(Color.BLUE);
		System.out.println("vakna");
		
		
	}
		
	}

	public ClockLogic(digitalClockGUI clockln){
		clockGUI=clockln;
		thread = new Thread(new ClockThread(this));
		thread.start();
	}
	
	
	// sätt alarm
	public void setAlarm(int Hours, int minutes){
	
		this.alarmHour= Hours;
		this.alarmMinute= minutes;
		clockGUI.alarmAt.setText(Hours+":"+minutes);
		
		
		// kollar om användarna anger korrekt tid
		if(Hours<hourMin || Hours > hourMax){
		System.out.println("ange korrekt hour");
		clockGUI.alarmAt.setText("");
			
			
		}
		else if(minutes<minutesMin || minutes > minuteMax){
			System.out.println("ange korrekt minute");
			clockGUI.alarmAt.setText("");
		}
		else if(clockGUI.textArea.getText() == null){
			
			
			clockGUI.textArea.setText("0");
			System.out.println("Ange tid");
			
			
		}else if(clockGUI.textArea_1.getText() == null ){
			
			clockGUI.textArea_1.setText("0");
			
			
			
		}
		
		
	}
	
	//nollställ alarmtiden
public void clearAlarm(){
		
		clockGUI.alarmAt.setText("");
		System.out.println("hej");
		
	}
	
	
	
}
