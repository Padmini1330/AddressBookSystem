package com.bridgelabz.addressbooksystem;

import java.util.Scanner;
public class AddressBookMain 
{

	public static void main(String[] args) 
	{
		System.out.println("***Welcome to Address Book System***");
		MultipleAddressBook multipleAddressBook = new MultipleAddressBook();
		menu(multipleAddressBook);
	}

	public static void menu(MultipleAddressBook multipleAddressBook) 
	{
		AddContactDetails contactDetails = new AddContactDetails();
		String addressBookName = "";
		Scanner scanner = new Scanner(System.in);
		for (;;) 
		{
			for (;;) 
			{
				System.out.println("1.create new address book  2.edit existing address book  3.show address books  4.search  5.Show contacts by city 6.Show contacts by state 7.show count of contacts based on city 8.show count of contacts based on state 9.exit");
				int choice = scanner.nextInt();
				switch(choice)
				{
				case 1: multipleAddressBook.addAddressBooks();
						break;
				case 2: System.out.println("enter address book name");
						addressBookName = scanner.next();
						if (multipleAddressBook.selectAddressBook(addressBookName) != null)
							break;
						break;
				case 3: multipleAddressBook.showAddressBook();
						break;
				case 4: System.out.println("enter contact's first name");
						String firstName=scanner.next();
						System.out.println("1. search contact by state  2. search contact by city");
						int searchOption=scanner.nextInt();
						if(searchOption==1) 
						{
							System.out.println("enter state name");
							String state=scanner.next();
							multipleAddressBook.searchPersonByState(firstName, state);
						}
						else if(searchOption==2) 
						{
							System.out.println("enter city name");
							String city=scanner.next();
							multipleAddressBook.searchPersonByCity(firstName, city);
						}
				case 5: System.out.println("Enter city name:");
						String city=scanner.next();				
						contactDetails.showPersonList(city,contactDetails.personWithCity);
						break;
				case 6: System.out.println("Enter state name:");
						String state=scanner.next();	
						contactDetails.showPersonList(state,contactDetails.personWithState);
						break;
				case 7: System.out.println("Enter city name: ");
						city=scanner.next();
						contactDetails.showCountofContacts(city,contactDetails.personWithCity);
						break;
				case 8: System.out.println("Enter state name: ");
						state=scanner.next();
						contactDetails.showCountofContacts(state,contactDetails.personWithState);
						break;
				case 9: break;
			}

			System.out.println("1.add contact 2.show contact 3.edit contact 4.delete contact 5.exit");
			int choice1 = scanner.nextInt();
			if (choice1 == 5)
				break;

			switch (choice1) 
			{
			case 1:
				contactDetails.addContact(multipleAddressBook.selectAddressBook(addressBookName).addressBook);
				break;
			case 2:
				contactDetails.showContacts(multipleAddressBook.selectAddressBook(addressBookName).addressBook);
				break;
			case 3:
				contactDetails.editContact(multipleAddressBook.selectAddressBook(addressBookName).addressBook);
				break;
			case 4:
				contactDetails.deleteContact(multipleAddressBook.selectAddressBook(addressBookName).addressBook);
				break;
			}

		 }   
	}
  }
}


