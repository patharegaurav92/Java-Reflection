package reflection_practice;

import java.lang.reflect.*;
import reflection_practice.Person;
public class ReflectionPerson {
	public static void main(String args[]){
		
		/*
		  If you are using something that is inherited, replace...
		  
		  getDeclaredField = getField
		  getDeclaredMethod = getMethod
		 */
		Person p = new Person("Pogo");
		try {
			Field field = p.getClass().getDeclaredField("name");
			field.setAccessible(true);
			System.out.println(field.get(p));
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 --- 
		 */
		
		try {
			Field field = Person.class.getDeclaredField("numOfPeople");
			field.setAccessible(true);
			System.out.println(field.get(null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
		/*
		 ---
		 */
		
		try{
			Method method= p.getClass().getDeclaredMethod("getName");
			System.out.println(method.invoke(p));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		/*
		 ---
		 */
		
		try{
			Method method= p.getClass().getDeclaredMethod("setName",String.class);
			method.invoke(p, "Pogo2");
			System.out.println(p.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*
		 ---
		 */
		
		try{
			Method method= Person.class.getDeclaredMethod("printName",Person.class);
			
			method.invoke(null,p);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*
		 ---
		 */
		Person other = new Person("Ogop");
		Person.printName(other);
		try{
			Constructor<Person> constructor = Person.class.getConstructor(String.class);
			other = constructor.newInstance("Ogop");
			Person.printName(other);
			
		}catch(Exception e){
			
		}
		
		
		
	}
}
