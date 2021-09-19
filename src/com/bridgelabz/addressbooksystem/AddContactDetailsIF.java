package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface AddContactDetailsIF 
{

		public void addContact(HashMap<String, EditDetails> addressBookContact);
		
		public void showContacts(HashMap<String, EditDetails> addressBookContact);
		
		public void editContact(HashMap<String, EditDetails> addressBookContact);
		
		public void deleteContact(HashMap<String, EditDetails> addressBookContact);
		
		public void personWithCity(EditDetails contact);
		
		public void personWithState(EditDetails contact);
		
		public void showPersonList(String location, HashMap<String, ArrayList<EditDetails>> contactsList);
		
		public void showCountofContacts(String location, HashMap<String, ArrayList<EditDetails>> contactsList);
		
		public void sortContacts(HashMap<String, EditDetails> addressBook, int sortKey);
		
		public void writeToAddressBookFile();

		public List<String> readAddressDataFromFile();

}
