package pk1;

public class Car 
{
	private Engine engine;
	
	public Car(Engine engine)
	{
		this.engine=engine;
		System.out.println("Car object is created with Engine");
	}
	
	public void drive()
	{
		System.out.println("Driving with Engine:-> "+engine);
	}
}
