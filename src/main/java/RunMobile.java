import java.util.Scanner;

public class RunMobile {

    private static MobilePhone contactList = new MobilePhone();
    private static Scanner scan = new Scanner(System.in);

    public void printContactsFromMobilePhone() {
        contactList.printContacts();
    }

    public void instructions() {
        System.out.println("\nEnter");
        System.out.println("\t0 - Display Instructions");
        System.out.println("\t1 - Display Contacts");
        System.out.println("\t2 - Add a Contact");
        System.out.println("\t3 - Remove a Contact");
        System.out.println("\t4 - Change a Contact Name");
        System.out.println("\t5 - Change a Contact Number");
        System.out.println("\t6 - Search for a Contact Name");
        System.out.println("\t7 - Search for a Contact Number");
        System.out.println("\t8 - Quite Contacts");
    }

    public void newContact() {
        System.out.println("Enter Contact Name:");
        String newContact = scan.nextLine();
        System.out.println("Enter new Contact Number:");
        String newNumber = scan.nextLine();
        contactList.addContact(newContact, newNumber);
    }

    public void loseContact() {
        System.out.println("Enter Contact Name:");
        contactList.removeContact(scan.nextLine());
    }

    public void modifyContactName() {
        System.out.println("Enter Contact Name to be modified:");
        String oldContact = scan.nextLine();
        System.out.println("Enter modified Contact Name");
        String newContact = scan.nextLine();
        contactList.replaceContactName(newContact, oldContact);
    }

    public void modifyContactNumber() {
        System.out.println("Enter Contact Name of Number to be modified:");
        String oldContact = scan.nextLine();
        System.out.println("Enter modified Contact Number");
        String newContactNumber = scan.nextLine();
        contactList.replaceContactNumber(newContactNumber, oldContact);
    }

    public void locateContactName() {
        System.out.println("Enter Contact Name to be found:");
        String foundContact = scan.nextLine();
        int pos = contactList.findContact(foundContact);
        if (pos >= 0) {
            System.out.println(foundContact + " is in Contacts at " + (pos+1));
        } else {
            System.out.println(foundContact + " is not in Contacts");
        }

    }

    public void locateContactNumber() {
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
