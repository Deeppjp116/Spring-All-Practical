package pk1;

public class Computer 
{
	private Processor processor;
	public Computer(Processor processor) 
	{
		this.processor = processor;
	}

	public void showSpecs()
	{
		System.out.println("computer running with "+processor);
	}
	
}
