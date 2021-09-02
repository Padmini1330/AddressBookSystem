package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddContactDetails implements AddContactDetailsIF
{

	Scanner scanner = new Scanner(System.in);
	private EditDetails contactBook[];
	private static int numberOfContacts = 0;
	private String addressBookName;

	AddContactDetails(String addressBookName) 
	{
		this.contactBook = new EditDetails[20];
		this.addressBookName = addressBookName;
	}

	public String getAddressBookName() 
	{
		return this.addressBookName;
	}
	
	@Override
	public void addContact() {
		System.out.println("Add Contact");
		System.out.println("Enter first name:");
		String firstName = scanner.next();
		System.out.println("Enter last name");
		String lastName = scanner.next();
		System.out.println("Enter city");
		String city = scanner.next();
		System.out.println("Enter address");
		String address = scanner.next();
		System.out.println("Enter state");
		String state = scanner.next();
		System.out.println("Enter Zip");
		int zip = scanner.nextInt();
		System.out.println("Enter Phone");
		int phoneNumber = scanner.nextInt();
		System.out.println("Enter email");
		String email = scanner.next();
		contactBook[numberOfContacts] = new EditDetails(firstName, lastName, address, state, city, zip, phoneNumber, email);
		numberOfContacts++;
	}

	@Override
	public void showContacts() 
	{
		for (int i = 0; i < numberOfContacts; i++) 
		{
			System.out.println(contactBook[i]);
		}
	}

	@Override
	public void editContact() 
	{
		System.out.println("Edit contact:");
		System.out.println("Select Option:\n1.First Name\n2.Last Name\n3.City\n4.State\n5.Zip Code\n6.Phone\n7.Email");
		int choice = scanner.nextInt();
		System.out.println("Enter First Name of contact to be edited");
		String editName = scanner.next();
		int index = 0;
		for (index = 0; index < numberOfContacts; index++) 
		{
			if (contactBook[index].getFirstName().equals(editName)) 
			{
				break;
			} else 
			{
				System.out.println("no such contact found!");
				return;
			}
		}
		switch (choice) 
		{
		case 1:
			System.out.println("Enter new First Name:");
			String newFName = scanner.next();
			contactBook[index].setFirstName(newFName);
			System.out.println("Edited");
			break;
		case 2:
			System.out.println("Enter new Last Name:");
			String newLName = scanner.next();
			contactBook[index].setLastName(newLName);
			System.out.println("Edited");
			break;
		case 3:
			System.out.println("Enter new City:");
			String newCity = scanner.next();
			contactBook[index].setCity(newCity);
			System.out.println("Edited");
			break;
		case 4:
			System.out.println("Enter new State:");
			String newState = scanner.next();
			contactBook[index].setState(newState);
			System.out.println("Edited");
			break;
		case 5:
			System.out.println("Enter new Zip code:");
			int newZip = scanner.nextInt();
			contactBook[index].setZipCode(newZip);
			System.out.println("Edited");
			break;
		case 6:
			System.out.println("Enter new Phone Number:");
			int newPNumber = scanner.nextInt();
			contactBook[index].setPhoneNumber(newPNumber);
			System.out.println("Edited");
			break;
		case 7:
			System.out.println("Enter new Email:");
			String newEmail = scanner.next();
			contactBook[index].setEmailId(newEmail);
			System.out.println("Edited");
			break;
		}
	}

	@Override
	public void deleteContact() 
	{
		System.out.println("Enter Name of Contact to delete");
		String deletedName = scanner.next();
		int index = 0;
		for (index = 0; index < numberOfContacts; index++) 
		{
			if (contactBook[index].getFirstName().equals(deletedName)) 
			{
				break;
			} else 
			{
				System.out.println("there is no such contact existing!");
				return;
			}
		}

		for (int i = index + 1; i < numberOfContacts; i++) 
		{
			contactBook[i - 1] = contactBook[i];
		}
		numberOfContacts--;
		System.out.println("Contact deleted!");
	}
}