package logic;

import exception.NameBlankException;

public class Item {

	private String itemName;
	private int price;

	// constructor
	public Item(String itemName) throws NameBlankException {
		//FILL CODE
		
	}

	public Item(String itemName, int price) throws NameBlankException{
		//FILL CODE
	}

	// methods
	public boolean equals(Item other) {
		//FILL CODE
		return true;
	}

	public String toString() {
		//FILL CODE
		return "???";
	}

	// getter & setter
	public String getItemName() {
		//FILL CODE
		return "???";
	}

	public void setItemName(String itemName) throws NameBlankException {
		//FILL CODE
	}

	public int getPrice() {
		//FILL CODE
		return 0;
	}

	public void setPrice(int price) {
		//FILL CODE
	}

}
