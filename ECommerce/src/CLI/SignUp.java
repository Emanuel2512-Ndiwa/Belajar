package CLI;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import ECommerce.Client;
import ECommerce.DataManager;
import ECommerce.Seller;
import ECommerce.User;

public class SignUp {

    private DataManager dataManager;

    public SignUp(Scanner scanner, DataManager dataManager, NavigationHandler navigationHandler) {
        int ID = generateID();
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter Email");
        String email = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        System.out.println("Confirm password:");
        String confirmPassword = scanner.nextLine();

        while (!password.equals(confirmPassword))
            ;
        {
            System.out.println("password doesn't match");
            System.out.println("Enter password:");
            password = scanner.nextLine();
            System.out.println("Confirm password:");
            confirmPassword = scanner.nextLine();

        }

        System.out.println("Enter Phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Are you signing up as seller or client?(S/C)");
        String accType = scanner.nextLine();

        User user = null;
        if (accType.toUpperCase().equals("S")) {
            // seler
            user = new Seller();

        } else if (accType.toUpperCase().equals("C")) {
            // for client
            user = new Client();
            System.out.println("Enter address:");
            String address = scanner.nextLine();
            System.out.println("Enter payment details:");
            String paymentDetails = scanner.nextLine();

            ((Client) user).setAdres(address);
            ((Client) user).setPaymentDetails(paymentDetails);

        }

        user.setID(ID);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);

        dataManager.getUsers().add(user);

    }

    private int generateID() {
        // to generate a random number betwen 10000 and 999999
        Random random = new Random();
        int ID;
        do {
            ID = random.nextInt(10000, 99999);

        } while (isUniqueID(ID));
        return ID;

    }

    private boolean isUniqueID(int ID) {

        boolean unique = true;
        for (User u : dataManager.getUsers()) {
            if (u.getID() == ID) {
                unique = false;
                break;
            }

        }
        return unique;

    }

}
