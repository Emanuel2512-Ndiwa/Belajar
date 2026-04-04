package CLI;

import ECommerce.DataManager;

import ECommerce.Category;

public class FindCategoryByID {

    public static Category getCategory(int ID, DataManager dataManager) {
        Category category =null;
        for (Category c : dataManager.getCategories()) {
            if (c.getID() == ID) {
                category = c;
                break;
            }
        }
        return category;

    }

}
