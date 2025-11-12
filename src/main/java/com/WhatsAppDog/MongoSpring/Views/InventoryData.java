package com.WhatsAppDog.MongoSpring.Views;

import lombok.Getter;

public class InventoryData {
    private String item;
    private String supplier;
    private Integer quantity;

    public InventoryData(String item, Integer quantity, String supplier) {
        setItem(item);
        setQuantity(quantity);
        setSupplier(supplier);
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
        this.quantity = quantity;
    }
    ///
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
