package design.patterns;

/**
 * @author mayank
 *	
 *	Builder pattern is a creational design pattern. This pattern is used when our entity/model class
 *	has a lot of attributes. If we have too many arguments then we need to pass them inside 
 *  constructor in correct sequence as well. This could corrupt the data if we mess up the order of 
 *  data by mistake. Also, it is necessary to pass all the arguments inside the constructor. One way is to create
 *  different overloaded constructors but we may end up in creating a lot of constructors.
 *  
 *  In such scenarios builder pattern is quite helpful. We create a Builder class(usually static nested)
 *  of our Entity and set all the fields inside builder class.  
 */

class User{
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private long phone;
	
	private User() {}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	public long getPhone() {
		return phone;
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
	public static UserBuilder builder() {
		return new UserBuilder();
	}

	static class UserBuilder{
		private User instance;
		
		public UserBuilder() {
			this.instance = new User();
		}
		
		public UserBuilder firstName(String firstName) {
			this.instance.firstName = firstName;
			return this;
		}
		
		public UserBuilder lastName(String lastName) {
			this.instance.lastName = lastName;
			return this;
		}
		
		public UserBuilder age(int age) {
			this.instance.age = age;
			return this;
		}
		
		public UserBuilder phone(long phone) {
			this.instance.phone = phone;
			return this;
		}
		
		public UserBuilder email(String email) {
			this.instance.email = email;
			return this;
		}
		
		public User build() {
			return instance;
		}
	}
}

public class BuilderPattern {
	public static void main(String[] args) {
		
		User user1 = User.builder()
				.firstName("Alex")
				.age(28)
				.email("alex@gmail.com")
				.build();
		
		System.out.println(user1);
		
	}
}
