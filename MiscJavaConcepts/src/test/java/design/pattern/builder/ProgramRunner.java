package design.pattern.builder;

public class ProgramRunner {

	public static void main(String[] args) {
		
		User user = new User.UserBuilder()
		.withFirstNameAs("Akash")
		.withLastNameAs("Tyagi")
		.withAddressAs("Pune")
		.withMobileAs("9769012260")
		.withAgeAs(34).build();
		
		System.out.println(user.toString());
		
		User user1 = new User.UserBuilder()
		.withFirstNameAs("Sumit")
		.withLastNameAs("Pillai")
		.withAgeAs(34).build();
		
		System.out.println(user1.toString());
		
	}
}
