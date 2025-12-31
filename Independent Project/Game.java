import java.util.*;
public class Game {
  private Board board = new Board();
  private boolean playerTurn = true;
  private boolean canUndo = true; //setting it to true default and making it belong in the game
  private boolean lastTurnPlayer = false;

    public void play() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("----- A W A R I -----");
    
    while (true) {
      board.display(); //displaying the board as it is first
      
      if (board.isGameOver()) { //if the game ended
        board.collectRemainingBeads(); //collect all the beads on either side and deposit them
        board.display(); //show final board
        int playerScore = board.getPlayerHome(); //score of player
        int computerScore = board.getOpponentHome(); //score of opponent
        System.out.println("Game over!"); 
        System.out.println("Your score: " + playerScore);
        System.out.println("Computer score: " + computerScore);
        if (playerScore < computerScore) { //whichever player has more beads wins the game
          System.out.println("You lose!!");
        } else if (playerScore > computerScore) {
          System.out.println("You win!!");
        } else {
          System.out.println("Wow, it's a tie!!");
        }
        break;
      }  
        if (playerTurn) {
          System.out.println("\n\nEnter pit number (1-6) or 'u' to undo the last turn (you only get one!): ");
          String input = scanner.nextLine();
          
          if (input.equals("u") && canUndo) { //if the player wants to undo and has it available
            board.restoreState(); //restore the last condition
            playerTurn = lastTurnPlayer;
            canUndo = false; //no more undos
          } else {
            int pitNum = Integer.parseInt(input) - 1; //subtracting 1 because of indexing errors
            
            if (pitNum < 0 || pitNum > 5 || board.pitIsEmpty(pitNum)) { //if it's out of bounds or if the pit is empty the move is invalid
              System.out.println("Move invalid");
            } else {
              board.saveState(); //update state
              canUndo = true;
              lastTurnPlayer = playerTurn; //update lastTurnPlayer

              boolean extraTurn = board.makeMove(pitNum, true); //seeing if we're eligible for an extra turn
              playerTurn = extraTurn; //setting playerTurn to the result
            }
          }
        } else {
          System.out.println("\n\nOpponent's Turn..."); //opponent turn
          boolean extraTurn; 
          do {
            extraTurn = false; //it's default set to false
            for (int i = 7; i <= 12; i++) { //very basic computer - just keep going through the pits in order
              if (board.pitHasBeads(i)) { //if there's beads
                board.saveState(); //do the turn and update everything
                extraTurn = board.makeMove(i, false); //see if it's eligible for an extra turn
                if (extraTurn) { //keep going 
                  System.out.println("\nComputer Turn Again");
                  board.display();
                }
                break; //break when no extra turns
              }
            } 
          } while (extraTurn); //keep going
            playerTurn = true; //switiching to the player's turn
        } 
      }
    }
 }
