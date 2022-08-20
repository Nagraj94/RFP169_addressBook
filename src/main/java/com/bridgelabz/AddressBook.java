package com.bridgelabz;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class AddressBook {
    public static HashMap<String,AddressBook> map = new HashMap<>();
    static ArrayList<Contact> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String currentAddressBookName;
    public static String addressBookName;

    private static final String PATH = "C:\\Users\\admin\\IdeaProjects\\RFP169_addressBook\\src\\main\\resources";

    public void createContact() throws IOException {
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
        writeData();
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
            System.out.println("Enter lastname");
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
                addressBookName = sc.next();
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
                addressBookName = sc.next();
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
    void writeAddressBook(ArrayList<Contact> arrayList,String addressBookName) throws IOException {
        System.out.println("Enter\n 1) To write to txt file\n 2) To write to CSV file");
        int option = sc.nextInt();
        switch (option){
            case 1:
                FileReaderWriter.writeTxt(arrayList, addressBookName);
                break;
            case 2:
                FileReaderWriter.writeCSV(arrayList, addressBookName);
                break;
        }

    }

    void readAddressBook(String addressBookName) throws IOException {
        System.out.println("Select option \n1.read from text file \n2.read from csv file");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                FileReaderWriter.readTxtFile(new File(FileReaderWriter.PATH.concat(addressBookName+".txt")));
                break;
            case 2:
                FileReaderWriter.readCSVFile(new File(FileReaderWriter.PATH.concat( addressBookName +".csv")));
                break;
        }
    }


    public void searchContact(){
        if (list.isEmpty()){
            System.out.println("list is empty....!");
            return;
        }
        boolean exit = false;
        while (!exit){
            System.out.println("1.Search contact by city\n2.Search by state");
            int check = sc.nextInt();
            if (check == 1){
                System.out.println("enter city: ");
                String city = sc.next();
                searchByCity(city);
            } else if (check == 2) {
                System.out.println("enter state: ");
                String state = sc.next();
                searchByState(state);
            } else if (check == 3) {
                System.out.println("enter city or state ");
                String opt = sc.next();
                searchByCityState(opt,opt);
            } else
                exit = true;
        }

    }
    public void searchByCityState(String city, String  state){
        for (Contact contact : list){
            if (contact.getCity().contains(city) || contact.getState().contains(state)){
                System.out.println(contact);
            }
        }
    }

    public void searchByCity(String city){
        for (Contact contact : list){
            if (contact.getCity().contains(city)){
                System.out.println(contact);
            }
        }
    }
    public void searchByState(String state){
        for (Contact contact: list){
            if (contact.getState().contains(state)){
                System.out.println(contact);
            }
        }
    }

    public void showContacts() {
        if (list.isEmpty()) {
            System.out.println("No contacts to display");
            return;
        }
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Enter option
                    1) To view by City
                    2) To view by State
                    3) To exit
                    """);
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("Enter the city name to view");
                String city = sc.next().toLowerCase();
                Map<String, List<Contact>> cityDictionary = new HashMap<>();
                for (AddressBook addressBook : AddressBook.map.values()) {
                    List<Contact> contactsCityList = addressBook.list.stream().filter(x -> x.getCity().toLowerCase().equals(city)).collect(Collectors.toList());
                    if (cityDictionary.containsKey(city)) {
                        cityDictionary.get(city).addAll(contactsCityList);
                    } else
                        cityDictionary.put(city, contactsCityList);

                }
                System.out.println("No of contacts in city " + city + " are " + cityDictionary.size());
                System.out.println("Contacts in city " + city + " are:");
                System.out.println(cityDictionary.keySet());
            } else if (option == 2) {
                System.out.println("Enter the state name to view");
                String state = sc.next().toLowerCase();
                Map<String, List<Contact>> stateDictionary = new HashMap<>();
                for (AddressBook addressBook : AddressBook.map.values()) {
                    List<Contact> contactsStateList = addressBook.list.stream().filter(x -> x.getState().toLowerCase().equals(state)).collect(Collectors.toList());
                    if (stateDictionary.containsKey(state)) {

                        stateDictionary.get(state).addAll(contactsStateList);
                    } else
                        stateDictionary.put(state, contactsStateList);
                }

                System.out.println("No of contacts in state " + state + " are " + stateDictionary.size());
                System.out.println("Contacts in state " + state + " are:");
                System.out.println(stateDictionary.keySet());
            } else {
                exit = true;
            }

        }
    }

    void sortByCity(){
        if (list.isEmpty()) {
            System.out.println("No contacts in the addressBook");
            return;
        }
        list.sort(Comparator.comparing(Contact::getCity));
        list.forEach(System.out::println);
    }

    void sortByState(){
        if (list.isEmpty()) {
            System.out.println("No contacts in the addressBook");
            return;
        }
        list.sort(Comparator.comparing(Contact::getState));
        list.forEach(System.out::println);
    }

    void sortByZipCode(){
        if (list.isEmpty()) {
            System.out.println("No contacts in the addressBook");
            return;
        }
        list.sort(Comparator.comparing(Contact::getZip));
        list.forEach(System.out::println);
    }
    void writeData() throws IOException{
        FileIO fileIO = new FileIO();
        fileIO.writeFile();
    }
    void readData() throws IOException{
        FileIO fileIO = new FileIO();
        fileIO.readFile();
    }
    void displayContact() throws IOException {
        if (list.isEmpty()) {
            System.out.println("No contacts in the addressBook");
            return;
        }
        list.sort(Comparator.comparing(Contact::getFirstName));
        readData();
    }

}
