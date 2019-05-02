package com.company;

/*
Program to create an address book contains the following fields: name, address, city, state, zip, phone, email.

Creates an object to hold those fields. Each field is private and accessible to the main application only through
the getters and setters. One advantage of using getters and setters is to allow you to not only set the value of a
field, such as email and phone, but also validate the data as it comes in.

Creates a setter for phone and email that verifies that the phone number is in the following format: (xxx) xxx-xxxx.
Creates a setter for the email address to ensure it contains name@domain.com.

Validates the email address and phone uses something called regular expressions private methods added to
address book class. They are private methods that are called from setter to determine if the email/phone is valid.

All the addresses are stored in an arraylist and application polls for addresses in a loop and once user has finished
entering all addresses it displays all the addresses.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookApp {
    static ArrayList<AddressBook>addressBooks;

    public static void main(String[] args) {

        //Prompt user for info
        promptUserInfo();
        //Display address book
        displayAddressBook();
    }

    //Prompts user for address info in a loop until user done
    public static void promptUserInfo() {
        Scanner keyboard = new Scanner(System.in);
        String input = "y";
        addressBooks = new ArrayList<AddressBook>();
        while (input.equalsIgnoreCase("y")) {
            AddressBook a = new AddressBook();
            //Set name
            System.out.print("Enter the name: ");
            String name = keyboard.nextLine();
            a.setName(name);

            //Set address
            System.out.print("Enter address: ");
            String add = keyboard.nextLine();
            a.setAddress(add);

            //Set city
            System.out.print("Enter city: ");
            String city = keyboard.nextLine();
            a.setCity(city);

            //Set state
            System.out.print("Enter state: ");
            String state = keyboard.nextLine();
            a.setState(state);

            //Set zip
            System.out.print("Enter zip: ");
            String zip = keyboard.nextLine();
            a.setZip(zip);

            //Set phone
            System.out.print("Enter phone: ");
            String phone = keyboard.nextLine();
            while (!a.setPhone(phone)) {
                System.out.print("Invalid phone# please enter valid phone#: ");
                phone = keyboard.nextLine();
            }

            //Set email
            System.out.print("Enter email: ");
            String email = keyboard.nextLine();
            while (!a.setEmail(email)) {
                System.out.print("Invalid email please enter valid email: ");
                email = keyboard.nextLine();
            }

            //Add the address book to list
            addressBooks.add(a);

            //prompt if more addresses to be added
            System.out.println("Do you want to add more addresses (Y|N):  ");
            input = keyboard.nextLine();


        }
    }

    //Iterates through the addressBook arrayList and calls method to display the address book
    public static void displayAddressBook()
    {
        for (AddressBook a : addressBooks) {
            System.out.println(""+a.displayAddressBook());
        }
    }

}

