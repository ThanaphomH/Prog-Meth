package entity.ingredient;

import entity.base.Ingredient;
import logic.Choppable;

public class Lettuce extends Ingredient implements Choppable {
	private boolean chopState;
	
	public Lettuce() {
		super("Lettuce");
		setEdible(true);
		this.chopState = false;
	}
	
	public void chop() {
		if (!this.chopState) {
			this.setName("Chopped Lettuce");
			this.chopState = true;
		} 
	}
	public boolean isChopped() {
		return this.chopState;
	}
}