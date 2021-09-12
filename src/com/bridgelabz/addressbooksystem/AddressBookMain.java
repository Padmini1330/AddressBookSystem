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
				System.out.println("1.create new address book  2.edit existing address book  3.show address books  4.search  5.exit");
				int choice = scanner.nextInt();
				if (choice == 1) 
				{
					multipleAddressBook.addAddressBooks();
				} 
				else if (choice == 2) 
				{
					System.out.println("enter address book name");
					addressBookName = scanner.next();
					if (multipleAddressBook.selectAddressBook(addressBookName) != null)
						break;
				} 
				else if (choice == 3) 
				{
					multipleAddressBook.showAddressBook();
				} 
				else if (choice == 4)
				{
					System.out.println("enter contact's first name");
					String firstName=scanner.next();
					System.out.println("1. search contact by state  2. search contact by city");
					int searchOption=scanner.nextInt();
					if(searchOption==1) {
						System.out.println("enter state name");
						String state=scanner.next();
						multipleAddressBook.searchPersonByState(firstName, state);
					}
					else if(searchOption==2) {
						System.out.println("enter city name");
						String city=scanner.next();
						multipleAddressBook.searchPersonByCity(firstName, city);
					}

				}
				else
				{
					return;
				}

			}

			System.out.println("1.add contact 2.show contact 3.edit contact 4.delete contact 5.exit");
			int choice = scanner.nextInt();
			if (choice == 5)
				break;

			switch (choice) 
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
