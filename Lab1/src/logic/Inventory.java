package logic;

import java.util.ArrayList;

public class Inventory {
	
	//fields
	private String playerName;
	private int money;
	private ArrayList<ItemCounter> items;
	
	//constructors
	public Inventory(String playerName) {
		//FILL CODE
		setPlayerName(playerName);
		setMoney(0);
		setItems(new ArrayList<ItemCounter>());
	}
	
	public Inventory(String playerName, int money) {
		//FILL CODE
		setPlayerName(playerName);
		setMoney(money);
		setItems(new ArrayList<ItemCounter>());
	}
	
	public Inventory(String playerName, int money, ArrayList<ItemCounter> items) {
		//FILL CODE
		setPlayerName(playerName);
		setMoney(money);
		setItems(items);
	}
	
	//methods
	public String toString() {
		if (items.size() == 0) {
			return "EMPTY INVENTORY";
		}
		String out = "\n";
		for (int i=0; i<items.size(); i++) {
			out += i+1;
			out += ". ";
			out += items.get(i).toString();
			out += "\n";
		}
		return out;
	}
	public boolean existsInInventory(Item item) {
		//FILL CODE
		for (ItemCounter eachItem : items) {
			if (eachItem.getItem() == item) return true;
		}
		return false;
	}

	public void addItem(Item newItem, int count){
		//FILL CODE
		boolean isAdded = false;
		for (int i=0;i<this.getItems().size() && !isAdded;i++) {
			if (this.getItems().get(i).getItem().equals(newItem)) {
				this.getItems().get(i).setCount(this.getItems().get(i).getCount() + count);
				isAdded = true;
			}
		}
		if (!isAdded) this.getItems().add(new ItemCounter(newItem,count));
	}

	public void removeItem(Item toRemove, int count) {

		// if the amount is zero or negative, just return. nothing is removed.
		if (count <= 0)
			return;

		ItemCounter removeIfNeg = null;

		for (ItemCounter ic : items) {
			if (ic.getItem().equals(toRemove)) {
				// Remove the card equal to count.
				ic.setCount(ic.getCount() - count);
				removeIfNeg = ic;
			}
		}

		// If removeIfNeg isn't null (meaning something got removed) then we need to
		// check if it is negative.
		if (removeIfNeg != null) {
			// If it goes into the negative, then remove this entry from the deck entirely.
			// You cannot modify a for loop while it's inside, so this has to be done
			// outside.
			if (removeIfNeg.getCount() <= 0) {
				items.remove(removeIfNeg);
			}
		}

	}
	

	//getters setters
	//FILL CODE
	// V
	public void setPlayerName(String playerName) {
		if (playerName.isBlank()) {
			this.playerName = "Untitled Player";
		} else {
			this.playerName = playerName;
		} 
	}
	
	public void setMoney(int money) {
		this.money = Math.max(0, money);
	}
	
	public void setItems(ArrayList<ItemCounter> items) {
		this.items = items;
	}
	// V
	public String getPlayerName() {
		return this.playerName;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public ArrayList<ItemCounter> getItems() {
		return this.items;
	}
	
}
