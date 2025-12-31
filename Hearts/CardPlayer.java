import java.util.*;    // required to use ArrayList

public class CardPlayer extends Player {
    private ArrayList<Card> hand;
    private ArrayList<Card> takenCards;

    public CardPlayer(){
      super("", 0);
      takenCards = new ArrayList<>();
    }
  
    public CardPlayer(String name, int score, ArrayList<Card> h) {
      super(name, score);
      this.hand = h;
      takenCards = new ArrayList<>();
    }

  public void addScore(int s) {
    super.updateScore(s);
  }

    public ArrayList<Card> getHand() {
      return this.hand;
    }

    public void setHand(ArrayList<Card> h) {
      this.hand = h;
    }

    public ArrayList<Card> getTakenCards() {
      return this.takenCards;
    }

    public void setTakenCards(ArrayList<Card> c) {
      this.takenCards = c;
    }

    public void addTakenCards(ArrayList<Card> c) {
      hand.addAll(c);
    }

    public void addCard(Card card) {
      hand.add(card);
    }

    public Card playCard(int index) {
      Card c = hand.get(index);
      hand.remove(index);
      return c;
    }

    public Card chooseCard(ArrayList<Card> played, ArrayList<Card> allPlayed) {
      Random rand = new Random();
      for (int i = 0; i < hand.size(); i++) {
        if (hand.get(i).getSuit().equals("clubs") && hand.get(i).getValue() == 2) {
          return playCard(i);
        }
      }
      
      if (played.isEmpty()) {
        return playCard(rand.nextInt(hand.size()));
      }

      
      if (allPlayed.isEmpty()) {
        return playCard(rand.nextInt(hand.size()));
      }
      //getting the current suit
      String currentSuit = played.get(0).getSuit();
      //creating arraylists to compare the hand against
      ArrayList<Card> matchingSuit = new ArrayList<>();
      ArrayList<Card> hearts = new ArrayList<>();
      ArrayList<Card> other = new ArrayList<>();

      for (Card card : hand) {
        if (card.getSuit().equals(currentSuit)) {
          matchingSuit.add(card);
          //adding card to arraylist if it matches the leading suit
        } else if (card.getSuit() == "hearts") {
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
          return playCard(hand.indexOf(matchingSuit.get(rand.nextInt(matchingSuit.size()))));
        }
          //if there is no card in the leading suit, we play a random card belonging to the hearts suit
        if (!hearts.isEmpty()) {
          return playCard(hand.indexOf(hearts.get(rand.nextInt(hearts.size()))));
        }
        //if there is no card in the leading suit or a hearts card, then we just play some random other card
        return playCard(hand.indexOf(other.get(rand.nextInt(other.size()))));
        
      
    }

      public String toString() {
        Collections.sort(hand);
        return getName() + " (" + getScore() + ") " + hand;
      }
    }
  

