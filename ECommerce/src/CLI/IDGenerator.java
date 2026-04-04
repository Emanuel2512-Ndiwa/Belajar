package CLI;

import java.util.Random;

import ECommerce.DataManager;
import ECommerce.User;

public class IDGenerator {

    public static int generateID(DataManager dataManager, String type) {
        int origin, bound;
        switch (type) {
            case "category":
                origin = 1000;
                bound = 9999;
                break;

            case "produc":
                origin = 10000;
                bound = 99999;
                break;

            case "order":
                origin = 100000;
                bound = 999999;
                break;

            case "user":
                origin = 1000000;
                bound = 9999999;
                break;
            default:
                origin = 1000000;
                bound = 9999999;
                break;

        }

        // to generate a random number betwen 10000 and 999999
        Random random = new Random();
        int ID;
        do {
            ID = random.nextInt(origin, bound);

        } while (!isUniqueIDCategory(ID, dataManager,type));
        return ID;

    }

    private static boolean isUniqueIDCategory(int ID, DataManager dataManager, String type) {
        switch (type.toLowerCase()) {
            case "category":
                return dataManager.getCategories().stream().noneMatch(p -> p.getID() == ID);
            case "product":
                return dataManager.getProducts().stream().noneMatch(p -> p.getID() == ID);
            case "order":
                return dataManager.geOrders().stream().noneMatch(p -> p.getID() == ID);
            case "user":
                return dataManager.getUsers().stream().noneMatch(p -> p.getID() == ID);

            default:
                return true;

        }

    }

}
