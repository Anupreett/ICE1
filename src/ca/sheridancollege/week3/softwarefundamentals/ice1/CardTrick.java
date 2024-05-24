/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

import java.util.Scanner;
import java.util.Random;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author dancye
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();

        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); 
            c.setSuit(Card.SUITS[random.nextInt(4)]); 
            magicHand[i] = c;
        }

        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card (any card):");
        System.out.print("Enter card value (1 for Ace, 11 for Jack, 12 for Queen, 13 for King): ");
        int userValue = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter card suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.nextLine();

   
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        
        boolean cardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                cardFound = true;
                break;
            }
        }

        
        if (cardFound) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }
    }
}
