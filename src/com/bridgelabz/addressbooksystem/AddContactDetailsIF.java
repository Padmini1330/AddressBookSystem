package com.bridgelabz.addressbooksystem;

import java.util.HashMap;

public interface AddContactDetailsIF 
{

		public void addContact(HashMap<String, EditDetails> addressBookContact);
		
		public void showContacts(HashMap<String, EditDetails> addressBookContact);
		
		public void editContact(HashMap<String, EditDetails> addressBookContact);
		
		public void deleteContact(HashMap<String, EditDetails> addressBookContact);

}
