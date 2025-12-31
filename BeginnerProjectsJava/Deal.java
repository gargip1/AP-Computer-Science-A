public class Deal
{
	// instance variables
	private int prizeLoc;   // do NOT add any more instance variables
	private int userGuess;  // do NOT add any more instance variables
	// default constructor
	public Deal()
	{
		setPrizeLoc();
		setUserGuess();
	}
	// initialization constructor (1st parameter is the prize location, 2nd parameter is the guess)
	public Deal(int prizeLoc1, int userGuess1)
  {
    prizeLoc = prizeLoc1;
    userGuess = userGuess1;
  }
	// method to generate random number between 1 & 3 called rand1to3
	public int rand1to3()
  {
    return (int)(Math.random() * 3 ) + 1;
  }
	// modifier method for userGuess (set to return value from rand1to3 method)
	public int setUserGuess()
  {
    userGuess = rand1to3();
    return userGuess;
  }
	// modifier method for prizeLoc (set to return value from rand1to3 method)
	public int setPrizeLoc()
  {
    prizeLoc = rand1to3();
    return prizeLoc;
  }
	// accessor method for userGuess
	public int getUserGuess()
  {
    return userGuess;
  }
	// accessor method for prizeLoc
	public int getPrizeLoc()
  {
    return prizeLoc;
  }
	// method to determine the door that will be opened by Monty Hall called getView
	public int getView()
  {
    int view;
    do 
    {
      view = rand1to3();
    } while ( view == userGuess || view == prizeLoc );

    return view;
  }
	// method to to determine contestants new guess called getNewGuess
	public int getNewGuess()
  {
    int newGuess;
    int bad = getView();
   do {
     newGuess = rand1to3();
   } while( newGuess == userGuess || newGuess == bad );

     return newGuess;
  }  
	// toString method (do NOT change)
	public String toString()
	{
		return "user guess: " + userGuess + " prizeLoc: " + prizeLoc;  // do NOT change
	}
}
