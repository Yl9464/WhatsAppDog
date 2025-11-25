package com.WhatsAppDog.MongoSpring.Views;
import com.WhatsAppDog.MongoSpring.MainLayout;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Model.Supplies;
import com.WhatsAppDog.MongoSpring.Repository.SuppliesRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.List;

@Route(value = SuppliesView.ROUTE, layout = MainLayout.class)
public class SuppliesView extends VerticalLayout {

    public static final String ROUTE = "supplies";

    public SuppliesView(SuppliesRepo suppliesRepo) {

        H1 h1 = new H1("Facility Supplies");

        Grid<Supplies> grid = new Grid<>(Supplies.class, false);
        grid.addColumn(Supplies::getItem).setHeader        ("Item").setSortable(true);
        grid.addColumn(Supplies::getCategory).setHeader("Category").setSortable(true);
        grid.addColumn(Supplies::getQuantity).setHeader("Quantity").setSortable(true);
        grid.addColumn(Supplies::getSupplier).setHeader("Supplier").setSortable(true);

    List<Supplies> supplies = suppliesRepo.findAll();
    grid.setItems(supplies);
    add(h1, grid);


    }
}