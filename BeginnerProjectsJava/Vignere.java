
/*
/   Vigenere class
/    Implement the class to include the methods exactly
/    as described in the comments.
/   Do not add any additional instance variables
/
*/


class Vigenere
{
   // declare instance variables for text and keyword
   private String plainText;
   private String key;

   // default constructor
   public Vigenere () {}
    
   // initialization constructor
   public Vigenere (String theMsg, String theKey)
   {
    plainText = theMsg;
    key = theKey;
   }
    
   // modifier method for plainText
  public void setPlainText (String inputMessage)
  {
    plainText = inputMessage;
  }
    
   // modifier method for key
  public void setKey (String inputKey)
  {
    key = inputKey;
  }
    
   // accessor method for plainText
  public String getPlainText()
  {
    return plainText;
  }
    
   // accessor method for key
  public String getKey()
  {
    return key;
  }
    
   // encrypt method
   //   return a String
   //   no parameters
   public String encrypt()
   {
     


     
     String cipherText = "";
     int keyIndex = 0;
     int keyLength = key.length();
     
     //FIRST ADJUSTING KEY LENGTH TO MESSAGE
     String adjusted = "";

     for(int i = 0; i < plainText.length(); i++)
       {
         adjusted += key.charAt(keyIndex);
         keyIndex = (keyIndex + 1) % keyLength;
       }

      
     for (int i = 0; i < plainText.length(); i++)
       {
         char plainChar = plainText.charAt(i);
         char keyChar = adjusted.charAt(i);
         
         int shift = keyChar - 'A';
         char encrypted = (char)('A' + (plainChar - 'A' + shift) % 26);
         cipherText += encrypted;
       }
     
    return cipherText;
   }
   
    
   // decrypt method
   //   return a String
   //   no parameters
    public String decrypt()
  {
    String message = "";
    int keyIndex = 0;
    int keyLength = key.length();
    //adjusting key length
    String adjusted = "";

     for(int i = 0; i < plainText.length(); i++)
       {
         adjusted += key.charAt(keyIndex);
         keyIndex = (keyIndex + 1) % keyLength;
       }

    
    for(int i = 0; i < plainText.length(); i++)
      {
        char cipherChar = plainText.charAt(i);
        char keyChar = adjusted.charAt(i);
        int shift = keyChar - 'A';
        char decrypted = (char) ('A' + (cipherChar - 'A' - shift + 26) % 26);
        message += decrypted;
      }
    return message;
  }
   
   // equals method
   //   return a boolean
   //   Vigenere reference parameter
   public boolean equals(Object obj)
  {
    Vigenere v = (Vigenere) obj;
    boolean truFal = false;
    if (plainText == v.plainText && key == v.key)
    {
      truFal = true;
    }
    return truFal;
  }
   
   // toString() method
   public String toString()
   {
        //"plain Text     = " + plainText + "\nkey            = " + key + "\nencrypted Text = " +
        return(encrypt());     
   }
    
}





