package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddContactDetails
{
	private ArrayList<EditDetails> addressBook = new ArrayList<EditDetails>();
	public void addPerson() 
	{
		Scanner sc = new Scanner(System.in);
		EditDetails contact = new EditDetails();
		System.out.println("-------Enter the Contact Details--------");
		System.out.print("Enter First Name: ");
		sc.next();
		contact.setFirstName(sc.nextLine());
		System.out.print("Enter Second Name: ");
		sc.next();
		contact.setLastName(sc.nextLine());
		System.out.print("Enter Address: ");
		sc.next();
		contact.setAddress(sc.nextLine());
		System.out.print("Enter City: ");
		contact.setCity(sc.next());
		System.out.print("Enter State: ");
		sc.next();
		contact.setState(sc.nextLine());
		System.out.print("Enter Pin code: ");
		contact.setPinCode(sc.next());
		System.out.print("Enter Phone nmber: ");
		contact.setPhoneNumber(sc.next());
		System.out.print("Enter email: ");
		contact.setEmail(sc.next());
		sc.close();
		addressBook.add(contact);

	}


}
