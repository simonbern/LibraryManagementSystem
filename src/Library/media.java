package Library;

public class media extends items {

    private String type;
    private String ID;

    public media(String name, String author, int year, String type) {// constructor
        super(name, author, year);
        this.type = type;
        ID = "M" + IDnums;
        available = true;
    }

    public media() {// default constructor
        super();
        type = "";
        ID = "M" + IDnums;
        available = true;
    }

    public media(media m) {// copy constructor
        super(m.name, m.author, m.year);
        type = m.type;
        ID = "M" + IDnums;
        available = true;
    }

    public String getType() {
        return type;
    }

    public String getID() {
        return ID;
    }

    public int getNumberOfPages() {
        return 0;
    }

    public void setType(String newType) {
        type = newType;
    }

    public String toString() {
        return "ID: " + ID + " Name: " + name + " Author: " + author + " Year: " + year + " Type: " + type;
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (otherObject.getClass() != getClass()) {
            return false;

        } else {
            media otherMedia = (media) otherObject;
            return (name.equals(otherMedia.name) && author.equals(otherMedia.author) && year == otherMedia.year
                    && type.equals(otherMedia.type));
        }
    }
}
