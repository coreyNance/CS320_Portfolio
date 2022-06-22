package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	
	/*This test method is to check to make sure that a new contact can be 
	 * created.*/
	@Test
	void Contacttest() {
		Contact contact = new Contact("1", "John", "Doe", "7814261186", "342 boston st");
		assertTrue(contact.getcontactID().equals("1"));
		assertTrue(contact.getfirstName().equals("John"));
		assertTrue(contact.getlastName().equals("Doe"));
		assertTrue(contact.getphone().equals("7814261186"));
		assertTrue(contact.getaddress().equals("342 boston st"));

	}
	
	/*This test method checks to make show the ID to long error throws.*/
	@Test
	void testContactIdToLong(){
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Contact ("12345678910", "John", "Doe", "7814261186", "342 boston st");
			
		}); }
	
	/*The test method checks to make sure the ID not null error throws.*/
	@Test
	void testContactIdNotNull(){
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Contact (null, "John", "Doe", "7814261186", "342 boston st");
			
		}); }
	
	// This test method checks to make sure the first name to long error throws
	@Test
	void testContactfirstNameToLong(){
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Contact ("1", "John123456789", "Doe", "7814261186", "342 boston st");
			
		}); }
	
	// This test method checks to make sure the first name not null error throws.
	@Test
	void testContactfirstNameNotNull(){
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Contact ("1", null, "Doe", "7814261186", "342 boston st");
			
		}); }
		
	// This test method checks to make sure the last name to long error throws.
	@Test
	void testContactlastNameToLong(){
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Contact ("1", "John", "Doe12345678910", "7814261186", "342 boston st");
			
		}); }
	
	// This test method checks to make sure the last name not null error throws.
	@Test
	void testContactlastNameNotNull(){
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Contact ("1", "John", null, "7814261186", "342 boston st");
			
		}); }
		
	// This test method checks to make sure the phone number not to long error throws.
	@Test
	void testContactNumberToLong(){
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Contact ("1", "John", "Doe", "78142611861111", "342 boston st");
			
		}); }
	
	// This test method checks to make sure the phone number not null error throws.
	@Test
	void testContactNumberNotNull(){
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Contact ("1", "John", "Doe", null, "342 boston st");
			
		}); }
	
	// This test method checks to make sure the address to long error throws.
	@Test
	void testContactAddressToLong(){
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Contact ("1", "John", "Doe", "7814261186", "342 boston st 342 boston st 342 boston st");
			
		}); }
	
	// This method checks to make sure the address not null error throws.
	@Test
	void testContactAddressNotNull(){
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Contact ("1", "John", "Doe", "7814261186", null);
			
		}); }
	
		

		
		
	

}
