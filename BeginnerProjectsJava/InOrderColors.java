public class InOrderColors
{ 
   // Do not add any other instance variables
  private String colorOne;
  private String colorTwo;
  private String colorThree;

  public InOrderColors()
   {
      // complete default constructor  
      // set colorOne, colorTwo, colorThree to red,green,blue respectively
     colorOne = "red";
     colorTwo = "green";
     colorThree = "blue";
   }

  public InOrderColors(String c1, String c2, String c3)
   {
      colorOne = c1;
      colorTwo = c2;
      colorThree = c3;
   }

  public void setColorOne(String s1)
   {
      // complete the modifier method for colorOne
     colorOne = s1;
   }

  
   // add modifier method for colorTwo
public void setColorTwo(String s2)
  {
    colorTwo = s2;
  }
  
   // add modifier method for colorThree
public void setColorThree(String s3)
  {
    colorThree = s3;
  }

public String getColorOne()
   {
      // complete the accessor method for colorOne
     return colorOne;
   }

   // add accessor method for colorTwo
public String getColorTwo()
   {
      // complete the accessor method for colorOne
     return colorTwo;
   }
   // add accessor method for colorThree
public String getColorThree()
   {
      // complete the accessor method for colorOne
     return colorThree;
   }   
   // add a method that given a string representing one of the colors of 
   // the rainbow returns an integer representing the color's wavelength
   // use a switch statement to do the conversion from string to integer
public int wavelength(String color)
  {
    String data = color.toUpperCase();
    int returnVal;
    switch (data){
      case "RED" : returnVal = 680;
        break;
      case "ORANGE" : returnVal = 600;
        break;
      case "YELLOW" : returnVal = 575;
        break;
      case "GREEN" : returnVal = 530;
        break;
      case "BLUE" : returnVal = 470;
        break;
      case "INDIGO" : returnVal = 435;
        break;
      case "VIOLET" : returnVal = 415;
        break;
      default : returnVal = 00;
        break;
    }
    return returnVal;
  }

   // add the method areTheyInOrder() that returns a boolean indicating that the 3 color values of the object
   // are in wavelength order (colorOne is the smallest, colorTwo is the middle, colorThree is the largest)
public boolean areTheyInOrder()
  {
    return wavelength(colorOne) < wavelength(colorTwo) && wavelength(colorTwo) < wavelength(colorThree);
  }
   // add a VOID method called sortThem() to put the instance variables in order
   // colorOne = lowest value, colorTwo = middle value, colorThree = highest value
public void sortThem()
  {
    String lowest;
    String middle;
    String highest;
    if (wavelength(colorOne) < wavelength(colorTwo) && wavelength(colorOne) < wavelength(colorThree))
    {
       lowest = colorOne;
      if (wavelength(colorTwo) < wavelength(colorThree))
      {
        middle = colorTwo;
        highest = colorThree;
      }
      else
      {
        middle = colorThree;
        highest = colorTwo;
      }
    }
    else if (wavelength(colorTwo) < wavelength(colorOne) && wavelength(colorTwo) < wavelength(colorThree))
    {
       lowest = colorTwo;
      if (wavelength(colorOne) < wavelength(colorThree))
      {
        middle = colorOne;
        highest = colorThree;
      }
      else
      {
        middle = colorThree;
        highest = colorOne;
      }
    }
     else
    {
      lowest = colorThree;
      if(wavelength(colorOne) < wavelength(colorTwo))
      {
        middle = colorOne;
        highest = colorTwo;
      }
      else 
      {
        middle = colorTwo;
        highest = colorOne;
      }
    }
    colorOne = lowest;
    colorTwo = middle;
    colorThree = highest;
  }
   // the toString method returns the string that is printed when you print the object
   public String toString()
   {
      return "" + colorOne + " " + colorTwo + " " + colorThree;   // DO NOT MODIFY
   }
}
