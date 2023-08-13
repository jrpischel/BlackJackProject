package com.skilldistillery.cardgame.entities;

import java.util.Objects;

public class Card {

	private Suit cardSuit;
	private Rank cardRank;

	public Card(Suit cardSuit, Rank cardRank) {
		super();
		this.cardSuit = cardSuit;
		this.cardRank = cardRank;
	}
	
	

	public int getValue() {
		return cardRank.getValue();
	}

	@Override
	public String toString() {
		return cardRank + " of " + cardSuit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardRank, cardSuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return cardRank == other.cardRank && cardSuit == other.cardSuit;
	}

}
