package ECommerce;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CartProduct extends Product {
    private int quantity;
    private LocalDateTime timeAdded;
    private OrderStatus itemStatus;

    public CartProduct() {
        timeAdded = LocalDateTime.now();
    }

    public CartProduct(int quantity, LocalDateTime timeAdded,OrderStatus itemStatus) {
        this.itemStatus=itemStatus;
        this.quantity = quantity;
        this.timeAdded = timeAdded;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTimeAdded() {
        return timeAdded;
    }
    //return formatted date dan other return the formated time 
    //DateTime Formater is used to format LoacalDate or LocatTime Or LocalDateTime to a specific pattern
    public void setTimeAdded(LocalDateTime timeAdded) {
        this.timeAdded = timeAdded;
    }

    public String getFormattedDateAdded(){
        return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(timeAdded);
    }

    public String getFormatedTimeAdded(){
        return DateTimeFormatter.ofPattern("HH:mm:ss").format(timeAdded);

    }
    //to cek if the required  quantity exist in stock or not
    public boolean canAddToCart() {
        return getStockQuantity() >= getQuantity();
    }

    public OrderStatus getItemStatus(){
        return itemStatus;
    }

    public void setItemStatus(OrderStatus itemStatus){
        this.itemStatus=itemStatus;

    }
}
