package ECommerce;

import java.util.ArrayList;

public class Cart {
    // cart contain product but has some diferent atribute
    private ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<Product>();
    }

    public Cart(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    // wil alculate the total price of the cart by multiplying the price of each
    // product by its quantity and summing them up
    public double calculateTotal() {
        return products.stream().mapToDouble(product -> product.getPrice() * product.getStockQuantity()).sum();
    }

}
