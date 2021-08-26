package com.bridgelabz.addressbooksystem;

import java.util.Scanner;
public class AddressBookMain 
{
	public static void main(String args[]) 
	{

		System.out.println("*********** Welcome to address book program  *************");
		Scanner scanner = new Scanner(System.in);
		AddContactDetails addressList = new AddContactDetails();
		int choice = 0;
		boolean exit = true;
		while(exit) 
		{
			System.out.println("Enter 1: Add Contact 2. Edit existing Contact 3. Display 4. Delete Contact 5: Exit");
			choice  = scanner.nextInt();
			switch(choice) {
			case 1 :
				addressList.addPerson();
				break;
			case 2 :
				System.out.println("Enter the Contact Name to Edit Details");
				addressList.editPerson(scanner.next());
				break;
			case 3:
				addressList.display();
				break;
			case 4:
				System.out.println("Enter name");
				addressList.deleteContact(scanner.next());
				break;
			default:
				exit = false;

			}
			System.out.println();
		}
	}
}
