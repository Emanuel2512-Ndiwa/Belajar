package ECommerce;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {

    private int ID;
    private Client client;
    private Seller seller;
    private LocalDateTime orderTime;
    private ArrayList<CartProduct> products;
    private double totalAmount;
    private String paymentMethod;

    public Order() {
        products = new ArrayList<CartProduct>();
    }

    public Order(int ID, Client client, Seller seller, LocalDateTime orderTime, ArrayList<CartProduct> products,
            double totalAmount, String paymentMethod) {
        this.ID = ID;
        this.client = client;
        this.seller = seller;
        this.orderTime = orderTime;
        this.products = products;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    public int getID() {
        return ID;
    }

    public Client getClient() {
        return client;
    }

    public Seller getSeller() {
        return seller;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public ArrayList<CartProduct> getProducts() {
        return products;
    }

    public OrderStatus getOrderStatus() {
        // WIL RETURN THE LEAST STATUS AS THE PRIORITY IS
        // DELIVERD,SHIPED,PENDING
        // wil return cancelled if all is cancelled

        OrderStatus status = OrderStatus.DELIVERD;
        int cancelled = 0;
        for (CartProduct p : products) {
            if (p.getItemStatus() == OrderStatus.SHIPPED && status != OrderStatus.PENDING)
                status = OrderStatus.SHIPPED;
            if (p.getItemStatus() == OrderStatus.PENDING)
                status = OrderStatus.PENDING;
            if (p.getItemStatus().equals(OrderStatus.CANCELED))
                cancelled++;

        }
        if (cancelled == products.size())
            return OrderStatus.CANCELED;

        else
            return status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getFormattedDateAdded() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(orderTime);
    }

    public String getFormatedTimeAdded() {
        return DateTimeFormatter.ofPattern("HH:mm:ss").format(orderTime);

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public void setProducts(ArrayList<CartProduct> products) {
        this.products = products;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void calculateTotalAmount() {
        this.totalAmount = products.stream().mapToDouble(cp -> cp.getPrice() * cp.getQuantity()).sum();
    }

}
