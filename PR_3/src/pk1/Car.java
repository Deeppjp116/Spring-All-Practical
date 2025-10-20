package pk1;

public class Car 
{
    private Engine engine;

    public Car() 
    {
        System.out.println("Car object created");
    }

    
    public void setEngine(Engine engine) 
    {
        this.engine = engine;
        System.out.println("Engine Injected Via Setter");
    }

    public void drive() 
    {
        System.out.println("Driving with " + engine);
    }
}
