package entity.ingredient;

import entity.base.Ingredient;
import logic.Choppable;
import logic.Cookable;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {
	private boolean chopState;
	private int cookedPercentage;

	public Meat() {
		super("Meat");
		this.chopState = false;
		this.cookedPercentage = 0;
	}

	public void chop() {
		if (!(chopState && cookedPercentage > 0)) {
			this.setName("Minced Meat");
			this.chopState = true;
		}
	}

	public boolean isChopped() {
		return chopState;
	}

	public void cook() {
		if (this.chopState) {
			this.cookedPercentage += 15;
			int x = this.cookedPercentage;
			if (x > 100) {
				this.setName("Burnt Burger");
				this.setEdible(false);
			} else if (x > 80) {
				this.setName("Cooked Burger");
				this.setEdible(true);
			} else {
				this.setName("Raw Burger");
				this.setEdible(false);
			}
		}
		else {
			this.cookedPercentage += 10;
			int x = this.cookedPercentage;
			if (x > 100) {
				this.setName("Burnt Steak");
				this.setEdible(false);
			} else if (x > 80) {
				this.setName("Well Done Steak");
				this.setEdible(true);
			} else if (x > 50) {
				this.setName("Medium Rare Steak");
				this.setEdible(true);
			} else {
				this.setName("Raw Meat");
				this.setEdible(false);
			}
		}
	}
	
	public boolean isBurnt() {
		return (this.cookedPercentage > 100) ? true : false;
	}
	
	public String toString() {
		return StringUtil.formatNamePercentage(getName(), cookedPercentage);
	}

	public boolean isChopState() {
		return chopState;
	}

	public void setChopState(boolean chopState) {
		this.chopState = chopState;
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}
	
}