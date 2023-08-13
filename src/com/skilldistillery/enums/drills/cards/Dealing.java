package com.skilldistillery.enums.drills.cards;

import java.util.Scanner;

import com.skilldistillery.cardgame.entities.Card;
import com.skilldistillery.cardgame.entities.Deck;

public class Dealing {
	
	public static void main(String[] args) {
		Dealing app = new Dealing();
		app.deal();
	}
	
	public void deal () {
		Deck deck = new Deck();
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("How many cards would you like delt to you?");
		int cards = kb.nextInt();
		kb.nextLine();
		
		deck.shuffleDeck(deck);
		for(int i = 0; i < cards; i ++) {
			Card dealtCard = deck.dealCard();
			System.out.println(dealtCard + " ");
		}
		deck.checkDeckSize();
		
		
		
		
		
		
		kb.close();
	}

}
