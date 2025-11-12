package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.io.Serial;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


@Route(value = InventoryTable.ROUTE, layout = MainLayout.class)
public class InventoryTable extends VerticalLayout {
    @Serial
    private static final long serialVersionUID = 1L;

    public static final String ROUTE = "ivnt";
    public static final String TITLE = "Inventory";

    private final Grid<InventoryData> inventoryGrid;


    public InventoryTable() {
        setSizeFull();

        inventoryGrid = new Grid<>();
        add(inventoryGrid);
        expand(inventoryGrid);

        initializeAndPopulateGrid(inventoryGrid);
    }


    private void initializeAndPopulateGrid(Grid<InventoryData> grid) {
        createGridColumns(grid);
        populateGridData(grid);
    }

    private void populateGridData(Grid<InventoryData> grid) {
        List<InventoryData> data = new ArrayList<>();
        for (int month = 0; month < 12; month++) {
            data.add(new InventoryData(Month.values()[month].toString(), getExpenses(month)));
        }
        grid.setItems(data);
        grid.setAllRowsVisible(true);
    }

    private void createGridColumns(Grid<InventoryData> grid) {
        grid.addColumn(InventoryData::getItem)
                .setHeader("Item");

        grid.addColumn(InventoryData::getQuantity)
                .setKey("quantity");
                .setHeader("Quantity")
                .setPartNameGenerator(expense ->
                        expense.getQuantity() > getInventoryDataLimit() ? "warn" : null
                );

        /* Note: you can also style the whole row by assigning a part name at the "grid level":
        grid.setPartNameGenerator(expense ->
                expense.getExpenses() > getInventoryDataLimit() ? "warn" : null);
         */
    }

    private long getExpenses(int month) {
        return 300 + month * 50L;
    }

}
//public class InventoryTable extends Div {
//    public InventoryTable(){
//        Grid<Inventory> grid = new Grid<>(Inventory.class, false);
//        grid.addColumn(Invnetory::getItem).setHeader("Item").setSortable(true);
//        grid.addColumn(Invnetory::getQuantity).setHeader("Quantity").setSortable(true);
//        grid.addColumn(Invnetory::getSupplier).setHeader("Supplier").setSortable(true);
//
//        List<Item> item = DataService.getItem();
//        grid.setItems(item);
//
//        add(grid);;
//    }
//    public void setItem(Item item){
//
//    }
//}
