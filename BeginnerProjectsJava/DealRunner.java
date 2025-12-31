//import Scanner
import java.util.Scanner;

public class DealRunner
{
	public static void main(String[] args)
	{
		// instantiate Scanner object
		Scanner scanner = new Scanner(System.in);
		
		// prompt the user for the number of simulations to run
		System.out.println("How many simulations do you want to run? ");
		
		// assign input to variable
		int simulation = scanner.nextInt();
		
		// declare variables to store prize location, contestant's guess,
		// door revealed, the contestant's new guess, win counts for 
		// changing and NOT changing.
        int prizeLoc;
        int userGuess;
        int view;
        int newGuess;
		boolean winCountStay = false;
        boolean winCountSwitch = false;
		double countStay = 0;
        double countSwitch = 0;
     
		// loop through the number of game simulations
		for (int i = 0; i < simulation; i++)
          {
		
			// instantiate a Deal object inside the loop
			Deal deal = new Deal();
			
			// get the contestant's guess and assign to a variable 
			userGuess = deal.getUserGuess();
			
			// get the prize location and assign to a variable
			prizeLoc = deal.getPrizeLoc();
			
			// get the door which is revealed and assign to a variable
			view = deal.getView();
			
			// get the contestant's new guess and assign to a variable
			newGuess = deal.getNewGuess();
			
			// determine if the new guess matches the prize location
			if (newGuess == prizeLoc){
    			
                countSwitch++;
            // update the win count by changing doors and win count by NOT switching doors
            } else if (userGuess == prizeLoc){
              
                countStay++;
            }
          
            
				
			// print out the results of each simulation
			System.out.println("prize:" + prizeLoc + " guess:" + userGuess + " revealed:" + view + " new guess:" + newGuess + " win if switching:" + (newGuess == prizeLoc) + " if not switching:" + (userGuess == prizeLoc) );322
			
		}
		
		// print out the probability of winning/not winning by switching
        double prob1 = countStay / simulation;
        double prob2 = countSwitch / simulation;
		System.out.printf( "Probability of winning if you switch = %.3f%n", prob2);
        System.out.printf("\nProbability of winning if you stay = %.3f%n", prob1);
		
	}
}
