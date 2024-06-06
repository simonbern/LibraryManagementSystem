package Library;

public abstract class items {

    protected static long IDnums;// number for the id following the letter (B, J or M)
    protected String name;
    protected String author;
    protected int year;// year of publication
    protected boolean available;
    protected int itemCount = 0;
    protected long CID;

    public items(String name, String author, int year) {// constructor
        IDnums++;
        this.name = name;
        this.author = author;
        this.year = year;
        available = true;
        itemCount++;
        CID = 0;

    }

    public items() {// default constructor
        IDnums++;
        name = "";
        author = "";
        year = 0;
        available = true;
        CID = 0;
    }

    public items(items i) {// copy constructor
        IDnums++;
        name = i.name;
        author = i.author;
        year = i.year;
        available = true;
        itemCount++;
        CID = 0;
    }

    public abstract int getNumberOfPages();// abstract method

    public String getName() {// getters
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public abstract String getID();// abstract method

    public boolean getAvailable() {
        return available;
    }

    public long getCID() {
        return CID;
    }

    public void setName(String newName) {// setters
        name = newName;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public void setYear(int newYear) {
        year = newYear;
    }

    public void setAvailable(boolean newAvailable) {
        available = newAvailable;
    }

    public void setCID(long newCID) {
        CID = newCID;
    }

    public abstract String toString();// abstract method

    public abstract boolean equals(Object o);// abstract method
}