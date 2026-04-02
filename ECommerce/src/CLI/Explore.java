package CLI;

import java.util.ArrayList;

import ECommerce.Order;
import ECommerce.Product;
import ECommerce.User;
import ECommerce.Category;

public class Explore implements Actionable {

    @Override
    public String getLabel(){
        return "shop";
    }

    @Override
    public void execute(
            User user, ArrayList<Category> categories, ArrayList<Product> products, ArrayList<Order> orders){

    }

}
