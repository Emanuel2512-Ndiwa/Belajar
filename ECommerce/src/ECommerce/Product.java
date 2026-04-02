package ECommerce;

public class Product {
    //atribute
    private int ID;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private Category category;
    private Seller seller;

    //constructor
    public Product() {
    }

    public Product(int ID, String name, String description, double price, int stockQuantity, Category category,
            Seller seller) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.seller = seller;
    }

    //method gett

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return stockQuantity > 0;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

}
