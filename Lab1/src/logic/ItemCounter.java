package logic;

public class ItemCounter {
	private Item item;
	private int count;
	
	public ItemCounter(Item item) {
		setItem(item);
		this.count = 1;
	}
	
	public ItemCounter(Item item , int count) {
		setItem(item);
		this.count = Math.max(1, count);
	}
	
	public String toString() {
		return this.getItem().toString() + " x" + this.getCount();
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public void setCount(int count) {
		this.count = Math.max(0, count);
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public int getCount() {
		return this.count;
	}
	
	
}