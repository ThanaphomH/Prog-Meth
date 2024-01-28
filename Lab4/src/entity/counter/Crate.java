package entity.counter;

import logic.InvalidIngredientException;
import logic.LogicUtil;
import logic.Player;

public class Crate extends Counter {
	private String myIngredient;
	public Crate(String s) {
		super(String.format("%s Crate", s));
		this.myIngredient = s;
	}
	
	public void interact(Player p) {
		if (!p.isHandEmpty() || !this.isPlacedContentEmpty()) {
			super.interact(p);
		} else {
			try {
				p.setHoldingItem(LogicUtil.createIngredientFromName(this.myIngredient));
			} catch (InvalidIngredientException e) {
				p.setHoldingItem(null);
			}
		}
	}

	public String getMyIngredient() {
		return myIngredient;
	}

	public void setMyIngredient(String myIngredient) {
		this.myIngredient = myIngredient;
	}
}