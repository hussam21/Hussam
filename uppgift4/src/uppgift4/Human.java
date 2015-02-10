package uppgift4;

public class Human {
	
	public Dog dog;
	public String name; 

	public Human(String name){
		
		System.out.println("human skapad!!"+ name);
		
		if(name.length() > 3){
		
		this.name=name;
		
		}else{
			
			System.out.println("För lite bokstäver");
			
			
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
