package com.comp3004.a1;

import java.util.Arrays;
import java.util.Collections;
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
	
    public void shuffleDeck(){
    	Collections.shuffle(Arrays.asList(cards));
    }
    
    public Card dealCard() {
		if(index == DECK_SIZE) {
			return null;
		}
		
		return cards[index++];
	}
	
}
