public class BookRunner {
    public static void main(String[] args) {
      Book textBook = new Book();
      System.out.println(textBook);
    
      Book hitchhikersGuideToTheGalaxy = new Book("Hitchhikers Guide to the Galaxy", 345391802);
      System.out.println(hitchhikersGuideToTheGalaxy);
      
      textBook.setName("Learn JAVA now!!!");
      textBook.setISBN(12345678);
      textBook.getBookName();

      System.out.println("Book 0 name: "+ textBook.getBookName() + " ISBN(" + textBook.getISBN() + ")");
        System.out.println("Book 1 name: "+ hitchhikersGuideToTheGalaxy.getBookName() + " ISBN(" + hitchhikersGuideToTheGalaxy.getISBN() + ")");

      System.out.println(textBook);
      System.out.println(hitchhikersGuideToTheGalaxy);      
    }
}
