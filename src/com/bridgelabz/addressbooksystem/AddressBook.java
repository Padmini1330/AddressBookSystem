package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddressBook 
{
	private String name;
	public HashMap<String, EditDetails> addressBook;

	public AddressBook(String name) 
	{
		this.name = name;
		addressBook = new HashMap<String, EditDetails>();
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public ArrayList<EditDetails> getContact() 
	{
		return new ArrayList<EditDetails>(addressBook.values());
	}

	public Map<String, EditDetails> getAddressBook() 
	{
		return addressBook;
	}

}
	
