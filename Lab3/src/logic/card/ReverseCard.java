package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import logic.game.PlayDirection;

//You CAN modify the first line
public class ReverseCard extends EffectCard {
    // TODO Implement here
	public ReverseCard(CardColor color) {
		super(color , CardSymbol.REVERSE);
	}
	
	public String toString() {
		return this.getColor().toString() + " " + this.getSymbol().toString();
	}
	
	public boolean canPlay() {
		BaseCard topCard = GameLogic.getInstance().getTopCard();
		if (topCard.getSymbol().equals(this.getSymbol()) || topCard.getColor().equals(this.getColor())) {
			return true;
		}
		return false;
	}
	
	public String performEffect() {
		PlayDirection newDirection = GameLogic.getInstance().getPlayDirection().getOpposite(); 
		GameLogic.getInstance().setPlayDirection(newDirection);
		return "Set direction to " + newDirection.toString();
	}
}
