/**
 * 
 */
package design.patterns;

/**
 * @author mayank
 * 
 * It is a creational design pattern and the main focus of these patterns is on creation of objects.
 * Basically there is one superclass and many implementaions of that superclass. The subclass will 
 * decide which object to create based on the input from the client/user. 
 * 
 * The client will let the Factory class know which implementation it wants and the Factory will simply
 * create the object of that implementation at the runtime. 
 *
 */
interface Vehicle{
	public int wheels();
}

class Bike implements Vehicle{
	@Override
	public int wheels() {
		return 2;
	}
}

class Car implements Vehicle{
	@Override
	public int wheels() {
		return 4;
	}
}

class Auto implements Vehicle{
	@Override
	public int wheels() {
		return 3;
	}
}

class VehicleFactory{
	
	public Vehicle getWheels(String type) {
		Vehicle vehicle = null;
		if(null != type) {
			switch(type) {
				case "Car":
					vehicle = new Car();
					break;
				
				case "Bike":
					vehicle = new Bike();
					break;
					
				case "Auto":
					vehicle = new Auto();
					break;
			}
		}
		
		return vehicle;
	}
}

public class FactoryPattern {

	public static void main(String[] args) {
		
		VehicleFactory factory = new VehicleFactory();
		Vehicle vehicle = factory.getWheels("Car");
		System.out.println(vehicle.wheels());
	}
}
