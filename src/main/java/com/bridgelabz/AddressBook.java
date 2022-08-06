package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    ArrayList<Contact> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void createContact(){

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
    public void edit(){
        System.out.println("Enter firstname");
        String firstName = sc.next();
        System.out.println("Enter firstname");
        String lastName = sc.next();

        for (Contact contact : list) {
            if (contact.firstName.equals(firstName) && contact.lastName.equals(lastName))
                contact.editExistingContact();
            else
                System.out.println("Not Found....!");
        }

    }
    public void delete(){
        System.out.println("Enter firstname");
        String firstName = sc.next();
        System.out.println("Enter firstname");
        String lastName = sc.next();

        for (Contact contact : list) {
            if (contact.firstName.equals(firstName) && contact.lastName.equals(lastName))
                list.remove(contact);
            else
                System.out.println("Not Found....!");
        }

    }
    public void addMultipleContact(){

        System.out.println("Enter number of contact to add");
        int num = sc.nextInt();
        for (int i=0;i<num;i++) {
            System.out.println("Enter firstname");
            String firstName = sc.next();
            System.out.println("Enter firstname");
            String lastName = sc.next();
            System.out.println("Enter address");
            String address = sc.next();
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

            Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNo, email);
            list.add(contact);
        }
    }
}
