// Test your Collatz object 
//  As described in the lab instructions
import java.util.Arrays;
import java.util.Scanner;

public class CollatzRunner { 
  public static void main(String[] args) 
  {  
    Scanner n = new Scanner(System.in);
    int start = n.nextInt();
    Collatz c = new Collatz(start); 
    System.out.println("Starting number " + c); 
    System.out.println("Number of steps " + c.steps()); 
    System.out.println("Maximum value " + c.maxValue()); 
    System.out.println("Minimum odd value " + c.minOddValue());
    System.out.println("Odd values " + Arrays.toString(c.oddValues())); 
    System.out.println("Sum of all values " + c.sumValues()); 

    int[] list = c.sequence();
    for (int i = 0; i < list.length - 1; i++)
      {
        int step = i + 1;
        System.out.println("step " + step + "\t" + list[i]);
      }
  }
}
