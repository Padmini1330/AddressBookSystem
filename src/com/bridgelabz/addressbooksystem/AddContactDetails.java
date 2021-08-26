package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;

public class AddContactDetails 
{
	private ArrayList<EditDetails> addressBook = new ArrayList<EditDetails>();
	
	public void addContact() 
	{
		
		EditDetails detail = new EditDetails();
		detail.setFirstName("Padmini");
		detail.setLastName("V");
		detail.setAddress("JP nagar");
		detail.setCity("Bangalore");
		detail.setState("Karnataka");
		detail.setPinCode("560108");
		detail.setPhoneNumber("9742514342");
		detail.setEmail("padm1330@gmail.com");
		addressBook.add(detail);
		
	}
}