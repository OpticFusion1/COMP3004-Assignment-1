package com.comp3004.a1;

import java.util.HashMap;
import java.util.Map;

public class Card {
	private enum cardRanks {TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN};
	private String faceValueStr;
	private String suit;
	private int trueValue;
	
	public Card(String faceValue, String suit) {
		this.faceValueStr = faceValue;
		this.suit = suit;
		this.trueValue = findTrueValue(faceValue);
	}
	
	private int findTrueValue(String faceValue) {
		if(faceValue.equals("Ace")) {
			return 11;
		} else if (faceValue.equals("King") || faceValue.equals("Queen") || faceValue.equals("Jack")) {
			return 10;
		} else {
			return getIntValueOfCard(faceValue);
		}
	}
	
	private int getIntValueOfCard(String faceValue) {
		return cardRanks.valueOf(faceValue.toUpperCase()).ordinal() + 2;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getValue() {
		return trueValue;
	}
	
	public String getFullName() {
		return faceValueStr + " of " + suit;
	}
	
	public String getShortName() {
		return suit.substring(0, 1) + getIntValueOfCard(faceValueStr);
	}
	
	public boolean switchAceValue() {
		if(faceValueStr.equals("Ace")) {
			trueValue = 1;
			return true;
		} 
		
		return false;
	}
	
	
	
	
}
