package Clients;

public class client {

    private static long clientID;
    private String name;
    private long phone;
    private String email;
    public Library.items[] leasedItems;

    public client(String name, long phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        clientID = clientID++;
        leasedItems = new Library.items[1];
    }

    public client() {
        name = "";
        phone = 0;
        email = "";
        clientID = clientID++;
        leasedItems = new Library.items[1];
    }

    public client(client c) {
        name = c.name;
        phone = c.phone;
        email = c.email;
        clientID = clientID++;
        leasedItems = new Library.items[1];
    }

    public void leaseItem(Library.items i) {
        if (leasedItems[0] == null) {
            leasedItems[0] = i;
        } else {
            Library.items[] newArray = new Library.items[leasedItems.length + 1];
            for (int j = 0; j < leasedItems.length - 1; j++) {
                newArray[j] = leasedItems[j];
            }
            leasedItems = newArray;
            leasedItems[leasedItems.length - 1] = i;
        }

    }

    public void returnItem(Library.items i) {
        if (leasedItems.length == 1) {
            leasedItems[0] = null;
        } else {
            Library.items[] newArray = new Library.items[leasedItems.length - 1];
            for (int j = 0; j < leasedItems.length; j++) {
                if (leasedItems[j] != i) {
                    newArray[j] = leasedItems[j];
                }
            }
            leasedItems = newArray;
        }

    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public long getClientID() {
        return clientID;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setPhone(long newPhone) {
        phone = newPhone;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public String toString() {
        return "ID: " + clientID + " Name: " + name + " Phone: " + phone + " Email: " + email;
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (otherObject.getClass() != getClass()) {
            return false;

        } else {
            client otherClient = (client) otherObject;
            return (name.equals(otherClient.name) && phone == otherClient.phone && email.equals(otherClient.email));
        }
    }

}