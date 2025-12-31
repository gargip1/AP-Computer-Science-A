import java.util.Arrays;

public class WordSearch
{
	/** One 2D array instance variable */
	/*  You CANNOT add any additional instance variables */
	private String[][] wordSearch;   
	
	/** constructor used to set the number of rows and columns in the 2D array
		* @param row
		* @param col*/
	public WordSearch(int row, int col)
	{
		wordSearch = new String[row][col];
	}
	
	/** method to set an element in the 2D array
		* @param s which is the value to store in the 2D array
		* @param row the row to use
		* @param col the column to use*/
	public void setSpot(String s, int row, int col)
	{
		wordSearch[row][col] = s;
	}
	
	/** methods to check for the word in the 2D array
		* @param word the word to search for
		* @return return true or false*/
	public boolean inGrid(String s)
	{
      //getting the rows and columns number
      int numberRows = wordSearch.length;
      int numberColumns = wordSearch[0].length;
      //reversing the original string
      String backwards = "";
      for (int i = s.length() - 1; i >= 0; i--)
        {
          backwards += s.charAt(i);
        }
      //adding all of the characters in the array to a string
      String arrayToString = "";
      for (String[] row : wordSearch) {
          for(String letter : row)
            {
              if (letter != " ") //removing spaces
              arrayToString += letter; 
            }
        }
      //checking for horizontal
      boolean PresentHorizontally = (arrayToString.indexOf(s) != -1 && ((arrayToString.indexOf(s)) % (numberColumns) + s.length() <= numberColumns));

      //checking for backwards horizontal
      boolean PresentBackwardsHorizontally = (arrayToString.indexOf(backwards) != -1 && ((arrayToString.indexOf(backwards)) % (numberColumns) + backwards.length() <= numberColumns));
      
      //checking for vertical(i'm creating a new string for the column arrangement)
      String columnString = "";
      for (int i = 0; i < numberColumns; i++)
        {
          for (int j = i; j < arrayToString.length(); j += numberColumns)
            {
              columnString += arrayToString.charAt(j);
            }
        }
          boolean PresentVertically = (columnString.indexOf(s) != -1 && ((arrayToString.indexOf(s)) % (numberRows) + s.length() <= numberRows));
        

      //checking for backwards vertical(just using the string we made of the column arrangement and using the reversed version of the original string with indexOf)
        boolean PresentBackwardsVertically = (columnString.indexOf(backwards) != -1 && ((arrayToString.indexOf(s)) % (numberRows + 1) + s.length() <= numberRows));
    
      //checking for diagonally (top left to bottom right AND vice versa, new string for the diagonal arrangement)
      //first all of the diagonals along the first row
      String diagonal = "";
      for (int i = 0; i < numberColumns; i++)
            {
              for (int j = i; j < arrayToString.length(); j += (numberColumns + 1))
                {
                  diagonal += arrayToString.charAt(j);
                }
            }
      //now all of the diagonals along the first column
      boolean PresentDiagonally1 = false;
      boolean PresentDiagonallyBackwards1 = false;
      for (int i = 0; i < numberRows; i += numberColumns)
        {
            for (int j = i; j < arrayToString.length(); j += (numberColumns + 1))
              {
                diagonal += arrayToString.charAt(j);
              }
             PresentDiagonally1 = (diagonal.indexOf(s) != -1);
             PresentDiagonallyBackwards1 = (diagonal.indexOf(backwards) != -1);
        }
    //checking for diagonally (top right to bottom left AND vice versa, new string for the diagonal arrangement) 
      String diagonal2 = ""; 
      for (int i = numberColumns - 1; i >= 0; i--) 
      { 
        for (int j = i; j < arrayToString.length(); j += (numberColumns - 1)) 
        { 
          diagonal2 += arrayToString.charAt(j); 
        } 
      } 
      //now all of the diagonals along the last column 
      boolean PresentDiagonally2 = false; 
      boolean PresentDiagonallyBackwards2 = false; 
      for (int i = numberColumns - 1; i < arrayToString.length(); i += numberColumns) 
      { 
        for (int j = i; j < arrayToString.length(); j += (numberColumns - 1)) 
        {
          diagonal2 += arrayToString.charAt(j); 
        } 
        PresentDiagonally2 = (diagonal2.indexOf(s) != -1); 
        PresentDiagonallyBackwards2 = (diagonal2.indexOf(backwards) != -1); 
      }
      
      boolean result;

      //checking against all of the booleans
      //System.out.println(s);
      if(PresentDiagonally1)
      {
        //System.out.println("true - present diagonally");
        result = true;
      }
      else if (PresentDiagonallyBackwards1)
      {
        //System.out.println("true - present diagonally backward");
        result = true;
      }
      else if (PresentBackwardsVertically)
      {
        //System.out.println("true - present vertically backward");
        result = true;
      }
      else if (PresentVertically)
      {
        //System.out.println("true - present vertically");
        result = true;
      }
      else if (PresentHorizontally)
      {
        //System.out.println("true - present horizontally");
        result = true;
      }
      else if (PresentBackwardsHorizontally)
      {
        //System.out.println("true - present horizontally backward");
        result = true;
      }
     else if (PresentDiagonally2) 
     { 
       //System.out.println("true - present horizontally backward"); 
       result = true; 
     } 
     else if (PresentDiagonallyBackwards2) 
     { 
       //System.out.println("true - present horizontally backward"); 
       result = true; 
     }
      else 
      {
        //System.out.println("not present!");
        result = false;
      }
      return result;
  }
    
	/** toString method
		* @return String containing all elements in the 2D array*/
	public String toString()
	{
      String result = "[";
      for (int i = 0; i < wordSearch.length; i++)
        {
          result += "[ ";
          for (int j = 0; j < wordSearch[i].length; j++)
            {
              result += wordSearch[i][j] + " ";
            }
          result = result.trim() + "]\n";
        }
      result += "]";
      return result;
	}
}
