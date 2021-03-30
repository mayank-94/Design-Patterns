/**
 * 
 */
package design.patterns;

/**
 * @author mayank
 * 
 * It is a structural design pattern.
 * 
 * This pattern attaches additional responsibilities to an object dynamically. 
 * Usually we do such things using Abstract classes and Interfaces but they both are compiled times,
 * and Decorator pattern does the same for us dynamically. It favors composition over Inheritance.
 * 
 * Decorator will have the same type as the Object it wants to decorate.
 */
interface Pizza{
	void description();
}

class Plain implements Pizza{

	@Override
	public void description() {
		System.out.print("Plain");
	}
}

abstract class PizzaDecorator implements Pizza{
	
	private Pizza pizza;
	
	public  PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public void description() {
		this.pizza.description();
	}
}

class Paneer extends PizzaDecorator{
	
	public Paneer(Pizza p) {
		super(p);
	}
	
	@Override
	public void description() {
		super.description();
		System.out.print(", Paneer added");
	}
}

class Cheeze extends PizzaDecorator{

	public Cheeze(Pizza pizza) {
		super(pizza);
	}
	
	@Override
	public void description() {
		super.description();
		System.out.print(", Cheeze added");
	}
}

public class DecoratorPattern {

	public static void main(String[] args) {
		
		Pizza p1 = new Plain();
		p1.description();
		System.out.println();
		
		Pizza p2 = new Paneer(new Plain());
		p2.description();
		System.out.println();
		
		Pizza p3 = new Paneer(new Cheeze(new Plain()));
		p3.description();
	}
}
