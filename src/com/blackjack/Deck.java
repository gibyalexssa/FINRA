package com.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private static List<Card> cards= new ArrayList<>();;

	public static List<Card> getCards() {
		return cards;
	}

	public static void setCards(List<Card> cards) {
		Deck.cards = cards;
	}
	
	public static void shuffle() {
		Collections.shuffle(cards);
	}
	
	//initialize deck
	public static void loadDeck(){
		
		int value = 0;
		//load the deck with cards
		for(CardSuits suit :CardSuits.values()) {
			
			for(CardTypes type : CardTypes.values()) {
				 switch(type) {
					 case King:
					 case Queen:	
					 case Jack: 
					 case Ten:{
						 value = 10;
						 break;
					 }
					 case Nine:{
						 value = 9;
						 break;
					 }
					 case Eight: {
						 value = 8;
						 break;
					 }
					 case Seven: {
						 value = 7;
						 break;
					 }
					 case Six: {
						 value = 6;
						 break;
					 }
					 case Five: {
						 value = 5;
						 break;
					 }
					 case Four: {
						 value = 4;
						 break;
					 }
					 case Three: {
						 value = 3;
						 break;
					 }
					 case Two: {
						 value = 2;
						 break;
					 }
					 case Ace:{
						 //initially assign 1
						 	value = 1;
							 break;
						 }
			  
				 }
				 		 
				 			 
				 cards.add(new Card(suit,type, value));
			 
				 }
			 
				
			}
		
		
 }		
		
	 
 



	
	//this methods deals a card and removes it from the deck
	public static Card dealCard() {
		
		//select a card randomly from deck
		int randomIndex = (int) (Math.random() * (cards.size()));		
		Card carddealt= cards.get(randomIndex);		
		//remove the cards from the deck after dealing
	    cards.remove(randomIndex);	    
	    return carddealt;
				
	}

}
