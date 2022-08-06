package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook contact1 = new AddressBook();
        AddressBook contact2 = new AddressBook();
        AddressBook contact3 = new AddressBook();
        System.out.println("1.Add contact\n2.Edit contact\n3.Delete contact\n4.Add multiple contact");
        int check = sc.nextInt();
        if (check == 1){
            System.out.println("Enter addressbook number");
            int ck = sc.nextInt();
            if (ck == 1) {
                contact1.createContact();
            }else if (ck == 2) {
                contact2.createContact();
            } else if (ck == 3) {
                contact3.createContact();
            }
        } else if (check == 2) {
            System.out.println("Enter addressbook number");
            int ck = sc.nextInt();
            if (ck == 1) {
                contact1.edit();
            }else if (ck == 2) {
                contact2.edit();
            } else if (ck == 3) {
                contact3.edit();
            }
        } else if (check == 3) {
            System.out.println("Enter addressbook number");
            int ck = sc.nextInt();
            if (ck == 1) {
                contact1.delete();
            }else if (ck == 2) {
                contact2.delete();
            } else if (ck == 3) {
                contact3.delete();
            }
        } else if (check == 4) {
            System.out.println("Enter addressbook number");
            int ck = sc.nextInt();
            if (ck == 1) {
                contact1.addMultipleContact();
            }else if (ck == 2) {
                contact2.addMultipleContact();
            } else if (ck == 3) {
                contact3.addMultipleContact();
            }
        }

    }
}
