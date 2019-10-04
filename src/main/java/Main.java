import java.util.*;

public class Main {

    private static Scanner scanMain = new Scanner(System.in);
    private static RunMobile runMobile = new RunMobile();

    public static void main(String[] args) {
        boolean quit = false;
        String choice = "0";
        runMobile.instructions();
        while(!quit) {
            System.out.println("");
            System.out.println("Enter choice:");
            choice = scanMain.nextLine();
            //scanMain.nextLine();
            switch (choice) {
                case "0":
                    runMobile.instructions();
                    break;
                case "1":
                    runMobile.printContactsFromMobilePhone();
                    break;
                case "2":
                    runMobile.newContact();
                    break;
                case "3":
                    runMobile.loseContact();
                    break;
                case "4":
                    runMobile.modifyContactName();
                    break;
                case "5":
                    runMobile.modifyContactNumber();
                    break;
                case "6":
                    runMobile.locateContactName();
                    break;
                case "7":
                    runMobile.locateContactNumber();
                    break;
                case "8":
                    quit = true;
                    System.out.println("Closed Contacts.");
                    runMobile.closeScanner();
                    scanMain.close();
                    break;
                default:
                    System.out.println(choice + " is an invalid input!");
                    System.out.println("Please enter a valid choice");
                    System.out.println("For a list of valid inputs, please enter 0");
            }
        }
    }
}
