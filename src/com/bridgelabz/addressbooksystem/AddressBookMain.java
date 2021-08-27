package com.bridgelabz.addressbooksystem;

import java.util.Scanner;

public class AddressBookMain 
{
	
	public static void main(String[] args) 
	{
		System.out.println("****Welcome to Address Book Program****");
		
		MultipleAddressBook addressBooks= new MultipleAddressBook();
		
		Scanner scanner = new Scanner(System.in);
		for(;;)
		{
			
			for(;;)
			{
				System.out.println("1.create new address book 2.edit existing address book 3.exit");
				
				int value = scanner.nextInt();
				if(value==1) 
				{
					addressBooks.addAddressBooks();
				}
				else if(value==2) 
				{
					if(addressBooks.selectAddressBook()==1)
						break;
				}
				else 
				{
					return;
				}
			}
			
			System.out.println("1.add contact 2.show contact 3.edit contact 4.delete 5.exit");
			int value = scanner.nextInt();
			if (value == 5)
				break;
			
			switch (value) 
			{
			case 1:addressBooks.addContact();
					break;
			case 2:addressBooks.showContacts();
					break;
			case 3:addressBooks.editContact();
					break;
			case 4:addressBooks.deleteContact();
					break;
			}

	}
	}
}