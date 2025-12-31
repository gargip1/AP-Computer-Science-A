import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Deck {
  
  public static final String[] NAMES = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
  public static final String[] SUITS = {"clubs", "spades", "hearts", "diamonds"};
  public static final int[] RANKS = {2,3,4,5,6,7,8,9,10,11,12,13,14};
  //instance variable
  private ArrayList<Card> deck;

  public Deck() {
    deck = new ArrayList<>();
    initializeDeck();
  }

  public void initializeDeck() {
    deck.clear();
    for (int i = 0; i < SUITS.length; i++) {
      for (int j = 0; j < NAMES.length; j++) {
        deck.add(new Card(NAMES[j], SUITS[i], RANKS[j]));
      }
    }
  }

  public void addCard(Card c) {
    deck.add(c);
  }
    
  public ArrayList<Card> getDeck() {
    return deck;
  }

  public void setDeck(ArrayList<Card> d) {
    deck = d;
  }

  public Card getCard(int idx) {
    return deck.get(idx);
  }

  public Card dealTopCard() {
  
    return deck.remove(0);
  }

  public void shuffle2() {
    if (deck.size() < 3) return;
    Random rand = new Random();
    int num = rand.nextInt(9) + 2;
    num = Math.min(num, deck.size());
 
    //taking the cards to move
    ArrayList<Card> cut = new ArrayList<>(deck.subList(0, num));
    //removing the copied cards
    deck.subList(0, num).clear();
    if (deck.size() == 0) {
      deck.addAll(cut);
    }
  
    //inserting in a new location
    int insert = rand.nextInt(deck.size() + 1);
    deck.addAll(insert, cut);
  }
    
    public String toString() {
      String ret = "";
      if (deck.isEmpty()) {
        ret = "No cards in the deck!";
      }
      else {
        for (int i = 0; i < deck.size(); i++) {
          ret += (deck.get(i)).toString();
        }
      }
      return ret;
    }

  public void shuffle() {
    Collections.shuffle(deck);
  }
  
}
