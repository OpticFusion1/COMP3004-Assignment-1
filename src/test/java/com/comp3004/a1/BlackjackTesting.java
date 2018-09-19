package com.comp3004.a1;

import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

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
	
	public void testSingleStringConstructor() {
		Card card1 = new Card("King", "Spades");
		Card card2 = new Card("Nine", "Hearts");
		Card card3 = new Card("Ace", "Diamonds");
		Card card4 = new Card("Queen", "Clubs");
		Card card5 = new Card("Jack", "Clubs");
		Card card6 = new Card("Three", "Diamonds");
		
		assertEquals("SK", card1.getShortName());
		assertEquals("King of Spades", card1.getFullName());
		assertEquals("H9", card2.getShortName());
		assertEquals("Nine of Hearts", card2.getFullName());
		assertEquals("DA", card3.getShortName());
		assertEquals("Ace of Diamonds", card3.getFullName());
		assertEquals("CQ", card4.getShortName());
		assertEquals("Queen of Clubs", card4.getFullName());
		assertEquals("CJ", card5.getShortName());
		assertEquals("Jack of Clubs", card5.getFullName());
		assertEquals("D3", card6.getShortName());
		assertEquals("Three of Diamonds", card6.getFullName());
		
	}
	
	public void testDoubleStringConstructor() {
		Card card1 = new Card("SK");
		Card card2 = new Card("H9");
		Card card3 = new Card("DA");
		Card card4 = new Card("CQ");
		Card card5 = new Card("CJ");
		Card card6 = new Card("D3");
		
		assertEquals("SK", card1.getShortName());
		assertEquals("King of Spades", card1.getFullName());
		assertEquals("H9", card2.getShortName());
		assertEquals("Nine of Hearts", card2.getFullName());
		assertEquals("DA", card3.getShortName());
		assertEquals("Ace of Diamonds", card3.getFullName());
		assertEquals("CQ", card4.getShortName());
		assertEquals("Queen of Clubs", card4.getFullName());
		assertEquals("CJ", card5.getShortName());
		assertEquals("Jack of Clubs", card5.getFullName());
		assertEquals("D3", card6.getShortName());
		assertEquals("Three of Diamonds", card6.getFullName());
		
	}
	
	public void testPlayerCardTotal() {
		Deck deck = new Deck();
		Player player = new Player();
		Card receivedCard;
		
		deck.shuffleDeck();
		receivedCard= deck.dealCard();
		player.receiveCard(receivedCard);
		
		assertEquals(receivedCard.getValue(), player.getTotal());
		
	}
	
	public void testPlayerOneAce() {
		Player player = new Player();
		
		player.receiveCard(new Card("DK"));
		player.receiveCard(new Card("CQ"));
		//receiveCard returns true when the player has not busted. False if they have
		assertEquals(true, player.receiveCard(new Card("Ace", "Spades")));
		assertEquals(21, player.getTotal());
	}
	
	public void testPlayerBust() {
		Player player = new Player();
		
		player.receiveCard(new Card("DK"));
		player.receiveCard(new Card("CQ"));
		assertEquals(false, player.receiveCard(new Card("CJ")));
	}
	
	public void testPlayerTwoAces() {
		Player player = new Player();
		
		player.receiveCard(new Card("SA"));
		player.receiveCard(new Card("CA"));
		assertEquals(12, player.getTotal());
	}
	
	public void testFileInput() throws IOException {
		Game game = new Game();
		String testDirectory = "src/test/java/com/comp3004/a1/";
		
		assertEquals("Player Wins", game.file(testDirectory + "FilePlayerWinNormal.txt"));
		assertEquals("Dealer Wins", game.file(testDirectory + "FileDealerWinNormal.txt"));
		assertEquals("Player Wins", game.file(testDirectory + "FilePlayerWinDealerBust.txt"));
		assertEquals("Dealer Wins", game.file(testDirectory + "FileDealerWinPlayerBust.txt"));
		assertEquals("Player Wins", game.file(testDirectory + "FilePlayerWinBlackjack.txt"));
		assertEquals("Dealer Wins", game.file(testDirectory + "FileDealerWinBlackjack.txt"));
		assertEquals("Dealer Wins", game.file(testDirectory + "FileDealerWinBlackjackTie.txt"));
		assertEquals("Dealer Wins", game.file(testDirectory + "FileDealerWinTie.txt"));
		assertEquals("Invalid file input", game.file(testDirectory + "FileInvalidInput.txt"));
		assertEquals("Invalid file input", game.file(testDirectory + "FileInvalidCardTypes.txt"));
		assertEquals("Invalid card sequence", game.file(testDirectory + "FileInvalidSequence.txt"));
		assertEquals("Invalid file input", game.file(testDirectory + "FileEmpty.txt"));
		assertEquals("Invalid file input", game.file(testDirectory + "FileLessThanFourCards.txt"));
		assertEquals("Card has already been played", game.file(testDirectory + "FileDuplicateCard.txt"));
		
	}

}
