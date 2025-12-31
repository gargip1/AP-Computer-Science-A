public class Book {
  private String bookName;
  private int bookISBN;
  public Book()
  { 
    bookISBN = 0;
  }
  public Book(String inputName, int inputISBN)
  {
      bookName = inputName;
      bookISBN = inputISBN;
  }

  public void setName(String setName)
  {
    setName = bookName;
  }

  public void setISBN(int setISBN)
  {
    setISBN = setISBN;
  }

  public String getBookName()
  {
    return bookName;
  }
  public int getISBN()
  {
    return bookISBN;
  }
  public String toString()
  {
    return (bookName+" "+bookISBN);
  }
}
