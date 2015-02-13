package uppgift4del2;
public class Cat extends Mammal {

	private int numberOfLives;
	
	public Cat(String latinName, int gestationTime, int numberOfLives) {
		super(latinName, gestationTime);
		this.numberOfLives = numberOfLives;
	}

	public int getNumberOfLives() {
		return numberOfLives;
	}

	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}
	
	@Override
	public String getInfo() {
		
		
		String info = "The cats name is " + getFriendlyName() + ", latin: " + getLatinName() +
				" nurses for " + getGestationTime() + " months" +
				" and has " + getNumberOfLives() + " lives.";
		return info;
		
	}

}