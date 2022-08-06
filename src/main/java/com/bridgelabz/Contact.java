package com.bridgelabz;

public class Contact {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;
    int phoneNum;
    String email;

    public Contact(String firstName, String lastName, String address, String city, String state, int zip, int phoneNum, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNum = phoneNum;
        this.email = email;
    }
}
