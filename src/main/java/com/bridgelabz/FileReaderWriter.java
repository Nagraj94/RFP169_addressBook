package com.bridgelabz;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderWriter {
    static final String PATH = "C:\\Users\\admin\\IdeaProjects\\RFP169_addressBook\\src\\main\\resources";

    static void readTxtFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String string;
        while ((string = bufferedReader.readLine()) != null)
            System.out.println(string);
    }

    static void readCSVFile(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            System.out.print(scanner.next());
        }
        scanner.close();
    }
    static void readCSVJsonFile(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            System.out.print(scanner.next());
        }
        scanner.close();
    }

    public static void writeTxt(ArrayList<Contact> list, String addressBookName) throws IOException {
        File file = new File(PATH + addressBookName + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        String contactDataString = "";
        for (Contact contacts : list)
            contactDataString = contactDataString.concat(contacts.toString().concat("\n"));
        fileWriter.write(contactDataString);
        fileWriter.close();
    }

    public static void writeCSV(ArrayList<Contact> list, String addressBookName) throws IOException {
        File file = new File(PATH + addressBookName + ".csv");
        FileWriter fileWriter = new FileWriter(file);
        CSVWriter csvWriter = new CSVWriter(fileWriter);
        List<String[]> data = new ArrayList<>();
        String[] heading = new String[]{"FIRST_NAME", "LAST_NAME", "ADDRESS", "CITY", "STATE", "ZIP", "PHONE_NUMBER", "EMAIL"};
        csvWriter.writeNext(heading);
        for (Contact contacts : list) {
            String[] contactData = new String[]{contacts.getFirstName(), contacts.getLastName(), contacts.getAddress(), contacts.getCity(), contacts.getState(), contacts.getZip(), contacts.getPhoneNum(), contacts.getEmail()};
            data.add(contactData);
        }
        csvWriter.writeAll(data);
        fileWriter.close();
    }
    public static void writeJson(ArrayList<Contact> arrayList, String addressBookName) throws IOException {
        File file = new File(PATH + addressBookName + ".json");
        FileWriter fileWriter = new FileWriter(file);
        Gson gson = new Gson();
        String data="";
        for (Contact contact : arrayList) {
            data = data.concat(gson.toJson(contact)+"\n");
        }
        fileWriter.write(data);
        fileWriter.close();
    }
}