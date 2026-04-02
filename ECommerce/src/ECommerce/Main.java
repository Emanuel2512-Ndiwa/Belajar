package ECommerce;

import java.util.ArrayList;

import CLI.NavigationHandler;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> User = new ArrayList<User>();
        ArrayList<Category> categories = new ArrayList<Category>();
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<Order> orders = new ArrayList<Order>();
        DataManager dataManager = new DataManager(User, categories, products, orders);
        NavigationHandler navigationHandlerv= new NavigationHandler(dataManager);
        navigationHandlerv.welome();
        navigationHandlerv.init();
    }

}
