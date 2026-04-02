package ECommerce;

import java.util.ArrayList;

public class Category {
    // Atribut
    private int ID;
    private String name;
    private String description;
    private ArrayList<Product> products;

    // constructor
    public Category() {
        products = new ArrayList<Product>();
    }

    public Category(int ID, String name, String description, ArrayList<Product> products) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.products = products;
    }

    // Metode Getter
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    // Metode Setter
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}
