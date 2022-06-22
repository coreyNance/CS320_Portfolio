package contact;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ContactService {

	/*Contact list array to store every contract object that is added.*/
	private static List<Contact> contacts = new ArrayList<Contact>();
	
	
	
	private static ContactService contactService = new ContactService();
	
	private ContactService() {
	
	}
		
	public static ContactService getContactService() {
		return contactService;
		
	}
	
		
		/*Add contact object that allows a contact but first iterates
		 * through the contacts array and checks to see if the ID does
		 *  not match another ID.*/
	public Contact addContact(String contactID, String firstName,
			String lastName, String number, String address) {

		Contact contact = null;
		
		Iterator<Contact> thisContact = contacts.iterator();
		while(thisContact.hasNext()) {
			
			Contact currentContact = thisContact.next();
			
			if(currentContact.getcontactID().equals(contactID)) {
				contact = currentContact;
				throw new IllegalArgumentException("ID already taken");
		}
		}
			
		// if not found, make a new contact instance and add to list of contacts
		if (contact == null) {
			contact = new Contact(contactID, firstName, lastName, number, address);
			contacts.add(contact);
			System.out.println(contact);
		}
		
		return contact;
		
	}

	

	/*This method removes a contact based on the contactID*/
	public void deleteContact(String contactID) {
		
		for (int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getcontactID().equals(contactID)){
				System.out.println("Removed contactid - " + contactID);
				this.contacts.remove(i);
			}
		}
		
	}
	
	/*This method updates the contact information based on the ID.  Because this method
	 * uses the ID to locate the contact it cant be changed at all.*/
	public Contact updateContactById(String contactID, String firstName, String lastName,
			String number, String address) {
		
		Contact contact = null;
		
		for (int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getcontactID().equals(contactID)){
				
				
				
				contact = new Contact(contactID, firstName, lastName, number, address);
				contacts.set(i, contact);
				System.out.println("if statement worked");
			}
		}
		
		return contact;
		
	}
	
	/*This method updates the contact based on the first name. This method was created to 
	 * check and make sure the ID could not be changed or duplicated.*/
	public Contact updateContactByName(String contactID, String firstName, String lastName,
			String number, String address) {
		
		Contact contact = null;
		
		for (int i = 0; i < contacts.size(); i++) {
			
			/*This block of code first checks if the name at the current index 
			 * equals the name being passed in.  If it does then it iterates over
			 * the contacts to make sure the contactID is not already within the list
			 * If it finds one then it throws the illegalArgument Exception.*/
			if(contacts.get(i).getfirstName().equals(firstName)){
				if(!(contacts.get(i).getcontactID().equals(contactID))) {
					Iterator<Contact> thisContact = contacts.iterator();
					while(thisContact.hasNext()) {
						Contact currentContact = thisContact.next();
						if(currentContact.getcontactID().equals(contactID)) {
							contact = currentContact;
							throw new IllegalArgumentException("ID already taken");
							}
						}
					}
				
				if(!(contacts.get(i).getcontactID().equals(contactID))) {
					throw new IllegalArgumentException("ID cannot be changed");
				}
				contact = new Contact(contactID, firstName, lastName, number, address);
				contacts.set(i, contact);
			}
		}
		
		return contact;
	}
	
	
	/*This method allows for the contacts to be searched and accessed based on the ID*/
	public Contact getContactbyID(String contactID) {

		// a local contact instance
		Contact contact = null;
		
		/*
		 * Created an iterator to search through the array list of contacts by ID
		 * Then there is an if statement to compare the current ContactID to the ContactID given 
		 * and return the contact that matches that ID.
		 */
		
		Iterator<Contact> thisContact = contacts.iterator();
		while(thisContact.hasNext()) {
			
			Contact currentContact = thisContact.next();
			
			if(currentContact.getcontactID().equals(contactID)) {
				contact = currentContact;
			}
			
		}
		
		
		return contact;
	}
	
	
	/* This method is created so that the BeforeEach method can clear
	 * the array before each Junit5 test is run.*/
	public List<Contact> clearArray() {
		
		contacts.clear();
		
		return contacts;
		
	}
	
	/*This method allows for the complete contact list to be accessed.*/
	public List<Contact> getContactList() {
		
		return contacts;
	}
	
	


}

