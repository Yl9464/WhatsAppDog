package com.WhatsAppDog.MongoSpring.Views;
import com.WhatsAppDog.MongoSpring.MainLayout;
import com.WhatsAppDog.MongoSpring.Views.InventoryData;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.io.Serial;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.valueOf;


@Route(value = InventoryTable.ROUTE, layout = MainLayout.class)
public class InventoryTable extends VerticalLayout {
    @Serial
    private static final long serialVersionUID = 1L;

    public static final String ROUTE = "invt";
    public static final String TITLE = "Inventory";

    private final Grid<InventoryData> inventoryGrid;


    public InventoryTable() {
        setSizeFull();

        inventoryGrid = new Grid<>();
        inventoryGrid.addColumn(InventoryData::getItem).setHeader("Item").setSortable(true);
        inventoryGrid.addColumn(InventoryData::getQuantity).setHeader("Quantity").setSortable(true);
        inventoryGrid.addColumn(InventoryData::getSupplier).setHeader("Supplier").setSortable(true);
        add(inventoryGrid);
        expand(inventoryGrid);
    }
}
//Methods to insert data into table
  //    private void initializeAndPopulateGrid(Grid<InventoryData> grid) {
//        createGridColumns(grid);
//        populateGridData(grid);
//    }
//    private void populateGridData(Grid<InventoryData> grid) {
//        List<InventoryData> data = new ArrayList<>();
//
//        grid.setItems(data);
//        grid.setAllRowsVisible(true);
//    }
//
//    private void createGridColumns(Grid<InventoryData> grid) {
//        grid.addColumn(InventoryData::getQuantity).setHeader("Quantity");
//        grid.addColumn(InventoryData::getSupplier).setHeader("Supplier");
//
//    }
//    private String getItem(String item) { return item ; }
//    private String getSupplier(String supplier) { return supplier; }
//    private Integer getQuantity(int quantity) { return quantity; }
//}


//}
