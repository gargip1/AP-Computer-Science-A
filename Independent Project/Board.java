import java.util.*;
public class Board {
  private Pit[] pits = new Pit[14];
  private Pit[] last = new Pit[14]; //because we need to do the undo function

  public Board() {
    for (int i = 0; i < 14; i++) {
      if (i == 6 || i == 13) 
        pits[i] = new Pit(0, false);
      else 
        pits[i] = new Pit(4, true); //pit with a special bead 
    }
  }

   public void saveState() { //saving each current state to the "last" array in case user wants to use skip
      for (int i = 0; i < 14; i++) {
        last[i] = pits[i].copy();
      }
   }

  public void restoreState() {
    for (int i = 0; i < 14; i++) {
      pits[i] = last[i].copy(); //turning the bead normal and then restoring the past state
    }
  }

  public boolean makeMove(int pitIndex, boolean isPlayerTurn) {
    
    if (pitIndex < 0 || pitIndex > 13 || pitIndex == 6 || pitIndex == 13 || pits[pitIndex].count() == 0) //if index out of bounds, is one of the home pits, or the pit is empty return false for the unsuccessful move
      return false;
   
   ArrayList<Bead> beads = pits[pitIndex].removeAllBeads(); //removing all of the beads in pit at pitIndex
   int pos = pitIndex; //copying index
    while (beads.size() != 0) { //while there’s still beads left
      pos = (pos + 1) % 14; //moving to the next position and circling back around if needed
      if (!((isPlayerTurn && pos == 13) || (!isPlayerTurn && pos == 6))) //if it's not the player's turn and the index points to their homepit skip their homepit
        pits[pos].addBead(beads.remove(0)); //adding one bead from the moved pit to each pit
    }
   boolean home = (isPlayerTurn && pos == 6) || (!isPlayerTurn && pos == 13); //if it's at the homepit of either
   return home; //either the pit at position had a special bead or the last bead landed in the homepit
  }

  public void display() {
    System.out.print("\nOpponent Side");
    System.out.print(" ");
    for (int i = 12; i >= 7; i--) {
    System.out.print(pits[i].count() + " "); //printing the number of pits for opponent
    }
    System.out.println("\n" + "             " + pits[13].count() + "           " + pits[6].count()); //printing the home scores
    System.out.print("Player Side");
    System.out.print("   ");
    for (int i = 0; i <= 5; i++) {
      System.out.print(pits[i].count() + " "); //printing the number of pits for player
    }
  }

  public boolean isSideEmpty(boolean isPlayer) {
    int start;
    if (isPlayer) {
      start = 0; //starting at the firdt pit depending on player
    } else {
      start = 7;
    }
    int end;
    if (isPlayer) { //ending on whatever pit depending on player
      end = 5;
    } else {
      end = 12;
    }
    for (int i = start; i <= end; i++) {
      if (pits[i].count() > 0) //if one whole side of the board has ANY beads
        return false; //the game should keep going
    }
    return true; //otherwise stop the game
  }

  public boolean isGameOver() {
    return isSideEmpty(true) || isSideEmpty(false); //returning true if either player's side is empty 
  }

  public void collectRemainingBeads() { //collecting all of the beads left
    for (int i = 0; i <= 5; i++) {
      int count = pits[i].count(); //the beads in current pit
      pits[6].addBeads(count); //add them to the home of the current player
      pits[i].clear(); //clear the current pit
    }
    for (int i = 7; i <= 12; i++) { //same but for opponent
      int count = pits[i].count();
      pits[13].addBeads(count);
      pits[i].clear();
    }
  }

  public int getPlayerHome() {
    return pits[6].count(); //getting homepit counts
  }

  public int getOpponentHome() {
    return pits[13].count(); //getting opponent homepit counts
  }

  public boolean pitHasBeads(int index) { //returning true if a pit isn't empty
    return pits[index].count() > 0;
  }

  public boolean pitIsEmpty(int i) {//redundant but i already put it into the code in Game
    return pits[i].count() == 0;
  }
}



