package com.skilldistillery.cardgame.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deckOfCards = new ArrayList<>();

	public Deck() {
		Rank[] ranks = Rank.values();
		for (Rank rank : ranks) {
			for (Suit suit : Suit.values()) {
				Card newCard = new Card(suit, rank);
				deckOfCards.add(newCard);
			}

		}
	}
	
	public void checkDeckSize() {
		System.out.println("There are " + deckOfCards.size() + " cards left in the deck.");
	}
	
	public void shuffleDeck(Deck deck) {
		Collections.shuffle(deckOfCards);
	}
	
	public Card dealCard() {
		return deckOfCards.remove(0);
	}

	public List<Card> getDeckOfCards() {
		return deckOfCards;
	}

	public void setDeckOfCards(List<Card> deckOfCards) {
		this.deckOfCards = deckOfCards;
	}

}
