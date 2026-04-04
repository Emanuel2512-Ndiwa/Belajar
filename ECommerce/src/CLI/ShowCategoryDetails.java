package CLI;

import java.util.Scanner;

import ECommerce.DataManager;
import ECommerce.User;
import ECommerce.Category;


public class ShowCategoryDetails implements Actionable {
    private Category c;

    public ShowCategoryDetails(Category c) {
        this.c=c;
    }

    @Override
    public String getLabel() {
        return "Show Category Details";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if (c == null) {
            System.out.println("Category Unavailable");
            return;
        }

        if (dataManager.getCategories().size() == 0) {
            System.out.println("Category available");
            return;
        }
        System.out.println("======================================");
        for (Category category : dataManager.getCategories()) {
            System.out.println();
            System.out.println("ID\t:" + category.getID());
            System.out.println("Name\t:" + category.getName());
            System.out.println("Description\t:" + category.getDescription());
            System.out.println("Number od Products\t:" + category.getProducts());

        }
        System.out.println("====================================");

    }
}
