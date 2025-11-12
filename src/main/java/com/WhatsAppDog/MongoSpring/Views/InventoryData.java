package com.WhatsAppDog.MongoSpring.Views;

public class InventoryData {
    private String item;
    private Integer quantity;

    public InventoryData(String item, Integer quantity) {
        setItem(item);
        setQuantity(quantity);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity  = quantity;
    }
}
