/**
 * TODO: Implement the `Card` class which represents a playing card.
 * The card has a name (e.g., Ace, King), a suit (e.g., hearts, spades), 
 * and a value (e.g., 0-12 for ranks). 
 * It also provides methods to compare cards, calculate their rank in a deck, and more.
 * 
 * TODO: Add meaningful test cases for each method in this class.
 */
public class Card implements Comparable<Object> {
  private String name;
  private String suit;
  private int value;
/**
 * TODO: Create a default constructor that initializes the card 
 * to default values for name, suit, and value.
 */
  public Card() {
    name = "default";
    suit = "default";
    value = 0;
  }
/**
 * TODO: Create a parameterized constructor that initializes the card 
 * with the given name, suit, and value.
 * 
 * @param name The name of the card (e.g., "Ace", "King").
 * @param suit The suit of the card (e.g., "hearts", "clubs").
 * @param value The value of the card (e.g., 0-12 for ranks).
 */
  public Card(String n, String s, int v) {
    name = n;
    suit = s;
    value = v;
  }
/**
 * TODO: Write a getter method to retrieve the name of the card.
 * 
 * @return The name of the card.
 */
  public String getName() {
    return name;
  }
/**
 * TODO: Write a getter method to retrieve the suit of the card.
 * 
 * @return The suit of the card.
 */
  public String getSuit() {
    return suit;
  }
/**
 * TODO: Write a getter method to retrieve the value of the card.
 * 
 * @return The value of the card.
 */
  public int getValue() {
    return value;
  }
/**
 * TODO: Write a setter method to update the name of the card.
 * 
 * @param name The new name for the card.
 */
  public void setName(String n) {
    name = n;
  }
/**
 * TODO: Write a setter method to update the suit of the card.
 * 
 * @param suit The new suit for the card.
 */
  public void setSuit(String s) {
    suit = s;
  }
/**
 * TODO: Write a setter method to update the value of the card.
 * 
 * @param value The new value for the card.
 */
  public void setValue(int v) {
    value = v;
  }
/**
 * TODO: Implement the `sortRank` method to calculate a unique rank for each card
 * in a deck based on its suit and value. 
 * (E.g., clubs are ranked highest, followed by spades, hearts, and diamonds).
 * 
 * @return An integer representing the card's rank in a sorted deck.
 */
  public int sortRank() {
    int r = 0;
    switch (suit) {
      case "diamonds" :
        r = value;
        break;
      case "hearts" :
        r = value + 13;
        break;
      case "spades" :
        r = value + 13 + 13;
        break;
      case "clubs" :
        r = value + 13 + 13 + 13;
        break;
    }
    return r;
  }
/**
 * TODO: Override the `compareTo` method to allow comparing two cards 
 * based on their sortRank values.
 * 
 * @param obj The object to compare this card against.
 * @return -1 if this card is ranked lower, 1 if ranked higher, and 0 if equal.
 */
  public int compareTo(Object obj) {
    Card c = (Card) obj;
    if (sortRank() < c.sortRank()) {
      return -1;
    }
    else if (sortRank() == c.sortRank()) {
      return 0;
    }
    else {
      return 1;
    }
  }
/**
 * TODO: Override the `equals` method to compare two cards 
 * for equality based on their suit and value.
 * 
 * @param obj The object to compare this card against.
 * @return True if the cards have the same suit and value, otherwise false.
 */
  public boolean equals(Object obj) {
    Card c = (Card) obj;
    if (suit.equals(c.getSuit()) && value == c.getValue()) {
      return true;
    }
    return false;
    
  }
/**
 * TODO: Override the `toString` method to return a string representation of the card.
 * Format the string as the first letter of the suit followed by the name and value 
 * (e.g., "H2(1)" for the 2 of hearts with a value of 1).
 * 
 * @return A string representation of the card.
 */
  public String toString() {
    String c = suit.substring(0, 1);
    return c +  name + "(" + value + ")";
  }
}
