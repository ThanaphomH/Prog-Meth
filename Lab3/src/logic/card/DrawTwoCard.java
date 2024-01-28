package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;
import java.util.Objects;

//You CAN modify the first line
public class DrawTwoCard extends EffectCard {
    // TODO Implement here
	public DrawTwoCard(CardColor color) {
		super(color , CardSymbol.DRAW_TWO);
	}
	public String toString() {
		return this.getColor().toString() + " " + this.getSymbol().toString(); 
		
	}
	public boolean canPlay() {
		BaseCard topCard = GameLogic.getInstance().getTopCard();
		if (Objects.equals(topCard, null)) return false;
		return Objects.equals(topCard.getSymbol(), this.getSymbol()) || Objects.equals(topCard.getColor(), this.getColor());
	}
	public String performEffect() {
		GameLogic.getInstance().incrementDrawAmount(2);
		GameLogic.getInstance().goToNextPlayer();
		if (GameLogic.getInstance().getPlayerCount() == 0) return null;
		while (GameLogic.getInstance().getCurrentPlayerHand().size() == 0) {
			GameLogic.getInstance().goToNextPlayer();
		}
		BaseCard findingDrawCard = null;
		for (BaseCard card : GameLogic.getInstance().getCurrentPlayerHand()) {
			if (Objects.equals(card.getSymbol(), CardSymbol.DRAW_TWO) || Objects.equals(card.getSymbol(), CardSymbol.DRAW_FOUR)) {
				findingDrawCard = card;
				break;
			}
		}
		String message = "";
		if (Objects.equals(findingDrawCard, null)) {
			ArrayList<BaseCard> toDraw = GameLogic.getInstance().draw(GameLogic.getInstance().getDrawAmount());
			GameLogic.getInstance().setDrawAmount(0);
			message += "Player " + GameLogic.getInstance().getCurrentPlayer() + " drew " + toDraw.size() + " cards. " + GameLogic.getInstance().getCurrentPlayerHand().size() + " cards remaining." ;
		} else {
			message += "Player " + GameLogic.getInstance().getCurrentPlayer() + " played " + findingDrawCard.toString() + ". " + (GameLogic.getInstance().getCurrentPlayerHand().size()-1) + " cards remaining.\n";
			message += findingDrawCard.play();
		}
		return message;
	}
}
