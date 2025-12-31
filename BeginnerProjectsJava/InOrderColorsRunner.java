import java.util.Scanner;

public class InOrderColorsRunner /* InOrderColorsRunner */
{
   // main(): program starting point
   public static void main( String[] args ) 
   {     
     
      // ****   FIRST InOrderColors OBJECT  *****
      System.out.println("FIRST InOrderColors OBJECT INSTANCE");  // DO NOT MODIFY
      
      // create an InOrderColors object by calling the default constructor
     InOrderColors threeCols1 = new InOrderColors();

      System.out.println("  Object -> " + threeCols1);   // DO NOT MODIFY
      
      if ( threeCols1.areTheyInOrder() ) {
         System.out.println("  Currently the colors are in wavelength order.");  // DO NOT MODIFY
      }                                                                          // DO NOT MODIFY
      else {                                                                     // DO NOT MODIFY
         System.out.println("  Currently colors are NOT in wavelength order.");  // DO NOT MODIFY
      }                                                                          // DO NOT MODIFY
                 
      // use the sortThem() method top put the colors in wavelength order
     threeCols1.sortThem();

      System.out.println("  Object -> " + threeCols1);  // DO NOT MODIFY
                  
      // print out message if the colors are currently in order or not
      if ( threeCols1.areTheyInOrder() ) {               
         System.out.println("  Currently the colors are in wavelength order.");  // DO NOT MODIFY
      }                                                                          // DO NOT MODIFY
      else {                                                                     // DO NOT MODIFY
         System.out.println("  Currently colors are NOT in wavelength order.");  // DO NOT MODIFY
      }          
         
      
      // ****   SECOND InOrderColors OBJECT  *****
      System.out.println("SECOND InOrderColors OBJECT INSTANCE");   // DO NOT MODIFY
      
      // create another InOrderColors object by calling the default constructor
      InOrderColors color2 = new InOrderColors()
      // set up scanner to read input from user
      Scanner scan = new Scanner;
      
      System.out.print( "  Enter three colors: " );    // DO NOT MODIFY
      
      // use the scanner to read in the input
      firstColor = scan.next();
      secondColor = scan.next();
      thirdColor = scan.next();
      // Use the appropriate modifier method to set the three colors
      color2.
      // print out the object

      // use the sortThem() method top put the colors in wavelength order

      // print out the object

      System.out.println("  The color with the smallest wavelength is " + threeCols2.getColorOne() + ".");   // DO NOT MODIFY     
  
   
      // ****   THIRD InOrderColors OBJECT  *****
      System.out.println("THIRD InOrderColors OBJECT INSTANCE");  // DO NOT MODIFY
      
      // create another InOrderColors object by calling the initialization constructor
      // (initialize colorOne to orange, colorTwo to yellow, colorThree to violet)

      // print out the object

      // use the sortThem() method top put the colors in wavelength order

      // print out the object

      System.out.println("  The color with the largest wavelength is " + threeCols3.getColorThree() + ".");  // DO NOT MODIFY     
          
   }
}
