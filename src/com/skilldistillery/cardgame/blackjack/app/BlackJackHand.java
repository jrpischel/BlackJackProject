package com.skilldistillery.cardgame.blackjack.app;

import java.util.List;

import com.skilldistillery.cardgame.entities.Card;
import com.skilldistillery.cardgame.entities.Hand;

public class BlackJackHand extends Hand {

	public BlackJackHand() {

	}

	public boolean isBlackJack(List<Card> hand) {
		boolean blackJack = false;
		if (getHandValue(hand) == 21) {
			blackJack = true;
		}
		return blackJack;
	}

	public boolean isBust(List<Card> hand) {
		boolean busted = false;
		if (getHandValue(hand) > 21) {
			busted = true;
		}
		return busted;
	}

	public int getHandValue(List<Card> hand) {
		int handValue = 0;
		for (Card cards : hand) {
			int cardValue = cards.getValue();
			handValue = handValue + cardValue;
		}

		return handValue;

	}

	@Override
	public int getHandValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
