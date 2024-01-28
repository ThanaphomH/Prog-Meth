package logic.card;

import java.util.ArrayList;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public abstract class EffectCard extends BaseCard {
    // TODO Implement here
	public EffectCard(CardColor color , CardSymbol symbol) {
		super(color, symbol);
	}
	
	abstract public String performEffect(); 
	
	public String play() {
		ArrayList<BaseCard> currentHand = GameLogic.getInstance().getCurrentPlayerHand();
		currentHand.remove(this);
		GameLogic.getInstance().setTopCard(this);
		return performEffect();
	}
}
