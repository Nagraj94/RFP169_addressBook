package com.bridgelabz;

import java.util.Scanner;

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
        zip = sc.nextInt();
        System.out.println("Enter your phone number");
        phoneNum = sc.nextInt();
        System.out.println("Enter email");
        email = sc.next();

    }
}
