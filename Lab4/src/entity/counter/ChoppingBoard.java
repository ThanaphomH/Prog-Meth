package entity.counter;

import entity.base.Ingredient;
import logic.Choppable;
import logic.Player;

public class ChoppingBoard extends Counter {
	public ChoppingBoard() {
		this.setName("Chopping Board");
	}
	
	public void interact(Player p) {
		if (!this.isPlacedContentEmpty()) super.interact(p);
		else {
			if (!p.isHandEmpty() && p.getHoldingItem() instanceof Ingredient) {		
				
				super.interact(p);
				if (this.getPlacedContent() instanceof Choppable) {
					((Choppable)this.getPlacedContent()).chop();
				}
				
			}
		}
	}
}