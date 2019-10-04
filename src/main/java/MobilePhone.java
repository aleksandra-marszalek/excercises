import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<String> contactList = new ArrayList<String>();
    private ArrayList<String> numbersList = new ArrayList<String>();

    public void setContactList(ArrayList<String> contactList) {
        this.contactList = contactList;
    }

    public void setNumbersList(ArrayList<String> numbersList) {
        this.numbersList = numbersList;
    }

    public ArrayList<String> getContactList() {
        return contactList;
    }

    public ArrayList<String> getNumbersList() {
        return numbersList;
    }

    public void printContacts() {

        System.out.println("You have " + contactList.size() + " Contact(s).");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i+1) + ") " + contactList.get(i) + " : " + numbersList.get(i));
        }
    }

    public void addContact(String contactName, String contactNumber) {
        int positionName = findContact(contactName);
        int positionNumber = findNumber(contactNumber);
        if (positionName >= 0) {
            System.out.println(contactName + " already exists.");
        } else if (positionNumber >= 0) {
            System.out.println(contactNumber + " is already in use.");
        } else {
            contactList.add(contactName);
            numbersList.add(contactNumber);
            System.out.println(contactName + " has been added to Contacts.");
        }
    }

    public int findContact(String contactName) {
        int contactIndex = contactList.indexOf(contactName);
        return contactIndex;
    }

    public  int findNumber(String contactNumber) {
        int numberIndex = numbersList.indexOf(contactNumber);
        return numberIndex;
    }

    public void removeContact(String contactName) {
        int position = findContact(contactName);
        if (position >= 0) {
            contactList.remove(contactName);
            String contactNumber = numbersList.get(position);
            numbersList.remove(contactNumber);
            System.out.println(contactName + " has been removed.");
        } else {
            System.out.println(contactName + " does not exist.");
        }
    }

    public void replaceContactName(String contactNewName, String contactOldName) {
        int position = findContact(contactOldName);
        if (position >= 0) {
            contactList.remove(contactOldName);
            contactList.add(position, contactNewName);
            System.out.println(contactOldName + " has been modified to " + contactNewName + ".");
        } else {
            System.out.println(contactOldName + " does not exist, and has not been modified.");
        }
    }

    public void replaceContactNumber(String contactNewNumber, String contactOldName) {
        int position = findContact(contactOldName);
        if (position >= 0) {
            String contactOldNumber = numbersList.get(position);
            numbersList.remove(contactOldNumber);
            numbersList.add(position, contactNewNumber);
            System.out.println(contactOldNumber + " has been modified to " + contactNewNumber + ".");
        } else {
            System.out.println(contactOldName + " does not exist, so the number could not be modified.");
        }
    }



}
