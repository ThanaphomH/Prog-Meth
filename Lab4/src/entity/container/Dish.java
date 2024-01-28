package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {
	private int dirty;
	public Dish() {
		super("Dish" , 4);
		this.dirty = 0;
	}
	public Dish(int dirty) {
		super("Dish" , 4);
		this.setDirty(dirty);;
	}
	
	public boolean isDirty() {
		return (this.dirty > 0) ? true : false;
	}
	
	public boolean verifyContent(Ingredient i) {
		return (!this.isDirty() && i.isEdible()) ? true : false;
	}
	
	public void setDirty(int dirty) {
		if (dirty <= 0) {
			this.dirty = 0;
			this.setName("Dish");
		} else if (dirty > 0) {
			this.dirty = dirty;
			this.setName("Dirty Dish");
		}
	}
	
	public void clean(int amount) {
		this.setDirty(this.dirty - amount);
	}
	
	public String toString() {
		if (this.isDirty()) return StringUtil.formatNamePercentage(getName(), dirty);
		return super.toString();
	}
	public int getDirty() {
		return dirty;
	}
}