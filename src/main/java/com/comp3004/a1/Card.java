package com.comp3004.a1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Card {
	private ArrayList<String> cardNumberRanks = new ArrayList<>(Arrays.asList("Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"));
	
	private String faceValueStr;
	private String suit;
	private String shortName;
	private int trueValue;
	
	public Card(String faceValue, String suit) {
		this.faceValueStr = faceValue;
		this.suit = suit;
		this.trueValue = getTrueValue(faceValue);
		shortName = suit.substring(0, 1) + getTrueValue(faceValueStr);
	}
	
	public Card(String shortName) {
		this.shortName = shortName;
		this.suit = getSuitFromSingleCharacter(shortName.substring(0, 1));
		this.faceValueStr = getFaceValueFromSingleCharacter(shortName.substring(1));
		this.trueValue = getTrueValue(faceValueStr);
	}
	
	private String getSuitFromSingleCharacter(String subString) {
		switch (subString) {
		case "H":
			return "Hearts";
		case "D":
			return "Diamonds";
		case "S":
			return "Spades";
		case "C":
			return "Clubs";
		}
		return null;
	}

	private String getFaceValueFromSingleCharacter(String subString) {
		switch (subString) {
		case "A":
			return "Ace";
		case "K":
			return "King";
		case "Q":
			return "Queen";
		case "J":
			return "Jack";
		default:
			return cardNumberRanks.get(Integer.parseInt(subString) - 2);
		}
	}

	private int getTrueValue(String faceValue) {
		if(faceValue.equals("Ace")) {
			return 11;
		} else if (faceValue.equals("King") || faceValue.equals("Queen") || faceValue.equals("Jack")) {
			return 10;
		} else {
			return getIntValueOfCard(faceValue);
		}
	}
	
	private int getIntValueOfCard(String faceValue) {
		return cardNumberRanks.indexOf(faceValue) + 2;
		
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
		return shortName;
	}
	
	public boolean switchAceValue() {
		if(faceValueStr.equals("Ace")) {
			trueValue = 1;
			return true;
		} 
		
		return false;
	}
	
	
	
	
}
