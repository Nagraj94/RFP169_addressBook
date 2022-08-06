package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook contact1 = new AddressBook();
        System.out.println("1.Add contact\n2.Edit contact\n3.Delete contact");
        int check = sc.nextInt();
        if (check == 1)
            contact1.createContact();
        else if (check == 2) {
            contact1.edit();
        } else if (check == 3) {
            contact1.delete();
        }

    }
}
