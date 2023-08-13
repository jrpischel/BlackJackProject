package com.skilldistillery.cardgame.blackjack.app;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cardgame.entities.Card;
import com.skilldistillery.cardgame.entities.Hand;

public class BlackJackHand extends Hand {

	public BlackJackHand() {

	}

	public boolean isBlackJack() {
		boolean blackJack = false;
		if (getHandValue() == 21) {
			blackJack = true;
		}
		return blackJack;
	}

	public boolean isBust() {
		boolean busted = false;
		if (getHandValue() > 21) {
			busted = true;
		}
		return busted;
	}

	@Override
	public int getHandValue() {
		List<Card> hand = new ArrayList<>();
		int totalValue = 0;
		for (int i = 0; i < hand.size(); i++) {
			Card c = hand.get(i);
			totalValue += c.getValue();
			hand.add(c);
		}

		return totalValue;
	}

}
