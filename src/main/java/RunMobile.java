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
        boolean validName = validNameLength(newContact);
        boolean correctLength = validNumberLength(newNumber);
        boolean numsOnly = validNumberContents(newNumber);
        if (validName && correctLength && numsOnly) {
            contactList.addContact(newContact, newNumber);
        } else {
            System.out.println("Returning to main menu.");
        }
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
        boolean validName = validNameLength(newContact);
        if (validName) {
            contactList.replaceContactName(newContact, oldContact);
        } else {
            System.out.println("Returning to main menu.");
        }
    }

    public void modifyContactNumber() {
        System.out.println("Enter Contact Name of Number to be modified:");
        String oldContact = scan.nextLine();
        System.out.println("Enter modified Contact Number");
        String newContactNumber = scan.nextLine();
        boolean correctLength = validNumberLength(newContactNumber);
        boolean numsOnly = validNumberContents(newContactNumber);
        if (correctLength && numsOnly) {
            contactList.replaceContactNumber(newContactNumber, oldContact);
        } else {
            System.out.println("Returning to main menu.");
        }
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

    public void closeScanner() {
        scan.close();
    }

    public boolean validNumberLength(String number){
        int len = number.length();
        if (len != 11) {
            System.out.println("Invalid length number!");
            System.out.println("UK numbers are 11 digits long.");
            return false;
        } else {
            return true;
        }
    }

    public boolean validNumberContents(String number) {
        if(number.matches("[0-9]+")){
            return true;
        } else {
            System.out.println("Invalid Number!");
            System.out.println("Numbers can only contain digits.");
            return false;
        }
    }

    public boolean validNameLength(String name) {
        if (name.length() < 15){
            return true;
        } else {
            System.out.println("Name is too long!");
            System.out.println("Names must be less than 15 characters.");
            return false;
        }
    }


}
