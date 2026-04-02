package ECommerce;

import java.util.ArrayList;

import CLI.Actionable;
import CLI.Explore;

public class Client extends User {
    // should be private to be accessible only in the class not public
    private ArrayList<Order> previousOrder;// list of order that this client have
    private Cart cart;
    private String adres;
    private String paymentDetails;

    public Client() {
        previousOrder = new ArrayList<Order>();
        actions = new ArrayList<Actionable>();
        actions.add(new Explore());
    }

    public Client(ArrayList<Order> previousOrder, Cart cart, String adres, String paymentDetails) {
        this.previousOrder = previousOrder;
        this.cart = cart;
        this.adres = adres;
        this.paymentDetails = paymentDetails;
    }

    // geter

    public ArrayList<Order> getPreviousOrder() {
        return previousOrder;
    }

    public Cart getCart() {
        return cart;
    }

    public String getAdres() {
        return adres;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    // setter
    public void setPreviousOrder(ArrayList<Order> previousOrder) {
        this.previousOrder = previousOrder;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

}
