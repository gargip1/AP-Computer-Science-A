/*
*
*   Your CardPlayerLevel.java
*
*/

import java.util.*;

class CardPlayerLevel1 extends CardPlayer {

    public CardPlayerLevel1(){
    }

    public CardPlayerLevel1(String n, int s, ArrayList<Card> h) {
      super(n, s, h);
    }

    public Card chooseCard(ArrayList<Card> played, ArrayList<Card> allPlayed) {
      Random rand = new Random();
    
      
      if (played.isEmpty()) {
        return playCard(rand.nextInt(getHand().size()));
      }

      //getting the current suit
      String currentSuit = played.get(0).getSuit();
      Card queenOfSpades = null;
      //creating arraylists to compare the hand against
      ArrayList<Card> matchingSuit = new ArrayList<>();
      ArrayList<Card> hearts = new ArrayList<>();
      ArrayList<Card> other = new ArrayList<>();

      for (Card card : getHand()) {
        if (card.getSuit().equals(currentSuit)) {
          matchingSuit.add(card);
          //adding card to arraylist if it matches the leading suit
        } else if (card.getSuit().equals("spades") && (card.getSuit().substring(0, 1).equals("q") || card.getSuit().substring(0, 1).equals("q"))) {
          queenOfSpades = card;
        } else if (card.getSuit().equals("hearts")) {
          hearts.add(card);
          //adding card to hearts arraylist if playing suit isn't present
        } else {
          other.add(card);
          //adding card to another arraylist if playing suit isn't present and there are no hearts available
        }
      }

        //now finding which ones to play

        if (!matchingSuit.isEmpty()) {
          //if there is some card matching the leading suit, we're finding the index of where a random one is in hand
          return playCard(getHand().indexOf(matchingSuit.get(rand.nextInt(matchingSuit.size()))));
        }

          //playing queen of spades if possible
        if(queenOfSpades != null) {
          return playCard(getHand().indexOf(queenOfSpades));
        }
          //if there is no card in the leading suit, we play a random card belonging to the hearts suit
        if (!hearts.isEmpty()) {
         Card highHeart = hearts.get(0);
          for (Card heart : hearts) {
            if (heart.getValue() > highHeart.getValue()) {
              highHeart = heart;
            }
          }
          return playCard(getHand().indexOf(highHeart));
        }
        //if there is no card in the leading suit or a hearts card, then we just play some random other card
        return playCard(getHand().indexOf(other.get(rand.nextInt(other.size()))));
        
      
    }
  
  
}

