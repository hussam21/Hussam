package uppgift4;

public class Human {
	
	public Dog dog;
	public String name; 

	public Human(String name){
		
		System.out.println("human skapad!!"+ name);
		
		if(name.length() > 3){
		
		this.name=name;
		
		}else{
			
			// om name är mindre än 3 bokstäver så är name = null, och det är inte bra.
			System.out.println("F�r lite bokst�ver");
			
			
		}
		
	}
	
	

		
		
		

	

	
	
 	public String getName() {
 		
 		
 		
		return name;
	}
	
	public void buyDog(Dog dog){
		
		this.dog = dog;
		
		
	}
	
	
	public String getInfo(){
		return name;
		
		
		
		
		
	}
	
	
}
