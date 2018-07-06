package reflection_practice;

public class Person {

	private String name;
	private static int numOfPeople;
	
	public Person(String name){
		this.name = name;
		
		numOfPeople++;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public static void printName(Person p){
		System.out.println(p.name);
	}
}
