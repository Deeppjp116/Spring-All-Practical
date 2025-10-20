package pk1;

public class LifeCycleBean 
{
	public void init()
	{
		System.out.println("Init-Method Called: Bean IS Initaliized");
	}
	
	public void destroy()
	{
		System.out.println("Destroy-Method Called: Bean Destroyed");
	}
	
	public void run()
	{
		System.out.println("Running Main login of Bean");
	}
}
