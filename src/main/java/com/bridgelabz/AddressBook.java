package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    ArrayList<Contact> list = new ArrayList<>();

    public void createContact(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter firstname");
        String firstName = sc.next();
        System.out.println("Enter firstname");
        String lastName = sc.next();
        System.out.println("Enter address");
        String address =  sc.next();
        System.out.println("Enter city");
        String city = sc.next();
        System.out.println("Enter state");
        String state = sc.next();
        System.out.println("Enter zip code");
        int zip = sc.nextInt();
        System.out.println("Enter your phone number");
        int phoneNo = sc.nextInt();
        System.out.println("Enter email");
        String email = sc.next();

        Contact contact = new Contact(firstName,lastName, address, city, state, zip, phoneNo,email);
        list.add(contact);
    }
}
