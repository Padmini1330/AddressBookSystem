package com.bridgelabz.addressbooksystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
		for(AddressBook addressBook : addressBooksArray.values()) 
		{
			List<EditDetails> contactList = addressBook.getContact();
			contactList.stream()
				.filter(person -> person.getFirstName().equals(name) && person.getState().equals(state))
				.forEach(person -> System.out.println(person));
		}
	}	
		
	public void searchPersonByCity(String name, String city) 
	{
		for(AddressBook addressBook : addressBooksArray.values())
		{
			List<EditDetails> contactList = addressBook.getContact();
			contactList.stream()
				.filter(person -> person.getFirstName().equals(name) && person.getCity().equals(city))
				.forEach(person -> System.out.println(person));
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
