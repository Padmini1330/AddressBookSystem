package com.bridgelabz.addressbooksystem;

import java.util.Scanner;
public class AddressBookMain {
	public static void main(String args[]) {
		System.out.println("******  Welcome to Address Book Management Program  ********");

		Scanner sc = new Scanner(System.in);
		AddContactDetails addressBook = new AddContactDetails();
		int choice = 0;
		boolean exit = true;
		while(exit) {
			System.out.println("Enter 1.Add Contact 2.Edit existing Contact 3.Display 4.Exit");
			choice  = sc.nextInt();
			switch(choice) {
			case 1 :
				addressBook.addPerson();
				break;
			case 2 :
				System.out.println("Enter Contact's Name to Edit Details");
				addressBook.editPerson(sc.next());
				break;
			case 3:
				addressBook.display();
				break;
			default:
				exit = false;

			}
			System.out.println();
		}
	}
}
