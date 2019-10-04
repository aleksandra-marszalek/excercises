import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static MobilePhone contactList = new MobilePhone();


    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        instructions();
        while(!quit) {
            System.out.println("Enter choice:");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 0:
                    instructions();
                    break;
                case 1:
                    contactList.printContacts();
                    break;
                case 2:
                    newContact();
                    break;
                case 3:
                    loseContact();
                    break;
                case 4:
                    modifyContactName();
                    break;
                case 5:
                    modifyContactNumber();
                    break;
                case 6:
                    locateContactName();
                    break;
                case 7:
                    locateContactNumber();
                    break;
                case 8:
                    quit = true;
                    System.out.println("Closed Contacts.");
                    break;
            }
        }
    }

    public static void instructions() {
        System.out.println("\nEnter");
        System.out.println("\t0 - Display Instructions");
        System.out.println("\t1 - Display Contacts");
        System.out.println("\t2 - Add a Contact");
        System.out.println("\t3 - Remove a Contact");
        System.out.println("\t4 - Change a Contact Name");
        System.out.println("\t5 - Change a Contact Number");
        System.out.println("\t6 - Search for a Contact Name");
        System.out.println("\t7 = Search for a Contact Number");
        System.out.println("\t8 - Quite Contacts");
    }

    public static void newContact() {
        System.out.println("Enter Contact Name:");
        String newContact = scan.nextLine();
        System.out.println("Enter new Contact Number:");
        String newNumber = scan.nextLine();
        contactList.addContact(newContact, newNumber);
    }

    public static void loseContact() {
        System.out.println("Enter Contact Name:");
        contactList.removeContact(scan.nextLine());
    }

    public static void modifyContactName() {
        System.out.println("Enter Contact Name to be modified:");
        String oldContact = scan.nextLine();
        System.out.println("Enter modified Contact Name");
        String newContact = scan.nextLine();
        contactList.replaceContactName(newContact, oldContact);
    }

    public static void modifyContactNumber() {
        System.out.println("Enter Contact Name of Number to be modified:");
        String oldContact = scan.nextLine();
        System.out.println("Enter modified Contact Number");
        String newContactNumber = scan.nextLine();
        contactList.replaceContactNumber(newContactNumber, oldContact);
    }

    public static void locateContactName() {
        System.out.println("Enter Contact Name to be found:");
        String foundContact = scan.nextLine();
        int pos = contactList.findContact(foundContact);
        if (pos >= 0) {
            System.out.println(foundContact + " is in Contacts at " + (pos+1));
        } else {
            System.out.println(foundContact + " is not in Contacts");
        }

    }

    public static void locateContactNumber() {
        System.out.println("Enter Contact Number to be found:");
        String foundNumber = scan.nextLine();
        int pos = contactList.findNumber(foundNumber);
        if (pos >= 0) {
            System.out.println(foundNumber + " is in Contacts at " + (pos+1));
        } else {
            System.out.println(foundNumber + " is not in Contacts");
        }

    }
}
