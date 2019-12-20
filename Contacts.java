	package PhoneBook;

import java.util.ArrayList;

public class Contacts {
	
	private String name;
	private String phoneNumber;
	/**
	 * @param name
	 * @param phoneNumber
	 */
	public Contacts(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber=phoneNumber;
	}
	
	public String getName() {
		return name;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public static Contacts createContact(String name, String phoneNumber) {
		return new Contacts(name, phoneNumber);
	}
	

	
}
