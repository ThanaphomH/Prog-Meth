package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.Cookable;

public class Pan extends Container {
	public Pan() {
		super("Pan" , 1);
	}
	
	public boolean verifyContent(Ingredient i) {
		return (i instanceof Cookable);
	}
	
	public void cook() {
		for (Ingredient contain : this.getContent()) {
			((Cookable) contain).cook();;
		}
	}
}