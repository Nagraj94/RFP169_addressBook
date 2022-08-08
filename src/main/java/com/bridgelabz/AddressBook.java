package com.bridgelabz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class AddressBook {
    public static HashMap<String,AddressBook> map = new HashMap<>();
    static ArrayList<Contact> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String currentAddressBookName;
    private static String addressBookName;

    public void createContact(){
        System.out.println("Enter firstname");
        String firstName = sc.next();
        System.out.println("Enter lastname");
        String lastName = sc.next();
        for (Contact contact : list) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                System.out.println("Contact already exist");
                return;
            }
        }
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        System.out.println("Enter address");
        contact.setAddress(sc.next());
        System.out.println("Enter city");
        contact.setCity(sc.next());
        System.out.println("Enter state");
        contact.setState(sc.next());
        System.out.println("Enter zip code");
        contact.setZip(sc.next());
        System.out.println("Enter phone number");
        contact.setPhoneNum(sc.next());
        System.out.println("Enter email");
        contact.setEmail(sc.next());
        list.add(contact);
    }
    public void edit(){
        System.out.println("Enter firstname");
        String firstName = sc.next();
        System.out.println("Enter firstname");
        String lastName = sc.next();

        for (Contact contact : list) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName))
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
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName))
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
            String zip = sc.next();
            System.out.println("Enter your phone number");
            String phoneNo = sc.next();
            System.out.println("Enter email");
            String email = sc.next();

            Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNo, email);
            list.add(contact);
        }
    }

    static void chooseAddressBook() {
        System.out.println("""
        Press 1 to add AddressBook
        Press 2 to select AddressBook""");

        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter address book name");
                addressBookName = sc.next().toLowerCase();
                if (map.containsKey(addressBookName)) {
                    System.out.println("\nAddress book already exist\n");
                    chooseAddressBook();
                } else {
                    AddressBook addressBook = new AddressBook();
                    map.put(addressBookName, addressBook);
                    currentAddressBookName = addressBookName;
                }

                break;
            case 2:
                System.out.println("Enter address book name");
                addressBookName = sc.next().toLowerCase();
                if (!map.containsKey(addressBookName)) {
                    System.out.println("\nAddressBook not Found\n");
                    chooseAddressBook();
                } else
                    currentAddressBookName = addressBookName;
                break;
            default:
                break;
        }
    }
    public void showContacts(ArrayList addressBook){
        System.out.println("Contacts: ");
        for (Object p : addressBook) {
            Contact contact = (Contact) p;
            System.out.println(contact);
        }
    }

}
