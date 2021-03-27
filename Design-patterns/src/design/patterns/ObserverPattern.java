/**
 * 
 */
package design.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayank
 *
 *	This pattern is behavioral design pattern and it is about Publisher and Subscriber. One to Many relationship or
 *  dependency is defined between the objects.
 *   
 *  This pattern helps us moving to Push Architecture from Poll Architecture. Publisher will notify
 *  all the subscribers at once when the state of publisher changes.
 *  
 *  So whenever there is an update in the behavior or state, all the subscribers will be notified.
 */

//Publisher
interface Subject{
	void register(Observer o);
	void unRegister(Observer o);
	void notifyObservers();
}

//Subscriber
interface Observer{
	void update(String locaiton);
}


//This class is like a topic in Kafka system
class DeliveryData implements Subject{
	
	private List<Observer> obsevers;
	private String location;
	
	public DeliveryData() {
		this.obsevers = new ArrayList<Observer>();
	}
	
	@Override
	public void register(Observer o) {
		obsevers.add(o);
	}

	@Override
	public void unRegister(Observer o) {
		obsevers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer o : obsevers)
			o.update(location);
	}
	
	public void locationChanged(String changedLocation) {
		this.location = changedLocation;
		notifyObservers();
	}
}


class Seller implements Observer{
	
	private String location;
	
	@Override
	public void update(String location) {
		this.location = location;
		giveLocation();
	}

	private void giveLocation() {
		System.out.println("Notification - Update in Location of Seller : "+location);
	}
}

class Customer implements Observer{
	
	private String location;
	
	@Override
	public void update(String location) {
		this.location = location;
		giveLocation();
	}

	private void giveLocation() {
		System.out.println("Notification - Update in Location of Customer : "+location);
	}
}

public class ObserverPattern {

	public static void main(String[] args) {
		DeliveryData delivery = new DeliveryData();
		
		Observer o1 = new Seller();
		Observer o2 = new Customer();
		
		delivery.register(o1);
		delivery.register(o2);
		
		delivery.locationChanged("New Location");
	}
}
