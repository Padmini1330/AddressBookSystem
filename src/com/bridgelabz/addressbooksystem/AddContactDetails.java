package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddContactDetails implements AddContactDetailsIF
{

	Scanner scanner = new Scanner(System.in);
	private String addressBookName;
	private HashMap<String, EditDetails> addressBook;
	private EditDetails editDetails;
	
	public HashMap<String, ArrayList<EditDetails>> personWithCity;
	public HashMap<String, ArrayList<EditDetails>> personWithState;

	public AddContactDetails() 
	{
		personWithCity = new HashMap<String, ArrayList<EditDetails>>();
		personWithState = new HashMap<String, ArrayList<EditDetails>>();
	}

	

	public String getAddressBookName() 
	{
		return this.addressBookName;
	}
	
	@Override
	public void addContact(HashMap<String, EditDetails> addressBookContact) {
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
		EditDetails contact = new EditDetails(firstName, lastName, address, state, city, zip, phoneNumber, email);
		
		if(contact.equals(addressBookContact)) 
		{
			System.out.println("Contact "+firstName+" already exists!");
			return;
		}
		addressBookContact.put(firstName, contact);
		System.out.println("Contact added successfully!");
	}

	@Override
	public void showContacts(HashMap<String, EditDetails> addressBookContact) 
	{
		for(EditDetails contact:addressBookContact.values())
			System.out.println(contact);
	}

	@Override
	public void editContact(HashMap<String, EditDetails> addressBookContact) 
	{
		System.out.println("Edit contact:");
		System.out.println("Select Option:\n1.First Name\n2.Last Name\n3.City\n4.State\n5.Zip Code\n6.Phone\n7.Email");
		int choice = scanner.nextInt();
		System.out.println("Enter First Name of contact to be edited");
		String editName = scanner.next();
		int index = 0;
		if(!addressBookContact.containsKey(editName))
		{
			System.out.println("No such contact found!");
			return;
		}
		else
			editDetails=addressBookContact.get(editName);
		
		switch (choice) 
		{
		case 1:
			System.out.println("Enter new First Name:");
			String newFName = scanner.next();
			editDetails.setFirstName(newFName);
			System.out.println("Edited first name");
			break;
		case 2:
			System.out.println("Enter new Last Name:");
			String newLName = scanner.next();
			editDetails.setLastName(newLName);
			System.out.println("Edited last name");
			break;
		case 3:
			System.out.println("Enter new City:");
			String newCity = scanner.next();
			editDetails.setCity(newCity);
			System.out.println("Edited city");
			break;
		case 4:
			System.out.println("Enter new State:");
			String newState = scanner.next();
			editDetails.setState(newState);
			System.out.println("Edited state");
			break;
		case 5:
			System.out.println("Enter new Zip code:");
			int newZip = scanner.nextInt();
			editDetails.setZipCode(newZip);
			System.out.println("Edited zip code");
			break;
		case 6:
			System.out.println("Enter new Phone Number:");
			int newPNumber = scanner.nextInt();
			editDetails.setPhoneNumber(newPNumber);
			System.out.println("Edited phone number");
			break;
		case 7:
			System.out.println("Enter new Email:");
			String newEmail = scanner.next();
			editDetails.setEmailId(newEmail);
			System.out.println("Edited email");
			break;
		}
	}

	@Override
	public void deleteContact(HashMap<String, EditDetails> addressBookContact) 
	{
		System.out.println("Enter Name of Contact to delete");
		String deletedName = scanner.next();
		if(addressBookContact.containsKey(deletedName))
		{
			addressBookContact.remove(deletedName);
			System.out.println("deleted address book "+ deletedName);
		}
		System.out.println("Contact name "+deletedName+" does'nt exits");
	}
	
	public void addToPersonWithCity(EditDetails contact) 
	{
		if (personWithCity.containsKey(contact.getCity()))
			personWithCity.get(contact.getCity()).add(contact);
		else 
		{
			ArrayList<EditDetails> contactList = new ArrayList<EditDetails>();
			contactList.add(contact);
			personWithCity.put(contact.getCity(), contactList);
		}
	}

	public void addToPersonWithState(EditDetails contact) 
	{
		if (personWithState.containsKey(contact.getState()))
			personWithState.get(contact.getState()).add(contact);
		else 
		{
			ArrayList<EditDetails> contactList = new ArrayList<EditDetails>();
			contactList.add(contact);
			personWithState.put(contact.getState(), contactList);
		}
	}

	public void showPersonList(HashMap<String, ArrayList<EditDetails>> personList) 
	{
		ArrayList<EditDetails> personArrayList;
		int flag=0;
		for (String name : personList.keySet()) 
		{
			System.out.println("for " + name);
			personArrayList = personList.get(name);
			for (EditDetails contact : personArrayList) 
			{
				System.out.println(contact);
				flag=1;
			}
		}
		
		if(flag==0)
		{
			System.out.println("No person's Details found");
		}

	}
	
	public void showCountofContacts() 
	{
		int flag1=0,flag2=0;
		System.out.println("number of contact persons by state: ");
		for (String name : personWithState.keySet()) 
		{
			System.out.println("Count of people/person in state " + name +" is " + personWithState.get(name).size());
			flag1=1;
		}
		System.out.println("number of contact persons by city: ");
		for (String name : personWithCity.keySet())
		{
			System.out.println("Count of people/person in city " + name +" is " + personWithCity.get(name).size());
			flag2=1;
		}
		
		if(flag1==0 || flag2==0)
			System.out.println("No contacts found!!");
	}
}