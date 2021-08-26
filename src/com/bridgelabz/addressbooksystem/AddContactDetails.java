package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddContactDetails
{
	private ArrayList<EditDetails> addressList = new ArrayList<EditDetails>();

	public void addPerson() 
	{
		System.out.println("Enter Person details:");
		addressList.add(addContact());
	}
	public static EditDetails addContact() {
		Scanner scanner = new Scanner(System.in);
		EditDetails contact = new EditDetails();

		System.out.print("Enter First Name:");
		contact.setFirstName(scanner.next());
		System.out.print("Enter Second Name: ");
		contact.setLastName(scanner.next());
		System.out.print("Enter Address: ");
		contact.setAddress(scanner.next());
		System.out.print("Enter City: ");
		contact.setCity(scanner.next());
		System.out.print("Enter State: ");
		contact.setState(scanner.next());
		System.out.print("Enter Pin code: ");
		contact.setPinCode(scanner.nextLine());
		System.out.print("Enter Phone nmber: ");
		contact.setPhoneNumber(scanner.next());
		System.out.print("Enter Email: ");
		contact.setEmail(scanner.next());
		return contact;
	}

	public void editPerson(String name) {
		EditDetails contact = null ;
		int i = 0;
		if(addressList.size()!=0) {
			while(i < addressList.size()) {
				if(addressList.get(i).getFirstName().equals(name)) {
					contact = addressList.get(i);
					break;
				}
				i++;
			}
			if(contact == null) {
				System.out.println("Name not found");
				return;
			}

			System.out.println("Enter new details  of "+name);
			addressList.set(i,addContact());
			System.out.println("Modified Details Successfully");
		}
		else
		{
			System.out.println("Add some contacts to Edit");
		}
	}

	public void display() {
		Scanner scanner = new Scanner(System.in);
		EditDetails contact = null; 
		if(addressList.size()!=0) 
		{
		for(int i=0; i<addressList.size();i++) 
		{
			System.out.print(addressList.get(i).getFirstName()+"  ");
		}
		System.out.println();
		System.out.println("Enter name to see details");
		String name = scanner.next();

		for(int i = 0;i < addressList.size();i++) 
		{
			if(addressList.get(i).getFirstName().equals(name)) 
			{
				contact = addressList.get(i);
				break;
			}
		}
		if(contact == null) 
		{
			System.out.println("name not found");
			return;
		}

		displayEditDetails(contact);
		}
		else
		{
			System.out.println("Add contacts");
		}
		

	}



	public static void displayEditDetails(EditDetails contact) 
	{
		System.out.println("First Name : "+contact.getFirstName());
		System.out.println("Second Name : "+ contact.getLastName());
		System.out.println("Address : "+ contact.getAddress());
		System.out.println("City : "+contact.getCity());
		System.out.println("State : "+contact.getState());
		System.out.println("Pin code : "+contact.getPinCode());
		System.out.println("Phone nmber : "+contact.getPhoneNumber() );
		System.out.println("Email : "+contact.getEmail());
	}
	
	public void deleteContact(String name) 
	{
		if(addressList.size()!=0) 
		{
			for(int i=0;i<addressList.size();i++) 
			{
				if(addressList.get(i).getFirstName().equals(name)) 
				{
					addressList.remove(i);
					System.out.println("Deleted details of : "+name);
					return;
				}
			}
			System.out.println("Name not found");
		}
		else
		{
			System.out.println("Add contacts to delete");
		}
	}
}


