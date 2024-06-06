package Library;

public class book extends items {

    private int numberOfPages;
    private String ID;

    public book(String name, String author, int year, int numberOfPages) {
        super(name, author, year);
        this.numberOfPages = numberOfPages;
        ID = "B" + IDnums;
        available = true;
    }

    public book() {
        super();
        numberOfPages = 0;
        ID = "B" + IDnums;
        available = true;
    }

    public book(book b) {// copy constructor
        super(b.name, b.author, b.year);
        numberOfPages = b.numberOfPages;
        ID = "B" + IDnums;
        available = true;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getID() {
        return ID;
    }

    public void setNumberOfPages(int newNumberOfPages) {
        numberOfPages = newNumberOfPages;
    }

    public String toString() {
        return "ID: " + ID + " Name: " + name + " Author: " + author + " Year: " + year + " Number of Pages: "
                + numberOfPages;
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (otherObject.getClass() != getClass()) {
            return false;

        } else {
            book otherBook = (book) otherObject;
            return (name.equals(otherBook.name) && author.equals(otherBook.author) && year == otherBook.year
                    && numberOfPages == otherBook.numberOfPages);
        }
    }
}
