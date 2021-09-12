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
