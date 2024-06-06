package Library;

public class journal extends items {

    private int volumeNumber;
    private String ID;

    public journal(String name, String author, int year, int volumeNumber) {
        super(name, author, year);
        this.volumeNumber = volumeNumber;
        ID = "J" + IDnums;
        available = true;
    }

    public journal() {
        super();
        volumeNumber = 0;
        ID = "J" + IDnums;
        available = true;
    }

    public journal(journal j) {// copy constructor
        super(j.name, j.author, j.year);
        volumeNumber = j.volumeNumber;
        ID = "J" + IDnums;
        available = true;
    }

    public int getVolumeNumber() {
        return volumeNumber;
    }

    public int getNumberOfPages() {
        return 0;
    }

    public String getID() {
        return ID;
    }

    public void setVolumeNumber(int newVolumeNumber) {
        volumeNumber = newVolumeNumber;
    }

    public String toString() {
        return "ID: " + ID + " Name: " + name + " Author: " + author + " Year: " + year + " Volume Number: "
                + volumeNumber;
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (otherObject.getClass() != getClass()) {
            return false;

        } else {
            journal otherJournal = (journal) otherObject;
            return (name.equals(otherJournal.name) && author.equals(otherJournal.author) && year == otherJournal.year
                    && volumeNumber == otherJournal.volumeNumber);
        }
    }

}
