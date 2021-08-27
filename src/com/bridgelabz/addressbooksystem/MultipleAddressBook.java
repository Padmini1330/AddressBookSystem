package com.bridgelabz.addressbooksystem;

import java.util.Scanner;
public class MultipleAddressBook 
{
	private AddContactDetails bookArray[];
	private int bookNumber = -1;
	
	private static int numberOfAddressBooks = 0;
	
	Scanner scanner = new Scanner(System.in);

	MultipleAddressBook() 
	{
		bookArray = new AddContactDetails[10];
	}

	public void addAddressBooks() 
	{
		System.out.println("enter address book name");
		String name = scanner.next();
		int index = 0;
		for (index = 0; index < numberOfAddressBooks; index++) 
		{
			if (bookArray[index].getAddressBookName().equals(name)) 
			{
				System.out.println("this contact book alredy exists!!");
				
			}
		}
		bookArray[numberOfAddressBooks] = new AddContactDetails(name);
		numberOfAddressBooks++;
	}

	public int selectAddressBook() 
	{
		System.out.println("enter Contact book name");
		String name = scanner.next();
		int index = 0;
		for (index = 0; index < numberOfAddressBooks; index++) 
		{
			if (bookArray[index].getAddressBookName().equals(name)) 
			{
				bookNumber = index;
				break;
			}
			else
				continue;
		}
		if (bookNumber == -1) 
		{
			System.out.println("no such contact book");
			return -1;
		}
		return 1;
	}

	public void addContact() 
	{
		bookArray[bookNumber].addContact();
	}

	public void editContact() 
	{
		bookArray[bookNumber].editContact();
	}

	public void showContacts() 
	{
		bookArray[bookNumber].showContacts();
	}

	public void deleteContact() 
	{
		bookArray[bookNumber].deleteContact();
	}
}
