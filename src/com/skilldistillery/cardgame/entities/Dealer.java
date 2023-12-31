package com.skilldistillery.cardgame.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cardgame.blackjack.app.BlackJackHand;

public class Dealer extends Player {
	private Deck deck = new Deck();
	public int dealerValue;
	public List<Card> playersHand = new ArrayList<>();
	public List<Card> dealersHand = new ArrayList<>();
	public BlackJackHand bjh = new BlackJackHand();

	public void shuffleCards() {
		System.out.println("Shuffling Cards");
		deck.shuffleDeck(deck);
		System.out.println();
	}

	public void usersTurn(Scanner kb) {
		int choice = 0;

		System.out.println("The cards have been delt and it is your turn the current cards in play are:");
		System.out.println();

		do {

			cardsInPlayOnUsersTurn();
			System.out.println();
			System.out.print("get hand value: ");
			System.out.println(bjh.getHandValue(playersHand));

			if (bjh.isBlackJack(playersHand)) {
				System.out.println("BLACKJACK!!! YOU WIN!!!");
//				again(kb);
			}
			if (bjh.isBust(playersHand)) {
				System.out.println("You BUSTED! Dealer WINS!");
//				again(kb);
			}

			playersChoice();
			choice = kb.nextInt();
			switch (choice) {
			case 1:
				hitPlayer();
				break;
			case 2:
				stay();
				break;
			default:
				System.out.println("Invalid Selection");
			}
		} while (choice != 2);

	}

	private void stay() {
		System.out.println("You stay on: " + playerValue);
	}

	private void hitPlayer() {
		Card dealtCard = deck.dealCard();
		System.out.println("You get a: " + dealtCard);
		playersHand.add(dealtCard);
		playerValue += dealtCard.getValue();
//		bjh.getHandValue(playersHand);
	}

	public void dealersTurn() {
		System.out.println("The Dealer flips over his face down card to reveal a: " + dealersHand.get(0));
		System.out.println(dealersHand + " " + bjh.getHandValue(dealersHand));
		if (bjh.isBlackJack(dealersHand)) {
			System.out.println("Dealer has 21");
		}
		while (bjh.getHandValue(dealersHand) <= 16) {
			if (bjh.isBust(dealersHand)) {
				System.out.println("DEALER BUSTED!!! YOU WIN!!!");
				break;
			}
			System.out.println("Dealer must hit below 17: ");
			hitDealer();
			System.out.println("Dealer stays at: " + bjh.getHandValue(dealersHand));
		}
	}

	public void hitDealer() {
		int dealerValue = 0;
		Card dealtCard = deck.dealCard();
		dealersHand.add(dealtCard);
		System.out.println("Dealer's next card is: " + dealtCard);
		dealerValue += dealtCard.getValue();
		System.out.println(dealersHand + " " + bjh.getHandValue(dealersHand));
	}

	public void cardsInPlayOnUsersTurn() {
		System.out.println("The Dealer is showing a: " + dealersHand.get(1));
		checkPlayerTotal((List<Card>) playersHand, bjh.getHandValue(playersHand));

	}

	public void deal() {

		int numOfPlayers = 2;
		int firstDeal = 2;
		dealerValue = 0;
		playerValue = 0;
		for (int p = 0; p < numOfPlayers; p++) {
			for (int i = 0; i < firstDeal; i++) {
				Card dealtcard = deck.dealCard();
				if (p % 2 == 0) {
					playersHand.add(dealtcard);
					playerValue += (dealtcard).getValue();
				}
				if (p % 2 == 1) {
					dealersHand.add(dealtcard);
					dealerValue += (dealtcard).getValue();
				}
			}

		}

		System.out.println("Your first card is: " + playersHand.get(0));
		System.out.println("The Dealer's first card is delt face down");
		System.out.println("Your second card is: " + playersHand.get(1));
		System.out.println("The Dealer's second card is: " + dealersHand.get(1));
		System.out.println();
	}

	public Deck getDeck() {
		return deck;
	}

	public void decideWinner(Scanner kb) {
		if (bjh.getHandValue(playersHand) > bjh.getHandValue(dealersHand)) {
			System.out.println("You Win!");
		} else if (bjh.getHandValue(playersHand) < bjh.getHandValue(dealersHand)
				&& bjh.getHandValue(dealersHand) > 21) {
			System.out.println("Dealer Bust, You Win!");
		} else if (bjh.getHandValue(playersHand) == bjh.getHandValue(dealersHand)) {
			System.out.println("Its a push, tie game");
		} else {
			System.out.println("Dealer Wins");
		}
//		again(kb);

	}

//	public void again(Scanner kb) {
//		bjh.clear(playersHand);
//		bjh.clear(dealersHand);
//		int playerValue = 0;
//		int dealerValue = 0;
//		System.out.print("there are ");
//		deck.checkDeckSize();
//		System.out.print(" cards left in the deck.");
//		System.out.println("Would you like to play again?");
//
//		int choice = 0;
//		do {
//			playAgainMenu();
//			choice = kb.nextInt();
//
//			switch (choice) {
//			case 1:
//				deal();
//				usersTurn(kb);
//				dealersTurn();
//				decideWinner(kb);
//				break;
//			case 2:
//				System.out.println("Thanks for playing!");
//				;
//				break;
//			default:
//				System.out.println("Invalid Selection");
//			}
//		} while (choice != 2);
//	}
//
//	public void playAgainMenu() {
//		System.out.println("***************");
//		System.out.println("* Play Again? *");
//		System.out.println("* 1 - YES     *");
//		System.out.println("* 2 - NO      *");
//		System.out.println("***************");
//	}
}
