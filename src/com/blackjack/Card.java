package com.blackjack;

public class Card {
	
	 private CardSuits cardsuits;
	 private CardTypes cardtype; 
	 // 1 to 11
	 private int cardvalue;
	 
	 
	 
	 
	 
	public Card(CardSuits cardsuits, CardTypes cardtype, int cardvalue) {
		super();
		this.cardsuits = cardsuits;
		this.cardtype = cardtype;
		this.cardvalue = cardvalue;
	}
	
	
	
	public CardSuits getCardsuits() {
		return cardsuits;
	}
	public void setCardsuits(CardSuits cardsuits) {
		this.cardsuits = cardsuits;
	}
	public CardTypes getCardtype() {
		return cardtype;
	}
	public void setCardtype(CardTypes cardtype) {
		this.cardtype = cardtype;
	}
	public int getCardvalue() {
		return cardvalue;
	}
	public void setCardvalue(int cardvalue) {
		this.cardvalue = cardvalue;
	}



	@Override
	public String toString() {
		return "Card [cardsuits=" + cardsuits + ", cardtype=" + cardtype + ", cardvalue=" + cardvalue + "]";
	}
	 
	 
	 

}
