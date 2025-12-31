import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Library {

   //ArrayList instance variable that can store Book references
   private ArrayList<Book> books;   // Do NOT modify this line
   
   /**
    * Initialization Constructor
    * Initializes a Library from a text file in the format
    * # of Books
    * Title Author Rating
    * ...
    * 
    * Fields must be tab delimited. First line of the file is the number of entries
    * that follow.
    * 
    * @param filename text file to read
    * @throws FileNotFoundException
    */
   public Library(String filename) throws FileNotFoundException
   {
      File top100 = new File(filename);
      Scanner topReader = new Scanner(top100);
      
      //instantiate ArrayList
      books = new ArrayList<Book>();
    
      //We need 2 Scanners to read the file because it is tab delimited.
      //The first Scanner reads an entire line and feeds it into the second.
      //The second Scanner can then parse the line on tabs.
      while (topReader.hasNextLine()) {
         Scanner lineReader = new Scanner(topReader.nextLine()).useDelimiter("\\t");
      
         String title, author;
         int rating;
      
         if (lineReader.hasNext()) {
            title = lineReader.next();
         } else {
            continue;
         }
      
         if (lineReader.hasNext()) {
            author = lineReader.next();
         } else {
            continue;
         }
      
         if (lineReader.hasNextInt()) {
            rating = lineReader.nextInt();
         } else {
            continue;
         }
         addBook(new Book(title, author, rating));
      }
   }
   
   //TODO complete default constructor
   public Library()
   {
      books = new ArrayList<Book>();
   }
   
   //TODO complete initialization constuctor
   public Library(ArrayList<Book> b)
   {
      books = new ArrayList<Book>();
     for (int i = 0; i < b.size(); i++) {
       books.add(i, b.get(i));
     }
      
   }

  //TODO complete modifier method for instance variable books
   public void setBooks(ArrayList<Book> b)
   {
      books.clear();
      for (Book x : b) {
        books.add(x);
      }
   }

   //initialization constructor
   public Library(Library other)
   {
      books = new ArrayList<Book>();
      setBooks(other.getBooks());
   }
  
   //TODO complete accessor for instance variable books
   public ArrayList<Book> getBooks()
   {
      return books;
   }
   
   
   //TODO get the union of two ArrayLists
   //     return a Library with the instance variable books containing
   //     the books from this library followed by the books in the other library
   public Library union(Library other)
   {
     ArrayList<Book> ret = new ArrayList<Book>();
     Library j = new Library();
     for (int i = 0; i < books.size(); i++) {
        ret.add(books.get(i));
      }
     for (int i = 0; i < (other.getBooks()).size(); i++) {
        ret.add((other.getBooks()).get(i));
      }

     j.setBooks(ret);
     return j;
   }
   
   //TODO complete method to get book at a specified index   
   public Book getBook(int index)
   {
      return books.get(index);
   }
  
   //TODO complete method to add a book to the to the library just before the given index, shifting subsequent books to the right. 
   public void setBook(int index, Book b)
   {
      books.add(index, b);
   }   
  
   //TODO complete method to add a book at the end of the books ArrayList
   public void addBook(Book addMe)
   {
      books.add(addMe);
   }

   //TODO complete method to add entire ArrayList paramter to end of the books ArrayList
   public void addBooks(ArrayList<Book> addUs)
   {
      for (int i = 0; i < addUs.size(); i++) {
        books.add(addUs.get(i));
      }
   }
   
   //TODO complete method to remove book at specified index
   public Book removeBook(int index)
   {
      Book c = books.get(index);
      books.remove(index);
      return c;
   }
  
   //TODO complete method to remove first instance of a specified book   
   public boolean removeBook(Book b)
   {
      for (int i = 0; i < books.size(); i++) {
        if (books.get(i).equals(b)) {
          books.remove(i);
          return true;
        }
      }
     return false;
   }
   
   //TODO complete method to check for a book in the books instance variable
   public boolean contains(Book findMe)
   {

      for (Book b : books) {
        if (b.equals(findMe)) {
          return true;
        }
      }
     return false;
   }
  
   //TODO complete method to get index of specified book
   public int indexOf(Book b)
   {
      int index = 0;
      for (int i = books.size() - 1; i >= 0; i--) {
        if ((books.get(i)).equals(b)) {
          index = i;
        }
      }
     if (index == 0) {
       index = -1;
     }
     return index;
     
   }   
   
   //TODO complete method to return a Library containing all books with specified title
   // use the Book method titleContains()
   public Library searchByTitle(String title)
   {
      Library ret = new Library();
      ArrayList <Book> idk = new ArrayList<Book>();
      for (Book b : books) {
          if (b.titleContains(title)) {
            idk.add(b);
          }
        }
     ret.setBooks(idk);
     return ret;
   }
   
   //TODO complete method to return a Library containing all books with specified author
   // use the Book method authorContains()
   public Library searchByAuthor(String author)
   {
      Library ret = new Library();
      ArrayList <Book> idk = new ArrayList<Book>();
     for (Book b : books) {
          if (b.authorContains(author)) {
            idk.add(b);
          }
        }
     ret.setBooks(idk);
     return ret;
   }

   /**
    * Find all books with an equal or greater rating.
    * 
    * @param rating
    * @return array of all books with an equal or better rating
    */
   public Library searchByRating(int rating)
   {
      Library ret = new Library();
      ArrayList <Book> idk = new ArrayList<Book>();
      for (int i = 0; i < books.size(); i++) {
        if (((books.get(i)).getRating()) >= rating) {
          idk.add(books.get(i));
        }
      }
     ret.addBooks(idk);
     return ret;
   }
  
   //TODO complete equals method
   public boolean equals(Object obj)
   {
      Library l = (Library) obj;
      return (books.equals(l.getBooks()));
   }
   
   //TODO complete toString method
   // simply use the ArrayList toString() method
   public String toString()
   {
      return books.toString();
   }
}
