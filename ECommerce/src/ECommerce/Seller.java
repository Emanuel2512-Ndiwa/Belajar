package ECommerce;

import java.util.ArrayList;

import CLI.Actionable;
import CLI.AddProduct;

public class Seller extends User {
    private int SoldItemCount;// numbe rof itme sold from this seller
    private double profit;// total profit(income)of this seller
    private String sellerComp;// name of company or seller (to be showmn)
    private ArrayList<Product> products;// product of this seller(what he sell)
    private ArrayList<Order> orders;// order that this seller have

    public Seller() {
        products = new ArrayList<Product>();
        actions =new ArrayList<Actionable>();
        actions.add(new AddProduct());
    }

    public Seller(int SoldItemCount, double profit, String sellerComp, ArrayList<Product> products,
            ArrayList<Order> orders) {
        this.orders=orders;
        this.SoldItemCount = SoldItemCount;
        this.profit = profit;
        this.sellerComp = sellerComp;
        this.products = products;
    }

    public int getSoldItemCount() {
        return SoldItemCount;
    }

    public double getProfit() {
        return profit;
    }

    public String getSellerComp() {
        return sellerComp;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setSoldItemCount(int SoldItemCount) {
        this.SoldItemCount = SoldItemCount;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public void setSellerComp(String sellerComp) {
        this.sellerComp = sellerComp;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

}
