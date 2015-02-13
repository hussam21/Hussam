package uppgift4del2;

public class Snake extends Animal {
	
	private boolean isPoisonous;

	public Snake(String latinName, boolean isPoisonous) {
		super(latinName);
		this.isPoisonous = isPoisonous;
	}
	
	

	@Override
	public String getInfo() {
		
		
		String info = "";
		if(isPoisonous) {
			
			
			info = "The snake named " +getFriendlyName() + ", latin: " + getLatinName() +
				" and is poisonous";
			
			
		} else {
			
			info = "The snake named " +getFriendlyName() + ", latin: " + getLatinName() +
					" and is not poisonous";
			
		}
		
		return info;
	}

	public boolean isPoisonous() {
		return isPoisonous;
	}
	
	

}
