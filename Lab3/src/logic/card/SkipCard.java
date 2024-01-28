package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public class SkipCard extends EffectCard {
    // TODO Implement here
	public SkipCard(CardColor color) {
		super(color , CardSymbol.SKIP);
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
		GameLogic.getInstance().goToNextPlayer();
		while (GameLogic.getInstance().getCurrentPlayerHand().size() == 0) {
			GameLogic.getInstance().goToNextPlayer();
		}
		int currentPlayer = GameLogic.getInstance().getCurrentPlayer();
		return "Skipped player " + currentPlayer;
	}
}
