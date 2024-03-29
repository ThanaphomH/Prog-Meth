package test.student;

import logic.card.DrawTwoCard;
import logic.card.NumberCard;
import logic.card.ReverseCard;
import logic.card.SkipCard;
import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkipCardTest {
    SkipCard c1;
    NumberCard c2;
    SkipCard c3;
    SkipCard c4;
    NumberCard c5;

    @BeforeEach
    void setup() {
        c1 = new SkipCard(CardColor.RED);
        c2 = new NumberCard(CardColor.RED, CardSymbol.NINE);
        c3 = new SkipCard(CardColor.GREEN);
        c4 = new SkipCard(CardColor.RED);
        c5 = new NumberCard(CardColor.BLUE, CardSymbol.FIVE);
    }

    @AfterEach
    void tearDown() {
        GameLogic.clearInstance();
    }

    @Test
    void testConstructor() {
        // TODO Implement here
    	SkipCard c6 = new SkipCard(CardColor.BLUE);
    	SkipCard c7 = new SkipCard(CardColor.YELLOW);
    	
    	assertEquals(CardColor.BLUE, c6.getColor());
    	assertEquals(CardSymbol.SKIP , c6.getSymbol());
    	
    	assertEquals(CardColor.RED, c1.getColor());
    	assertEquals(CardSymbol.SKIP , c1.getSymbol());
    	
    	assertEquals(CardColor.GREEN, c3.getColor());
    	assertEquals(CardSymbol.SKIP , c3.getSymbol());
    	
    	assertEquals(CardColor.YELLOW, c7.getColor());
    	assertEquals(CardSymbol.SKIP , c7.getSymbol());

    }

    @Test
    void testToString() {
        assertEquals("RED SKIP", c1.toString());
        assertEquals("GREEN SKIP", c3.toString());
        assertEquals("RED SKIP", c4.toString());
    }

    @Test
    void testCanPlay() {
        // TODO Implement here
    	GameLogic gameInstance = GameLogic.getInstance(1);
    	SkipCard c7 = new SkipCard(CardColor.RED);
    	
    	gameInstance.setTopCard(c2);
    	assertEquals(true, c1.canPlay());
    	
    	gameInstance.setTopCard(c3);
    	assertEquals(true, c1.canPlay());
    	
    	gameInstance.setTopCard(c7);
    	assertEquals(true, c1.canPlay());
    	
    	gameInstance.setTopCard(c5);
    	assertEquals(false, c1.canPlay());

    }

    @Test
    void testPerformEffectNextPlayerHandNonEmpty() {
        GameLogic gameInstance = GameLogic.getInstance(3);
        gameInstance.getPlayerHand(0).add(c1);
        gameInstance.getPlayerHand(1).add(c2);
        gameInstance.getPlayerHand(2).add(c3);

        String message = c1.performEffect();

        assertEquals(1, gameInstance.getCurrentPlayer());
        assertEquals("Skipped player 1", message);
    }

    @Test
    void testPerformEffectNextPlayerHandEmpty() {
        GameLogic gameInstance = GameLogic.getInstance(3);
        gameInstance.getPlayerHand(0).add(c1);
        gameInstance.getPlayerHand(2).add(c3);

        String message = c1.performEffect();

        assertEquals(2, gameInstance.getCurrentPlayer());
        assertEquals("Skipped player 2", message);
    }

    @Test
    void testPlay() {
        GameLogic gameInstance = GameLogic.getInstance(3);
        gameInstance.getPlayerHand(0).add(c1);
        gameInstance.getPlayerHand(1).add(c2);
        gameInstance.getPlayerHand(2).add(c3);

        String message = c1.play();

        assertEquals(c1, gameInstance.getTopCard());
        assertEquals(0, gameInstance.getPlayerHand(0).size());
        assertEquals(1, gameInstance.getCurrentPlayer());
        assertEquals("Skipped player 1", message);
    }

}
