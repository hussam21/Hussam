package uppgift4del2;
public class Dog extends Mammal {
	
	private boolean isStupid;
	
	

	public Dog(String name, String latinName, int gestationTime, boolean isStupid) {
		super(latinName, gestationTime);
		super.setFriendlyName(name);
		this.isStupid = isStupid;
	}
	
	public Dog(String latinName, int gestationTime, boolean isStupid, String friendlyName) {
		super(latinName, gestationTime);
		this.isStupid = isStupid;
		setFriendlyName(friendlyName);
	}

	public boolean isStupid() {
		return isStupid;
		
		
	}
	
	@Override
	public String getInfo() {
		String info = "";
		
		
		if(isStupid) {
			info = "The dog named: " + getFriendlyName() + ", latin: " + getLatinName() + 
			" nurses for " + getGestationTime() + " months and is stupid";
			
			
		} else {
			info = "The dog named: " + getFriendlyName() + ", latin: " + getLatinName() + 
					" nurses for " + getGestationTime() + " months and is not stupid";
		}
		return info;
	}
	
	
}