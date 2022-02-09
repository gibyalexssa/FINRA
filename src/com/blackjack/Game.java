package com.blackjack;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//main class 
public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("./blackjack " + GameParms.MAXPAYERS);	
		//initialize deck
		Deck.loadDeck();
		System.out.println("Starting game with " + GameParms.MAXPAYERS + " players");	
		System.out.println("Shuffling..");
		Deck.shuffle();		
		List<Player> players = addPlayers();
		
		
		
		
		//Round 1 dealing first card each		
		for (Player player : players) {		
			
			player.addCard(Deck.dealCard());					
						
			if(player.getName()=="Computer") {
				System.out.println("Dealing to player " + player.getName() + " card:face down");
			}
			else {
			   System.out.println("Dealing to player " + player.getName() + " card:" + getCardAttributes(player.getCards()));
			}
		}
		
		
		String playerresponse="hit";
		 boolean exitPlayer=false;
		 
		 
		 for (Player player : players) {		
			  do {
				    exitPlayer=false;
				    Card dealcard = Deck.dealCard();
            	   	
				    if (dealcard.getCardtype()==CardTypes.Ace) {
				    	if (GameParms.VALUELIMIT-player.getTotalcardvalue() > 11) {
				    		dealcard.setCardvalue(11);
				    	}
				    }

				    player.addCard(dealcard);
            	    
            	  //  Console console = System.console();
                    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Dealing to player " + player.getName() + " card:" + getCardAttributes(player.getCards()));
                    
                    player.setTotalcardvalue(player.getCards().stream().mapToInt(x->x.getCardvalue()).sum());
                    if (player.getTotalcardvalue() > GameParms.VALUELIMIT) {
                    	player.setStatus("Busted");
                    	exitPlayer=true;
                    	System.out.print("Busted over 21");
                    }
                    try {
                    	if(player.getName()=="Computer") {
                    		playerresponse = computerStrategy(player.getTotalcardvalue());
                    		System.out.println(" Dealer " + playerresponse);                    		
                    	}
                    	else {
    						playerresponse =  bufferRead.readLine();         						
                    	}
                    	
                    	 if (playerresponse.compareTo("stand")==0) {
		                    	exitPlayer=true;
	                    }
						 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}                                                       
                   
                   
                     
					 
			 }  while( !exitPlayer);

			}	
		
         int dealerscore= players.stream().filter(p->p.getName().equals("Computer")).collect(Collectors.toList()).get(0).getTotalcardvalue();
        
		 //scoring logic
		 for (Player player : players) {
		      if (player.getName()!= "Computer")	{
		    	  if (player.getStatus()=="Busted") {
		    		  
		    		  System.out.println("Scoring " + player.getName() + " busted "
		              +  ". dealer has " + dealerscore + ", " +  "dealer wins" );
		    	  }
		    	  else {
		    		  if((GameParms.VALUELIMIT - player.getTotalcardvalue() < (GameParms.VALUELIMIT - dealerscore))){
			    		  System.out.println("Scoring " + player.getName() + " has " + player.getTotalcardvalue() 
			    				              +  ". dealer has " + dealerscore + ", " + player.getName() + " wins" );
			    	  }
			    	  else {
			    		  System.out.println("Scoring " + player.getName() + " has " + player.getTotalcardvalue() 
			              +  ". dealer has " + dealerscore + ", " +  "dealer wins" );
			    	  }
		    		  
		    	  }
		    	
		      }
		 }
	}
	


   // add the players to game
	
	public static List<Player> addPlayers(){
		
		List<Player> players = new ArrayList<>();
		for(int i=0; i < GameParms.MAXPAYERS ; i++) {
			players.add(new Player("Player " + (i+1), "active"));
		}
		
		players.add(new Player("Computer","active"));
		
		return players;
	}
	
	public static String getCardAttributes(List<Card> cards) {
		
		String cardattr= "";
		
		for (Card card : cards) {
			 //  System.out.println(card);
			   if (card.getCardtype()==CardTypes.Ace ||  
		      		   card.getCardtype()==CardTypes.Queen ||
					   card.getCardtype()==CardTypes.Jack ||
					   card.getCardtype()==CardTypes.King 
					   ) { 
				   cardattr += card.getCardtype().toString() + ' ' + card.getCardsuits().toString();			
				   }
			   else {
					String  numofType = "";
					
					switch (card.getCardtype()) {
					case Ten:{
						   numofType="10"; 
						   break;
		    			}
					case Nine:{
						   numofType="9"; 
						   break;
		 			}
					case Eight:{
						   numofType="8"; 
						   break;
		 			}
					case Seven:{
						   numofType="7"; 
						   break;
		 			}
					case Six:{
						   numofType="6"; 
						   break;
		 			}
					case Five:{
						   numofType="5"; 
						   break;
		 			}
					case Four:{
						   numofType="4"; 
						   break;
		 			}
					case Three:{
						   numofType="3"; 
						   break;
		 			}
					case Two:{
						   numofType="2"; 
						   break;
					}
					
					
					}
					
					cardattr +=  numofType  + ' ' + card.getCardsuits().toString();
				   
			   }		
					 
			   if (cards.size()>1) {
				   cardattr += " , ";   
			   }
			   
			   
		}
		 
		if (cards.size()>1) {
			   cardattr += ". Hit or Stand? ";   
		   }
		 
		   
		return cardattr;
		
	}
	 
	public static String computerStrategy(int totalvalue) {
		
		if ((GameParms.VALUELIMIT - totalvalue) > 5 ) {
			return "hit";
		}
		else {
			return "stand";
		}
	}
	
}
