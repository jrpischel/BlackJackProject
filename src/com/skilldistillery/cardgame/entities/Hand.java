package com.skilldistillery.cardgame.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	
	
	public Hand() {
		
	}
	
	public List<Card> cards() {
		
		List<Card> cards = new ArrayList<>();
		
		return cards;
		
	}
 	
	public void addCard (Card card) {
		cards().add(card);
	
		
	}
	
	public void clear() {
		cards().clear();
		
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return cards().toString();
	}


	
	
	
}

