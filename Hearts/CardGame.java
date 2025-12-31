import java.util.*;
import java.io.*;

public class CardGame {
  private Deck deckOfCards;
  private String nameOfGame;
  private ArrayList<CardPlayer> players;
  private int numberOfPlayers;
  private int currentPlayer;
//initializing constructor
  public CardGame(String nameOfGame, int numberOfPlayers, String[] playerNames, int currentPlayerIndex) {
    deckOfCards = new Deck();
    this.nameOfGame = nameOfGame;
    this.numberOfPlayers = numberOfPlayers;
    this.currentPlayer = currentPlayer;
    this.players = new ArrayList<>();
    for (int i = 0; i < numberOfPlayers; i++) {
      this.players.add(new CardPlayer(playerNames[i], 0, new ArrayList<Card>()));
    }
    System.out.println(">>> Printed in Constructor");
    for (int i = 0; i < numberOfPlayers; i++) {
      System.out.println("Player " + playerNames[i] + " is a CardPlayer");
    }
    
  }
//getPlayer method used in main
  public CardPlayer getPlayer(int i) {
      return players.get(i);
  }
//getters + setters
  public Deck getDeckOfCards() { return deckOfCards; }
  public void setDeckofCards(Deck deckOfCards) { this.deckOfCards = deckOfCards; }

  public String getNameOfGame() { return nameOfGame; }
  public void setNameOfGame(String nameOfGame) {this.nameOfGame = nameOfGame; }

  public ArrayList<CardPlayer> getPlayers() {
    return players; }
  public void setPlayers(ArrayList<CardPlayer> players) { this.players = players; }

  public int getNumberOfPlayers() { return numberOfPlayers; }
  public void setNumberOfPlayers(int numberOfPlayers) { this.numberOfPlayers = numberOfPlayers; }

  public int getCurrentPlayer() { return currentPlayer; }
  public void setCurrentPlayer(int currentPlayer) { this.currentPlayer = currentPlayer; }

  //deal
  public void deal(int numCard, int playerIndex) {
    if (playerIndex >= players.size()) {
      System.out.println("INVALID");
    return;
  }
    //dealing the card to the player in playerIndex
    for (int i = 0; i < numCard; i++) {
players.get(playerIndex).addCard(deckOfCards.dealTopCard());
  }
}

  //setting the player with 2 of clubs to the lead
  public void setCurrentPlayerToStartingPlayer() {
   // incrementing through the loop and seeing if a player has the 2 of cards. if so, we're returning that
    for (CardPlayer player : players) {
      player.setTakenCards(new ArrayList<Card>());
    }
    for (int i = 0; i < players.size(); i++) {
      if (players.get(i).getHand().contains(new Card("2", "clubs", 2))) {
        currentPlayer = i;
      }
    }
}

  //finding who has the highest valued card that is in the leading suit
  public int takesRound(int playerThatLed, ArrayList<Card> cardsPlayedThisRound) {
    //finding the suit of the first card in the cards played this round
    ArrayList<Card> allSuits = new ArrayList<Card>();
    String target = cardsPlayedThisRound.get(0).getSuit();
    for (Card card : cardsPlayedThisRound) {
      if (target.equals(card.getSuit())) {
        allSuits.add(card);
      }
    }
    //sorting the arraylist containing all of the cards with the same suit and finding the highest valued one
    Collections.sort(allSuits);
    Card high = allSuits.get(allSuits.size() - 1);
    return (playerThatLed + cardsPlayedThisRound.indexOf(high)) % 4;
  }

  //finding the score for each player in the game
  public int score4Game(ArrayList<Card> cards) {
    int score = 0;
    //if a card has the suit hearts then we add to the players score
    for (Card card : cards) {
      if (card.getSuit().equals("hearts")) {
        score++;
      }
      //if a card is the queen of hearts then we add 13 to the players score
      if (card.equals(new Card("Queen", "clubs", 12))) {
        score += 13;
      }
    }
      return score;
  }
//finding the next player to play
  public ArrayList<Card> round(ArrayList<Card> prev) {
    ArrayList<Card> round = new ArrayList<Card>();
    int player = currentPlayer;
    for (int i = 0; i < Math.min(4, players.size()) - 1; i++) {
      round.add(players.get(player % numberOfPlayers).chooseCard(round, prev));
        player += 1;
        //System.out.println("Third loop call");
    }
    return round;
  }
  
  //using all the methods to play the game
  public void playGame() {
    setCurrentPlayerToStartingPlayer();
   ArrayList<Card> game = new ArrayList<Card>();
    for (int i = 0; i < 13; i++) {
      ArrayList<Card> round = round(game);
      //System.out.println("second loop call");
      //System.out.println(round);
      //getting the player to go next
      currentPlayer = takesRound(currentPlayer, round);
      game.addAll(round);
      ArrayList<Card> takenCards = new ArrayList<Card>();
      takenCards.addAll(players.get(currentPlayer).getTakenCards());
      takenCards.addAll(round);
      players.get(currentPlayer).setTakenCards(takenCards); //updating the te
      System.out.print("\n>>> playGame() ");
      for (int j = 0; j < players.size(); j++) {
        System.out.print("Player" + j + "(" + players.get(j).getScore() + ") ");
      }
      
    }
    
    
    for (CardPlayer player : players) {
      player.updateScore(score4Game(player.getTakenCards()));
    }
    
  }
   
  static int errors;
  //copy-pasted from the lab document
  public void checkRound(ArrayList<Card> round, int startingPlayer) {
    if (errors < 5) {
  // System.out.print(startingPlayer + " ");
   // Establish what the suit to match is
   String roundSuit = round.get(0).getSuit(); 
   // For all other players
   for (int i = 1; i < round.size(); i++) { 
      // If their card doesn't match suit, check to see if they're incorrect
      if (!round.get(i).getSuit().equals(roundSuit)) { 
         CardPlayer player = players.get((i + startingPlayer) % players.size());
         // Go through their cards
         for (Card c : player.getHand()) { 
            // If incorrect, print out offending card and that they're incorrect
            if (c.getSuit().equals(roundSuit)) { 
               System.out.println("*** INCORRECT ***" + player.getName() + " playing " + round.get(i) + " in " + round + " while having " + player.getHand());
               break;
            }
         }
      }
   }
  }
}
  
  public String toString() {
    String ret = "***" + nameOfGame + "***\n";
    for (CardPlayer player : players) {
      ret += player + "\n";
    }
    ret += "Deck ->" + deckOfCards;
    return ret;
  }
  
}
 

