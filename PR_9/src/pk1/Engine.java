package pk1;

public class Engine 
{
	private String type="Petrol Engine";
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type=type;
	}
	
	public String toString()
	{
		return"Engine Type:-> "+type;
	}
	
}
