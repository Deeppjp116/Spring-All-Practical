package pk1;

import org.springframework.stereotype.Component; 

@Component
public class Engine 
{
	public Engine()
	{
		System.out.println("Eengine Created Via @Component");
	}
	
	@Override
	public String toString()
	{
		return"Engine[Anotation-based]";
	}
}
