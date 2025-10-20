package pk1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 

@Component
public class Car 
{
	@Autowired
	private Engine engine;
	
	public void drive()
	{
		System.out.println("Drive with:-> "+engine);
	}
}
