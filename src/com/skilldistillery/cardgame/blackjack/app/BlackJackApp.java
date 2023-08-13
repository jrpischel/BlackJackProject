package com.skilldistillery.cardgame.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.entities.Dealer;
import com.skilldistillery.cardgame.entities.Player;

public class BlackJackApp {
	public Dealer dealer = new Dealer();
	public Player player = new Player();
	
	
	public static void main(String[] args) {
		BlackJackApp letsPlayAGame = new BlackJackApp();
		letsPlayAGame.prepareGame();
		letsPlayAGame.play();
	}
	
	public void prepareGame() {
		dealer.shuffleCards();
		
	}

	public void play() {
		Scanner kb = new Scanner(System.in);
		player.createHand(new BlackJackHand());
		dealer.createHand(new BlackJackHand());

		dealer.deal();
		dealer.usersTurn(kb);
		dealer.dealersTurn();
		dealer.decideWinner(kb);

		kb.close();

	}

}
