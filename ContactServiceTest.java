package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

class ContactServiceTest {
	
	/*This assigns the ContactService to the variable service.*/
	ContactService service = ContactService.getContactService();
	
	/*This BeforeEach method clears the array within contactservice before each
	 * test is performed. This way each test can be performed independently.*/
	@BeforeEach
	void clearArray () {
	
		service.clearArray();
	}
	

	/*This test is to test adding a single contact using the Addcontact method.*/
	@Test
	void testAddContact() {

		Contact contact1 = service.addContact("1","John1", "Doe", "5155557777", "123 boston steet");
		assertEquals("1", contact1.getcontactID());
	}


	/*This test is to test that multiple contacts are able to be saved in the contacts array.
	 * Then uses the test array to verify the array is correct.*/
	@Test
	void testAddContacts() {
		 List<Contact> testArray = new ArrayList<Contact>();
		
		Contact contact1 = service.addContact("1","John1", "Doe", "5155557777", "123 boston steet");
		Contact contact2 = service.addContact("2","John2", "Doe", "5155557777", "123 boston steet");
		Contact contact3 = service.addContact("3","John3", "Doe", "5155557777", "123 boston steet");
		Contact contact4 = service.addContact("4","John4", "Doe", "5155557777", "123 boston steet");
		Contact contact5 = service.addContact("5","John5", "Doe", "5155557777", "123 boston steet");
		
		testArray.add(contact1);
		testArray.add(contact2);
		testArray.add(contact3);
		testArray.add(contact4);
		testArray.add(contact5);
		
		assertEquals(testArray,service.getContactList());
	}
	
	
	/*This test checks to make sure the same contactID cant be added to the array.
	 * If the action is attempted, then the error exception is thrown.*/
	@Test
	void testContactUnique(){
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			Contact contact1 = service.addContact("1","John1", "Doe", "5155557777", "123 boston steet");
			Contact contact2 = service.addContact("1","John2", "Doe", "5155557777", "123 boston steet");
			
		}); }
	
	
	
	/*This method tests the delete method by first creating the deletearray to be compared.
	 * Then adding all 5 contacts to the array, calling the deletearray method. Then add 
	 * all contacts except for the deleted contact to the deletearray. After that the deletearray
	 * is compared to the contacts to use a match to verify that the delete method works.*/
	@Test
	void testDeleteContacts() {
		 List<Contact> deleteArray = new ArrayList<Contact>();
		
		Contact contact1 = service.addContact("1","John1", "Doe", "5155557777", "123 boston steet");
		Contact contact2 = service.addContact("2","John2", "Doe", "5155557777", "123 boston steet");
		Contact contact3 = service.addContact("3","John3", "Doe", "5155557777", "123 boston steet");
		Contact contact4 = service.addContact("4","John4", "Doe", "5155557777", "123 boston steet");
		Contact contact5 = service.addContact("5","John5", "Doe", "5155557777", "123 boston steet");
		
		service.deleteContact("4");
		deleteArray.add(contact1);
		deleteArray.add(contact2);
		deleteArray.add(contact3);
		deleteArray.add(contact5);
		
		assertEquals(deleteArray,service.getContactList());
	}
	
	
	/*The updatecontacts test method checks to make sure the updatemethod works.  This method 
	 * first creates an updateArray for comparison, then adds contacts to contact array.
	 * Next a new contact object is created locally and saved in to the update array and then,
	 * the updateContactById is called to update contact 3 which changes the name.  Next
	 * the two contacts are compared and the match verifies that the method works. */
	@Test
	void testUpdateContacts() {
		 List<Contact> updateArray = new ArrayList<Contact>();
		
		Contact contact1 = service.addContact("1","John1", "Doe", "5155557777", "123 boston steet");
		Contact contact2 = service.addContact("2","John2", "Doe", "5155557777", "123 boston steet");
		Contact contact3 = service.addContact("3","John3", "Doe", "5155557777", "123 boston steet");
		Contact contact4 = service.addContact("4","John4", "Doe", "5155557777", "123 boston steet");
		Contact contact5 = service.addContact("5","John5", "Doe", "5155557777", "123 boston steet");
		
		Contact contact11 = new Contact("3", "Ashley", "Doe", "7815689336", "no current address");
		
		updateArray.add(contact1);
		updateArray.add(contact2);
		updateArray.add(contact11);
		updateArray.add(contact4);
		updateArray.add(contact5);
		
		service.updateContactById("3", "Ashley", "Doe", "7815689336", "no current address");
		assertEquals(updateArray.get(2).getfirstName(),service.getContactbyID("3").getfirstName());
	}
	
	
	/*This test is just to make sure the ID cant be changed but for wanted to test
	 * to make sure that the method works in general.  Creates an updatename array, then
	 * adds contacts to the contact array. Next is to create a new contact object to be added
	 * to the updatenamearray for comparison. The address is changed and compared to 
	 * verfiy that the update works.*/
	@Test
	void testUpdateContactsByName() {
		 List<Contact> updateNameArray = new ArrayList<Contact>();
			
		Contact contact1 = service.addContact("1","John1", "Doe", "5155557777", "123 boston steet");
		Contact contact2 = service.addContact("2","John2", "Doe", "5155557777", "123 boston steet");
		Contact contact3 = service.addContact("3","John3", "Doe", "5155557777", "123 boston steet");
		Contact contact4 = service.addContact("4","John4", "Doe", "5155557777", "123 boston steet");
		Contact contact5 = service.addContact("5","John5", "Doe", "5155557777", "123 boston steet");
		
		Contact contact11 = new Contact("2", "John2", "Doe", "5155557777", "no current address");
		
		updateNameArray.add(contact1);
		updateNameArray.add(contact11);
		updateNameArray.add(contact2);
		updateNameArray.add(contact4);
		updateNameArray.add(contact5);
		
		service.updateContactByName("2", "John2", "Doe", "4441231234", "no current address");
		assertEquals(updateNameArray.get(1).getaddress(),service.getContactbyID("2").getaddress());
		
	}
	
	
	/*This test is the actual test to just to make sure the ID cant be changed. This test just
	 * attempts to update a contact based on the name but with a different ID, which throws
	 * an error verifying that the id cant be changed.*/
	@Test
	void testUpdateContactsByNameIdCantChange() {
		
		Assertions.assertThrows(IllegalArgumentException.class,()->{
				
			Contact contact1 = service.addContact("1","John1", "Doe", "5155557777", "123 boston steet");
			Contact contact2 = service.addContact("2","John2", "Doe", "5155557777", "123 boston steet");
			Contact contact3 = service.addContact("3","John3", "Doe", "5155557777", "123 boston steet");
			Contact contact4 = service.addContact("4","John4", "Doe", "5155557777", "123 boston steet");
			Contact contact5 = service.addContact("5","John5", "Doe", "5155557777", "123 boston steet");
		
			service.updateContactByName("10", "John2", "Doe", "4441231234", "no current address");
		
		}); }
	
	
	/*This test is verify that the ID cant be duplicated. This test attempts 
	 * to update a contact based on the name but with the same ID as another, which throws
	 * an error verifying that the id cant be duplicated.*/
	@Test
	void testUpdateContactsByNameIdCantDuplicate() {
		
		Assertions.assertThrows(IllegalArgumentException.class,()->{
				
			Contact contact1 = service.addContact("1","John1", "Doe", "5155557777", "123 boston steet");
			Contact contact2 = service.addContact("2","John2", "Doe", "5155557777", "123 boston steet");
			Contact contact3 = service.addContact("3","John3", "Doe", "5155557777", "123 boston steet");
			Contact contact4 = service.addContact("4","John4", "Doe", "5155557777", "123 boston steet");
			Contact contact5 = service.addContact("5","John5", "Doe", "5155557777", "123 boston steet");
		
			service.updateContactByName("3", "John2", "Doe", "4441231234", "no current address");
		
		}); }
	
}


	

