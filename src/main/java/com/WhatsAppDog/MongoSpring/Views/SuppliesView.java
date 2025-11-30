package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Supplies;
import com.WhatsAppDog.MongoSpring.Repository.SuppliesRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route(value = SuppliesView.ROUTE, layout = MainView.class)
public class SuppliesView extends VerticalLayout {

    public static final String ROUTE = "supplies";

    public SuppliesView(SuppliesRepo supplies) {

        H1 h1 = new H1("Facility Supplies");
        GridCrud<Supplies> crud = new GridCrud<>(Supplies.class);
        Grid<Supplies> grid = crud.getGrid(); //access internal grid
        grid.removeAllColumns(); //remove default headers

        //readd custom headers
        grid.addColumn(Supplies::getCategory).setHeader("Category").setSortable(true);
        grid.addColumn(Supplies::getItem).setHeader("Item").setSortable(true);
        grid.addColumn(Supplies::getQuantity).setHeader("Quantity").setSortable(true);
        grid.addColumn(Supplies::getSupplier).setHeader("Supplier").setSortable(true);

        //add Data
        crud.setFindAllOperation(supplies::findAll);
        crud.setAddOperation(supplies::save);
        //low stock

        add(h1, crud);
        setSizeFull();

    }

}