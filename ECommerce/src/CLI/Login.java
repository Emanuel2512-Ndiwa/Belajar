package CLI;

import java.util.Scanner;
import ECommerce.DataManager;
import ECommerce.User;

public class Login {

    public Login(Scanner scanner, DataManager datsDataManager, NavigationHandler navigationHandler) {
        System.out.println("Enter Your email\t:");
        String email = scanner.next();
        System.out.println("Enter Your Pasword\t:");
        String password = scanner.next();

        boolean loggedIn = false;
        for (User user : datsDataManager.getUsers()) {
            if (user.getEmail().equals(email) && user.equals(password)) {
                loggedIn = true;
                navigationHandler.showMenu(user);
                break;

            }
        }

        if (!loggedIn) {
            System.out.println("Email or Password dosen't match");
            navigationHandler.init();
        }

    }

}
