package logic;

import java.util.ArrayList;

public class Market {

	// fields
	private ArrayList<Item> allItems;

	// constructors
	public Market() {
		//FILL CODE
		this.allItems = new ArrayList<Item>();
	}

	public Market(ArrayList<Item> items) {
		//FILL CODE
		this.allItems = new ArrayList<Item>();
		this.addAllItems(items);
	}

	// methods
	public String toString() {
		String out = "\n";
		for (int i = 0; i < allItems.size(); i++) {
			out += i + 1;
			out += ". ";
			out += allItems.get(i).toString();
			out += "\n";
		}
		return out;
	}

	public void addAllItems(ArrayList<Item> items) {
		//FILL CODE
		for (Item eachNewItem : items) {
			boolean isFound = false;
			for (Item eachThisItem : this.getAllItems() ) {
				if (!isFound && eachThisItem.getItemName().equals(eachNewItem.getItemName())) {
					isFound = true;
				} 
			}
			if (!isFound) {
				this.getAllItems().add(eachNewItem);
				System.out.println("\"" + eachNewItem.toString() + "\" Added to the market." );
			} else {
				System.out.println("\"" + eachNewItem.getItemName() + "\" is duplicated, Item will not be added." );
			}
			
		}
	}

	//getter setters 
	//FILL CODE
	public ArrayList<Item> getAllItems() {
		return this.allItems;
	}


}
