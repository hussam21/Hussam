package uppgift4;

public class Human {
	
	public Dog dog;
	public String name; 
	public String error;
	public Human(String name){
		
		System.out.println("human skapad!!"+ name);
		
		if(name.length() >= 3){
		
		this.name=name;
		
		}else{
			
			
			
			error = "F�r lite bokst�ver";
			System.out.println("F�r lite bokst�ver \n");
			
			
		}
		
	}
	
	

		
		
		

	

	
	
 	public String getName() {

		return name;
	}
	
	public void buyDog(Dog dog){
		
		this.dog = dog;
		
		
	}
	
	
	public String getInfo(){
		
		
		String hej= this.getName() +" �ger en hund som heter "+this.dog.name;
		return hej;

		
	}
	
	
}
