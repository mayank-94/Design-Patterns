/**
 * 
 */
package design.patterns;

/**
 * @author mayank
 * 
 * It is a structural design pattern. The main idea is to make object of incompatible interfaces
 * compatible with each other. 
 * 
 * Use adapter pattern when you want to use some existing class but it's interface isn't compatible
 * with the rest of your code, Adapter pattern will let you create a middle layer class.
 * 
 * Note - We are not supposed to add any new functionality inside the Adapter. 
 */
interface DistanceInKm{
	double distanceInKm();
}

class DistanceInKmImpl implements DistanceInKm{
	private Double km;
	
	public DistanceInKmImpl(Double km) {
		this.km = km;
	}
	
	@Override
	public double distanceInKm() {
		return km;
	}	
}

interface DistanceInMile{
	double distanceInMile();
}

class DistanceInMileImpl implements DistanceInMile{
	private Double miles;
	
	public DistanceInMileImpl(Double miles) {
		this.miles = miles;
	}
	
	@Override
	public double distanceInMile() {
		return miles;
	}
}

//We implements the interface we want our result in
class DistanceAdapter implements DistanceInKm{
	
	//Using composition
	private DistanceInMile distanceInMile;
	
	//Adapter will accept Miles
	public DistanceAdapter(DistanceInMile distanceInMile) {
		this.distanceInMile = distanceInMile;
	}
	
	@Override
	public double distanceInKm() {
		double miles = distanceInMile.distanceInMile();
		double kms = miles * 1.6;
		return kms;
	}
}

public class AdapterPattern {
	public static void main(String[] args) {
		
		DistanceInMile miles = new DistanceInMileImpl(5.0);
		DistanceAdapter adapter = new DistanceAdapter(miles);
		System.out.println("Distance in km : "+adapter.distanceInKm());
	}
}
