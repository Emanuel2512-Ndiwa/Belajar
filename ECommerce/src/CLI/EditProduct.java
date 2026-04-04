package CLI;

import java.util.Scanner;

import ECommerce.*;

public class EditProduct implements Actionable {

    private Product p;

    public EditProduct(Product p) {
        this.p = p;
    }

    @Override
    public String getLabel() {
        return "Edit product";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {

        if (!(user instanceof Seller)) {
            System.out.println("Only seller can add new product");
            return;

        }
        System.out.println("Enter a product name  (-1 to keep" + p.getName() + "):");
        String name = Input.readLineString(scanner);
        System.out.println("Enter the description(-1 to keep" + p.getDescription() + "):");
        String description = Input.readLineString(scanner);
        System.out.println("enter the price product(-1 to keep" + p.getPrice() + "):");
        double price = Input.readDouble(scanner);
        System.out.println("enter product stockQuantty(int)(-1 to keep" + p.getStockQuantity() + "):");

        int stoctQty = Input.readInt(scanner);

        if (!name.equals("-1"))
            p.setName(name);
        if (!description.equals("-1"))
            p.setDescription(description);

        if (price != -1)
            p.setPrice(price);

        if (price != -1)
            p.setStockQuantity(stoctQty);

        System.out.println("Enter -1 to change product category:");
        String in = Input.readString(scanner);
        if (in.equals("-1")) {
            

        }
    }
}
