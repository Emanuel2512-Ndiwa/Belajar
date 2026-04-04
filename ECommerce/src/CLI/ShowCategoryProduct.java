package CLI;

import java.util.Scanner;

import ECommerce.User;
import ECommerce.Category;

import ECommerce.DataManager;

public class ShowCategoryProduct implements Actionable {

    private Category c;

    public ShowCategoryProduct(Category c) {
        this.c=c;

    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {

        if(c == null){
            System.out.println("category unavailable");
            return;
        }
        if (c.getProducts().size() == 0) {
            System.out.println("No product available");
            return;
        }
        for (int i = 0; i < c.getProducts().size(); i++) {
            System.out.println((i + 1) + " . " + c.getProducts().get(i).getName());

        }
        
        int productIndex=scanner.nextInt()-1;

        while(productIndex <0 || productIndex >= c.getProducts().size()){
            System.out.println("Invalid Input ");
            productIndex=scanner.nextInt()-1;
        }
    }

    @Override
    public String getLabel() {
        return "Show Category Products";
    }

}
