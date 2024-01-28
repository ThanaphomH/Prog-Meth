package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;
import java.util.Objects;

//You CAN modify the first line
public class DrawFourCard extends EffectCard {
    // TODO Implement here
	public DrawFourCard() {
		super(null , CardSymbol.DRAW_FOUR);
	}
	public String toString() {
		if (Objects.equals(this.getColor(), null)) {
			return "DRAW FOUR";
		} else {
			return "DRAW FOUR (" + this.getColor() + " color selected)";
		}
	}
	public boolean canPlay() {
		return true;
	}
	
	public String performEffect() {
		CardColor setColor = CardColor.RED;
		if (GameLogic.getInstance().getCurrentPlayerHand().size() > 0 && !Objects.equals(GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor(), null)) {
			setColor = GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor();
		}
		this.setColor(setColor);
		String message = "";
		message += "Set color to " + this.getColor().toString() + "\n";

		GameLogic.getInstance().incrementDrawAmount(4);
		GameLogic.getInstance().goToNextPlayer();
		if (GameLogic.getInstance().getPlayerCount() == 0) return null;
		while (GameLogic.getInstance().getCurrentPlayerHand().size() == 0) {
			GameLogic.getInstance().goToNextPlayer();
		}
		
		BaseCard findingDrawCard = null;
		for (BaseCard card : GameLogic.getInstance().getCurrentPlayerHand()) {
			if (Objects.equals(card.getSymbol(), CardSymbol.DRAW_FOUR)) {
				findingDrawCard = card;
				break;
			}
		}
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
