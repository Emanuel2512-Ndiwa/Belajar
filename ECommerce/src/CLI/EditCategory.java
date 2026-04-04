package CLI;

import java.util.Scanner;
import ECommerce.Category;
import ECommerce.DataManager;
import ECommerce.User;

public class EditCategory implements Actionable {

    private  Category c;

    public EditCategory(Category c) {
        this.c = c;

    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        Category c = FindCategoryByID.getCategory(IDGenerator.generateID(dataManager, getLabel()), dataManager);
        int index = dataManager.getCategories().indexOf(c);
        if (c == null) {
            System.out.println("Category Unavailabele");
            return;
        }

        System.out.println("Enter category name(-1 to keep)" + c.getName());
        String name = scanner.next();
        System.out.println("Enter category description(-1 to keep)" + c.getDescription());
        String description = scanner.next();

        if (!name.equals("-1"))
            c.setName(name);
        if (!description.equals("-1"))
            c.setDescription(description);
        ;

        dataManager.getCategories().set(index, c);

    }

    @Override
    public String getLabel() {
        return "Show Category Products";
    }

}
