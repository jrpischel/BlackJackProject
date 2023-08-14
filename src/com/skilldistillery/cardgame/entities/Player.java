package com.skilldistillery.cardgame.entities;

import java.util.List;

import com.skilldistillery.cardgame.blackjack.app.BlackJackHand;

public class Player {
	protected Hand playersHand; 
	public int playerValue;
	
	public BlackJackHand createHand(BlackJackHand hand) {
		this.playersHand = hand;
		return hand;
	}
	
	public void checkPlayerTotal(List<Card> playersHand, int playerValue) {
		System.out.print("You Have: ");
		for (Card card : playersHand) {
			System.out.print(card + " ");
		}
		System.out.println(" : Your Total value is : " + playerValue);
	}
	
	
	
	

	

	public void playersChoice() {
		System.out.println("*******************");
		System.out.println("* Players Choices *");
		System.out.println("* 1 - HIT         *");
		System.out.println("* 2 - Stay        *");
		System.out.println("*******************");
	}

}
