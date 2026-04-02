package CLI;

import java.util.ArrayList;

import ECommerce.Order;
import ECommerce.Product;
import ECommerce.User;
import ECommerce.Category;

public interface Actionable {

    String getLabel();

    void execute(
            User user, ArrayList<Category> categories, ArrayList<Product> products, ArrayList<Order> orders);

}
