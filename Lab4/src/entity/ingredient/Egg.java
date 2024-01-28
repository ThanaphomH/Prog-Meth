package entity.ingredient;

import entity.base.Ingredient;
import logic.Cookable;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {
	private int cookedPercentage;

	public Egg() {
		super("Egg");
		this.cookedPercentage = 0;
	}
	
	public void cook() {
		this.cookedPercentage += 12;
		int x = this.cookedPercentage;
		if (x > 100) {
			this.setName("Burnt Egg");
			this.setEdible(false);
		} else if (x > 80) {
			this.setName("Fried Egg");
			this.setEdible(true);
		} else if (x > 50) {
			this.setName("Sunny Side Egg");
			this.setEdible(true);
		} else {
			this.setName("Raw Egg");
			this.setEdible(false);
		}
	}
	
	public boolean isBurnt() {
		return (this.cookedPercentage > 100) ? true : false;
	}
	
	public String toString() {
		return StringUtil.formatNamePercentage(getName(), cookedPercentage);
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}
}