package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
	private List<Card> cards= new ArrayList<>();	
	//Status in game - busted , active , winner , loser
	private String status;
	private int totalcardvalue=0;
	
	public Player(String name, String status) {
		super();
		this.name = name;
		//this.cards = cards;
		this.status = status;
	}
	
	
	


	public int getTotalcardvalue() {
		return totalcardvalue;
	}


	public void setTotalcardvalue(int totalcardvalue) {
		this.totalcardvalue = totalcardvalue;
	}



	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}	
	 
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	

}
