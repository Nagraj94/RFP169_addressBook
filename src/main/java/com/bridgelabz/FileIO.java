package com.bridgelabz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileIO {
    static final String FILE_PATH = "C:\\Users\\admin\\IdeaProjects\\RFP169_addressBook\\src\\main\\java\\com\\bridgelabz\\addressBook.txt";

    public boolean writeFile() throws IOException {
        int i = 0;
        StringBuffer buffer = new StringBuffer();
        for (AddressBook addressBook : AddressBook.map.values()){
            String addressBookName = String.valueOf(AddressBook.currentAddressBookName.getBytes());
            buffer.append(addressBookName);
            addressBook.list.forEach(contact -> {
                String contactDataStr = contact.toString().concat("\n");
                buffer.append(contactDataStr);
            });
        }
        Path path = Files.write(Paths.get(FILE_PATH),buffer.toString().getBytes());
        return path != null ? true : false;
    }

    public void readFile() throws IOException {
        Files.lines(new  File(FILE_PATH).toPath()).forEach(System.out::println);
    }
}
