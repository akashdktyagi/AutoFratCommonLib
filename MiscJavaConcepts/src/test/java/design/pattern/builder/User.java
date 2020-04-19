package design.pattern.builder;

public class User {

	private final String firstname;
	private final String lastname;
	private final int age;
	private final String address;
	private final String mobile;
	
	private User(UserBuilder builder){
		this.firstname=builder.firstname;
		this.lastname=builder.lastname;
		this.age=builder.age;
		this.address=builder.address;
		this.mobile=builder.mobile;
	}
	
	//Getters
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public String getMobile() {
		return mobile;
	}
	
	@Override
	public String toString() {
		return "[" + firstname + "," + lastname + "," + address + "," + age + "," + mobile + "]";
	}
	//Nested class
	public static class UserBuilder{
		private String firstname;
		private String lastname;
		private int age;
		private String address;
		private String mobile;
		
		public UserBuilder withFirstNameAs(String text) {
			this.firstname=text;
			return this;
		}
		public UserBuilder withLastNameAs(String text) {
			this.lastname=text;
			return this;
		}
		public UserBuilder withAgeAs(int text) {
			this.age=text;
			return this;
		}
		public UserBuilder withAddressAs(String text) {
			this.address=text;
			return this;
		}
		public UserBuilder withMobileAs(String text) {
			this.mobile=text;
			return this;
		}		
		
		public User build() {
			User user = new User(this);
			return user;
		}
	}
}
