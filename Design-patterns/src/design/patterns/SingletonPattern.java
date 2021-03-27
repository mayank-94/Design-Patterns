/**
 * 
 */
package design.patterns;

/**
 * @author mayank
 *
 */
class Singleton{
	private static Singleton instance;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				if(instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}
}

public class SingletonPattern {
	public static void main(String[] args) {
		
		Singleton o1 = Singleton.getInstance();
		System.out.println(o1);
		
		Singleton o2 = Singleton.getInstance();
		System.out.println(o2);
	}
}
