package ECommerce;

import java.util.ArrayList;

public class DataManager {
    private ArrayList<User> user;
    private ArrayList<Category> categories;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;

    public DataManager(ArrayList<User> users, ArrayList<Category> categories, ArrayList<Product> products,
            ArrayList<Order> orders) {
        this.user = users;
        this.categories = categories;
        this.products = products;
        this.orders = orders;

    }

    public ArrayList<User> getUsers() {
        return user;

    }

    public ArrayList<Category> getCategories() {
        return categories;

    }

    public ArrayList<Product> getProducts() {
        return products;

    }

    public ArrayList<Order> geOrders() {
        return orders;

    }

}
