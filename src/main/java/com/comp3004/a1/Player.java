package com.comp3004.a1;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int index = 0;
	private int aceCount = 0;
	private int total = 0;
	
	public Player() {	}
	
	public int getTotal() {
		return total;
	}
	
	public boolean receiveCard(Card card) {
		cards.add(card);
		total += card.getValue();
		
		if(card.getFaceValue().equals("Ace")) {
			aceCount++;
		}
		
		if(total > 21 && aceCount > 0) {
			switchAce();
		} else if (total > 21) {
			return false;
		}
		
		index++;
		return true;
	}

	private void switchAce() {
		aceCount--;
		total -= 10;
		
		for(int i = 0; i <= index; i++) {
			if(cards.get(i).getValue() == 11) {
				cards.get(i).switchAceValue();
			}
		}
		
	}
}
