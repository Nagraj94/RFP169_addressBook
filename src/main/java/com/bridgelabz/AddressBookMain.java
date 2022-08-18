package com.bridgelabz;

import java.io.IOException;
import java.util.Scanner;

import static com.bridgelabz.AddressBook.*;

public class AddressBookMain {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        AddressBook contact1 = new AddressBook();

        boolean exit =false;
        while (!exit) {
            System.out.println("1.Add contact" +
                    "\n2.Edit contact" +
                    "\n3.Delete contact" +
                    "\n4.Add multiple contact" +
                    "\n5.Add new addressbook or Select addressbook" +
                    "\n6.Search by contact by city or state"+
                    "\n7.Show contact" +
                    "\n8.Exit");
            int check = sc.nextInt();
            if (check == 1) {
                try{
                    map.get(currentAddressBookName).createContact();
                }catch (Exception e){
                    System.out.println("No Addressbook found");
                }
            } else if (check == 2) {
                contact1.edit();
            } else if (check == 3) {
                contact1.delete();
            } else if (check == 4) {
                contact1.addMultipleContact();
            } else if (check == 5) {
                contact1.chooseAddressBook();
            } else if (check == 6) {
                contact1.searchContact();
            } else if (check == 7) {
                contact1.showContacts();
            } else if (check == 8) {
                exit = true;
            }
        }
    }
}
