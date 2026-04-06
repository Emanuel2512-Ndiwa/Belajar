package CLI;

import java.util.Scanner;

import ECommerce.User;
import ECommerce.Category;
import ECommerce.DataManager;
import ECommerce.Product;
import ECommerce.Seller;

public class AddProduct implements Actionable {

    private Category category;

    public AddProduct(Category category){
        this.category=category;
    }

    @Override
    public String getLabel() {
        return "Add new product";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {

        if(!(user instanceof Seller)){
            System.out.println("Only seller can add new product");
            return;

        }
        System.out.println("Enter a product name");
        String name = Input.readLineString(scanner);
        System.out.println("Enter the description");
        String description = Input.readLineString(scanner);
        System.out.println("enter the price product");
        double price = Input.readDouble(scanner);
        System.out.println("enter product stockQuantty(int)");
        int stoctQty = Input.readInt(scanner);

        Product product = new Product();
        product.setID(IDGenerator.generateID(dataManager, "product"));
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStockQuantity(stoctQty);
        //add product to its category
        category.getProducts().add(product);
        product.setCategory(category);
        dataManager.getProducts().add(product);
        int catIndex=dataManager.getCategories().indexOf(category);
        System.out.println("Product addedd successfully");

    }
}
