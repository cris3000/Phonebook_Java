package PhoneBook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner (System.in);
	private static Mobile mobile = new Mobile ("09288282");
	
	public static void main(String[] args) {
		
		boolean quit = false;
		startPhone();
		printActions();
		while(!quit) {
			System.out.println("6 to show available actions");
			int action = scanner.nextInt();
			scanner.nextLine();
			
			
		switch(action) {
			case 0:
				System.out.println("\n shutting down");
				quit = true;
				break;
			case 1:
				mobile.printContacts();
				break;
			case 2:
				addNewContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6:
				printActions();
				break;
			}
		}
		
		
	}
	
	private static void updateContact() {
		System.out.println("Enter existing name");
		String name = scanner.nextLine();
		Contacts existingContactRecord = mobile.queryContact(name);
		if(existingContactRecord==null) {
			System.out.println("Contact not found");
			return;
		}
		
		System.out.println("Enter new contact name");
		String newName = scanner.nextLine();
		System.out.println("Enter new contact number");
		String newNumber = scanner.nextLine();
		Contacts newContacts = Contacts.createContact(newName, newNumber);
		if(mobile.updateContact(existingContactRecord, newContacts)) {
			System.out.println("Recorded updated");
		}else {
			System.out.println("Error updating record");
		}
	}
	
	
	private static void removeContact() {
		System.out.println("Enter existing name");
		String name = scanner.nextLine();
		Contacts existingContactRecord = mobile.queryContact(name);
		if(existingContactRecord==null) {
			System.out.println("Contact not found");
			return;
		}
		
		if(mobile.removeContact(existingContactRecord)) {
			System.out.println("Deleted");
		}else {
			System.out.println("Error deleting contact");
		}
	}
	
	private static void queryContact() {
		System.out.println("Enter existing name");
		String name = scanner.nextLine();
		Contacts existingContactRecord = mobile.queryContact(name);
		if(existingContactRecord==null) {
			System.out.println("Contact not found");
			return;
		}
		System.out.println("Name: "+ existingContactRecord.getName() + " Number: "+ 
		existingContactRecord.getPhoneNumber() );
	}
	
	
	
	private static void addNewContact() {
		System.out.println("Enter new contact name: ");
		String name = scanner.nextLine();
		System.out.println("Enter phone number");
		String phone = scanner.nextLine();
		Contacts newContact = Contacts.createContact(name, phone);
		if(mobile.addNewContact(newContact)) {
			System.out.println("New contact added: "+ name + " Phone: " +phone);
		}else {
			System.out.println("Cannot add," + name + "already on file");
		}
	}

	private static void startPhone() {
		System.out.println("Starting Phone....");
	}
	
	
	private static void printActions() {
		System.out.println("Available Actions, Press");
		System.out.println("0 - to shutdown");
		System.out.println("1 - View contacts");
		System.out.println("2 - Add");
		System.out.println("3 - Update Existing");
		System.out.println("4 - Remove Contact");
		System.out.println("5 - Query to see if existing contact exists");
		System.out.println("6 - See actions");
		System.out.println("Choose your action");




	}
}
