package com.bridgelabz.addressbooksystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBook 
{
	private AddressBook addressBook;
	private Map<String, AddressBook> addressBooksArray;
	Scanner scanner = new Scanner(System.in);
	
	public MultipleAddressBook() 
	{
		addressBooksArray = new HashMap<String, AddressBook>();
	}

	public void addAddressBooks() 
	{
		System.out.println("enter address book name");
		String name = scanner.next();
		int index = 0;
		if (addressBooksArray.containsKey(name)) 
		{
			System.out.println("address book "+name+" already exists!");
			return;
		}
		System.out.println("created address book "+name);
		addressBooksArray.put(name, new AddressBook(name));
	}

	public void showAddressBook() 
	{
		System.out.println("Addressbooks:");
		for (String addressBookName : addressBooksArray.keySet()) 
		{
			System.out.println(addressBookName);
		}
	}
	
	public void searchPersonByState(String name, String state) 
	{
		int searchCount=0;
		for(AddressBook addressBook:addressBooksArray.values()) 
		{
			for(EditDetails contact:addressBook.getContact()) 
			{
				if(contact.getFirstName().equals(name) && contact.getState().equals(state)) 
				{
					System.out.println("contact "+name+" is found ");
					System.out.println(contact);
					searchCount++;
				}
			}
		}
		if(searchCount==0)
			System.out.println("Searched for contact "+ name+ " Contact not found!");
	}
	public void searchPersonByCity(String name, String city) 
	{
		int searchCount=0;
		for(AddressBook addressBook:addressBooksArray.values()) 
		{
			for(EditDetails contact:addressBook.getContact()) 
			{
				if(contact.getFirstName().equals(name) && contact.getCity().equals(city)) 
				{
					System.out.println("contact "+name+" is found ");
					System.out.println(contact);
					searchCount++;
				}
			}
		}
		if(searchCount==0)
			System.out.println("Searched for contact "+ name+ ". Contact not found!");
	}

	public AddressBook selectAddressBook(String name) 
	{	
		if (addressBooksArray.containsKey(name)) 
		{
			addressBook = addressBooksArray.get(name);
			return addressBook;
		}
		System.out.println("Address book "+name+" not found");
		return null;
	}
}
