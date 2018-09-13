package com.comp3004.a1;

import java.util.Random;

public class Deck {
	private String[] suits = {"Hearts", "Spades", "Clubs", "Diamonds"};
	private String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	private Card[] cards;
	private final int DECK_SIZE = 52;
	private int index = 0;
	
	public Deck() {
		cards = new Card[DECK_SIZE];
		generateDeck();
	}

	private void generateDeck() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				cards[j + i * 13] = new Card(ranks[j], suits[i]);
			}
		}
	}
	
    /*
    Name: ShuffleDeck
    Purpose: Shuffle the deck to a random order
     */
    public void shuffleDeck(){
        Random random = new Random();
        int change;
        random.nextInt();

        //Starting at index 0, each card is swapped with a random card at a larger index
        for(int i = 0; i < DECK_SIZE; i++){
            change = i + random.nextInt(DECK_SIZE - i);
            swap(i,change);
        }
    }

    private void swap(int i, int change){
        Card temp = cards[i];
        cards[i] = cards[change];
        cards[change] = temp;
    }
    
    public Card dealCard() {
		if(index == DECK_SIZE) {
			return null;
		}
		
		return cards[index++];
	}
	
}
