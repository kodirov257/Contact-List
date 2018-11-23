package com.example.abdurahmonbek.contactlist;

public class Contact {

    private String id;
    private String image;
    private String firstName;
    private String lastName;
    private int contactNumber;

    public Contact(String id, String image, String firstName, String lastName, int contactNumber) {
        this.id = id;
        this.image = image;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public String getImageName() {
        String[] temp = image.split("[.]");
        return temp[0];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getContactNumber() {
        return contactNumber;
    }
}
