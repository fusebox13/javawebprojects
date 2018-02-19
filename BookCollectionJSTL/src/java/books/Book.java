package books;


public class Book {
    private String title;
    private String author;
    private String isbn;
    private String edition;
    
    public Book(String title, String author, String isbn, String edition)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.edition = edition;
    }
    public void setTitle(String t)
    {
        title =t;
    }
    public void setAuthor(String a)
    {
        author =a;
    }
    public void setIsbn(String is)
    {
        isbn = is;
    }
    public void setEdition(String e)
    {
        edition = e;
    }
    public String getEdition()
    {
        return edition;
    }
    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public boolean equals(Object other)
    {
        if (other == null) return false;
        if (other.getClass() != getClass())
            return false;
        Book bother = (Book)other;
        if (title.equals(bother.title) && author.equals(bother.author) && 
                isbn.equals(bother.isbn) )
            return true;
        else 
            return false;
    }
    
}