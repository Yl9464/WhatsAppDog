package com.WhatsAppDog.MongoSpring.Views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;

public class InventoryTable extends Div {
    public InventoryTable(){
        Grid<Inventory> grid = new Grid<>(Inventory.class, false);
        grid.addColumn(Invnetory::getItem).setHeader("Item").setSortable(true);
        grid.addColumn(Invnetory::getQuantity).setHeader("Quantity").setSortable(true);
        grid.addColumn(Invnetory::getSupplier).setHeader("Supplier").setSortable(true);

        List<Item> item = DataService.getItem();
        grid.setItems(item);

        add(grid);;
    }
    public void setItem(Item item){

    }
}
