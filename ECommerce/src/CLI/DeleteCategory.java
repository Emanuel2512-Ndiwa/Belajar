package CLI;

import java.util.Scanner;

import ECommerce.DataManager;
import ECommerce.Category;
import ECommerce.User;

public class DeleteCategory implements Actionable {
    Category c;

    public DeleteCategory(Category c) {
        this.c = c;

    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if (c == null) {
            System.out.println("Category unavailable");
            return;
        }

        System.out.println("Are you sure want to delete this category with all its product?(Y/N)");
        String input = scanner.next().toUpperCase();

        if (input.equals("Y")) {
            dataManager.getProducts().retainAll(c.getProducts());
            dataManager.getCategories().remove(c);
            System.out.println("Category deleted successfully");

        }else{
            System.out.println("Operation Canceled");

        }
    }

    @Override
    public String getLabel() {
        return "Delete Category";
    }

}
