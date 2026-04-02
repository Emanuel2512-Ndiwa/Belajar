package CLI;


import java.util.ArrayList;

import ECommerce.Order;
import ECommerce.Product;
import ECommerce.User;
import ECommerce.Category;


public class AddProduct implements Actionable{

    @Override
    public String getLabel(){
        return "Add new product";
    }

    @Override
    public void execute(User user, ArrayList<Category> categories, ArrayList<Product> products, ArrayList<Order> orders){
        // TODO: Implement add product logic
    }
}
