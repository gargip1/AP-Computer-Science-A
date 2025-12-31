// If you are doing this correctly your code should not be more then 125 lines
// (including comments & blank lines separating the methods).
public class Collatz {
	// instance variables (aka members, fields)
private int startNum;
   // default constructor
  public Collatz()
  {
    startNum = 1;
  }
   // initialization constructor
  public Collatz(int set)
  {
    startNum = set;
  }
   // Add a method called steps() that returns the number of steps 
   // that are required for the starting number to reach 1.
  public int steps() {
    int count = 1;
    int num = startNum;
     while (num != 1) {
        if (num % 2 == 0) {
          num /= 2;
        } else {
          num = 3 * num + 1;
        }
       count++;
      }
    return count;
  }
  
   // Add a method called sequence() that returns an array of the sequence of 
   // numbers from the starting number to 1. Use your steps() function to 
   // determine how the size of your array.
  public int[] sequence()
  {
   
    int[] list = new int[steps() + 1];
    int num = startNum;
    list[0] = num;
    for (int i = 1; num != 1; i++) {
          if (num % 2 == 0) {
            num /= 2;
          } else {
            num = 3 * num + 1;
          }
            list[i] = num;
        }
    return list;
  }
   
   // Add a method called maxValue() that returns the maximum value in the sequence.
   // Iterate through the values returned by a call to sequence().
  public int maxValue()
  {
    int[] list = sequence();
    int maxVal = list[0];
    for (int i = 1; i < list.length; i++) {
        if (list[i] > maxVal) {
          maxVal = list[i];
        }
      }
    return maxVal;
  }

   // A method called minOddValue() that returns the minimum value of all the odd numbers, 
   // except for 1, in the sequence. Iterate through the values returned by a call to sequence().
 public int minOddValue() 
  {
    int[] list = sequence();
    int minOddVal = Integer.MAX_VALUE;
    for (int i = 0; i < list.length; i++) {
        if ((list[i] != 1) && (list[i] % 2 != 0)) {
          if (list[i] < minOddVal) {
            minOddVal = list[i];
          }
        }
      }
    return minOddVal;
  }
   // Add a method called oddValues() that returns an array of all the odd numbers in the sequence. 
   // Iterate through the values returned by a call to sequence().  
      public int[] oddValues()
  {
    int[] list = sequence();
    int oddCount = 0;
    for (int i = 0; i < list.length; i++) {
        if (list[i] % 2 != 0) {
          oddCount++;
        }
      }
    int[] odd = new int[oddCount];
    int index = 0;
    for (int i = 0; i < list.length; i++) {
        if (list[i] % 2 != 0) {
          odd[index] = list[i];
          index++;
        }
      }
    return odd;
  }
   // Add a method called sumValues() that returns the sum of all the values in the sequence.
   // Iterate through the values returned by a call to sequence().
  public int sumValues()
  {
    int[] list = sequence();
    int sum = 0;
    for (int i = 0; i < list.length; i++) {
        sum += list[i];
      }
    return sum;
  }
   
   // Add a toString() method that returns ...    Starting number # takes # steps
  public String toString()
  {
    return "Starting number " + startNum + " takes " + steps() + " steps";
  }
}

