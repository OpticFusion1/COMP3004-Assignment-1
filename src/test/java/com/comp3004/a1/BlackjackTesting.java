package com.comp3004.a1;

import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

public class BlackjackTesting extends TestCase{
	public void testCardConstructor() {
		Card card = new Card("Two", "Spades");
		
		assertEquals("Spades", card.getSuit());
		assertEquals(2, card.getValue());
		assertEquals("Two of Spades", card.getFullName());
		assertEquals("S2", card.getShortName());
	}
	
	public void testTenValue() {
		Card card = new Card("Ten", "Hearts");
		assertEquals(10, card.getValue());
	}
	
	public void testKingValue() {
		Card card = new Card("King", "Hearts");
		assertEquals(10, card.getValue());
	}
	
	public void testJackValue() {
		Card card = new Card("Jack", "Clubs");
		assertEquals(10, card.getValue());
	}
	
	public void testQueenValue() {
		Card card = new Card("Queen", "Diamonds");
		assertEquals(10, card.getValue());
	}
	
	public void testAceValue() {
		Card card = new Card("Ace", "Spades");
		assertEquals(11, card.getValue());
		card.switchAceValue();
		assertEquals(1, card.getValue());
	}
	
	public void testSwitchValueOnNonAceCard() {
		Card card = new Card("Three", "Spades");
		assertEquals(false, card.switchAceValue());
	}
	
	public void testDealCards() {
		Deck deck = new Deck();
		deck.shuffleDeck();
		
		for(int i = 0; i < 52; i++) {
			assertNotNull(deck.dealCard());
		}
		
		assertNull(deck.dealCard());
	}
	
	public void testShuffle() {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		deck1.shuffleDeck();
		
		int index = 1;
		String card1 = deck1.dealCard().getShortName();
		String card2 = deck2.dealCard().getShortName();
		
		while(card1.equals(card2)) {
			index++;
			card1 = deck1.dealCard().getShortName();
			card2 = deck2.dealCard().getShortName();
		}
		
		assertNotEquals(card1, card2);
	}

}
