package logic.card;

import logic.game.CardSymbol;

import java.util.ArrayList;
import java.util.Objects;

import logic.game.CardColor;
import logic.game.GameLogic;

//You CAN modify the first line
public class NumberCard extends BaseCard {
    // TODO Implement here
	public NumberCard(CardColor color , CardSymbol symbol) {
		super(color , symbol);
	}
	
	public boolean canPlay() {
		BaseCard topCard = GameLogic.getInstance().getTopCard();
		if (Objects.equals(topCard, null)) return false;
		return Objects.equals(topCard.getSymbol(), this.getSymbol()) || Objects.equals(topCard.getColor(), this.getColor());
	}
	
	public String toString() {
		return this.getColor().toString() + " " + this.getSymbol().toString(); 
	}
	
	public String play() {
		ArrayList<BaseCard> currentHand = GameLogic.getInstance().getCurrentPlayerHand();
		currentHand.remove(this);
		GameLogic.getInstance().setTopCard(this);
		return null;
	}
}
