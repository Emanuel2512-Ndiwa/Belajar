package CLI;

import java.util.ArrayList;
import java.util.Scanner;
import ECommerce.Category;
import ECommerce.User;
import ECommerce.DataManager;
import ECommerce.Seller;

public class Explore implements Actionable {

    @Override
    public String getLabel() {
        return "shop";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if (dataManager.getCategories().isEmpty()) {
            System.out.println("Not categories is avalable");
            return;
        }
        System.out.println("Categories");
        for (int i = 0; i < dataManager.getCategories().size(); i++) {
            System.out.println((i + 1) + ". " + dataManager.getCategories().get(i).getName());

        }

        int index;
        do {
            System.out.println("Select Category");
            index = scanner.nextInt() - 1;
        } while (index < 0 || index >= dataManager.getCategories().size());

        Category category = dataManager.getCategories().get(index);
        System.out.println("Category:" + dataManager.getCategories().get(index).getName());

        int choice;
        do {
            System.out.println("1.Show Deteails");
            System.out.println("2.Show Products");
            if (user instanceof Seller) {
                System.out.println("3.Edit Category");
                System.out.println("4.Delete Category");
                System.out.println("5.Add new product");
            }
            System.out.println("0.Back");
            choice = scanner.nextInt();

        } while (choice < 0 || choice > 5);
        choice--;
        ArrayList<Actionable> action = new ArrayList<Actionable>();
        action.add(new ShowCategoryDetails(category));
        action.add(new ShowCategoryProduct(category));
        action.add(new EditCategory(category));
        action.add(new DeleteCategory(category));
        action.add(new AddProduct(category));

        action.get(choice).execute(scanner, user, dataManager);

    }

}
