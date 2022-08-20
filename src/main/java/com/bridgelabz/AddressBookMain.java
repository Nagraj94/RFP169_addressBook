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
                    "\n8.Write addressBook to Files"+
                    "\n9.Read addressBook from files"+
                    "\n10.Exit");
            int check = sc.nextInt();

            if (check == 1) {
                try{
                    map.get(currentAddressBookName).createContact();
                }catch (Exception e){
                    System.out.println("No Addressbook found");
                }
            } else if (check == 2) {
                try {
                    map.get(currentAddressBookName).edit();
                }catch (Exception e){
                    System.out.println("No address book found");
                }
            } else if (check == 3) {
                try {
                    map.get(currentAddressBookName).delete();
                }catch (Exception e){
                    System.out.println("No address book found");
                }
            } else if (check == 4) {
                try {
                    map.get(currentAddressBookName).addMultipleContact();
                }catch (Exception e){
                    System.out.println("create address book");
                }
            } else if (check == 5) {
                try {
                    map.get(currentAddressBookName).chooseAddressBook();
                }catch (Exception e){
                    System.out.println("No address book found");
                }
            } else if (check == 6) {
                try {
                    map.get(currentAddressBookName).searchContact();
                }catch (Exception e){
                    System.out.println("No contact found");
                }
            } else if (check == 7) {
                try {
                    map.get(currentAddressBookName).showContacts();
                }catch (Exception e){
                    System.out.println("No contact to show");
                }
            } else if (check == 8) {
                try {
                    map.get(currentAddressBookName).writeAddressBook(map.get(currentAddressBookName).list,currentAddressBookName);
                } catch (IOException e) {
                    System.out.println("Catch BLock");
                }
            } else if (check == 9) {
                try {
                    map.get(currentAddressBookName).readAddressBook(currentAddressBookName);
                } catch (IOException e) {
                    System.out.println("Catch BLock");
                }
            } else if (check == 10) {
                exit = true;
            }

        }
    }
}
