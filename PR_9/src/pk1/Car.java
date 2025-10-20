package pk1;

public class Car 
{
	private Engine engine;
	
	public void setEngine(Engine engine)
	{
		this.engine=engine;
	}
	
	public void showDetails()
	{
		System.out.println("Car is Running with "+engine);
	}
}
