package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class ChangeColorCard extends EffectCard {
    // TODO Implement here
	public ChangeColorCard() {
		super(null,CardSymbol.CHANGE_COLOR);
	}
	public String toString() {
		if (this.getColor() == null) {
			return "CHANGE COLOR";
		} else {
			return "CHANGE COLOR (" + this.getColor().toString() + " color selected)";
		}
	}
	
	public boolean canPlay() {
		return true;
	}
	
	public String performEffect() {
		CardColor setColor = CardColor.RED;
		if (GameLogic.getInstance().getCurrentPlayerHand().size() > 0 && GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor() != null) {
			setColor = GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor();
		}
		this.setColor(setColor);
		return "Set color to " + setColor.toString();
	}
}
