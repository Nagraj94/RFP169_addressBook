package com.bridgelabz;

import java.util.Scanner;

public class Contact {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String  zip;
    private String phoneNum;
    private String email;
    public Contact(){}

    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNum, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String  zip) {
        this.zip = zip;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName +
                " lastName: " + lastName +
                " address: " + address +
                " city: " + city +
                " state: " + state +
                " zip: " + zip +
                " phoneNum: " + phoneNum +
                " email: " + email;
    }

    public void editExistingContact(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter firstname");
        firstName = sc.next();
        System.out.println("Enter firstname");
        lastName = sc.next();
        System.out.println("Enter address");
        address =  sc.next();
        System.out.println("Enter city");
        city = sc.next();
        System.out.println("Enter state");
        state = sc.next();
        System.out.println("Enter zip code");
        zip = sc.next();
        System.out.println("Enter your phone number");
        phoneNum = sc.next();
        System.out.println("Enter email");
        email = sc.next();

    }
}
