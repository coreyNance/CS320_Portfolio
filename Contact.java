package contact;

public class Contact {

	/*Class variables for the contact class*/
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	
	/*Class constructor with if statements to make sure that argument 
	 * variables are not null or too long.*/
	public Contact(String contactID, String firstName, String lastName,
			String phone, String address) {
		
		if(contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
			
		}
		
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		
	}
		
	/*Getter methods to allow controlled access to instance variables.*/
	public String getcontactID() {
		return contactID;
	}
		
	public String getfirstName() {
		return firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public String getphone() {
		return phone;
	}
	
	public String getaddress() {
		return address;
	}
	
	
	/* This method is just to set what the output will be.*/
	@Override
	public String toString() {
		
		return "Contact [id=" + contactID + ", First Name=" + firstName + "]";
	}

		
	
		
		
	
	
	
	
	
	
	
	
	
}
