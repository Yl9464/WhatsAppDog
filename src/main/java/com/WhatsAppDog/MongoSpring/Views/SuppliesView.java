package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.SuppliesController;
import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Supplies;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.Collection;

@Route(value = SuppliesView.ROUTE, layout = MainView.class)

public class SuppliesView extends VerticalLayout {
    public static final String ROUTE = "supplies";

    private final SuppliesController suppliesController;
    GridCrud<Supplies> crud;
    TextField searchTerm = new TextField();

    @Autowired
    public SuppliesView(SuppliesController suppliesController ) {
        this.suppliesController = suppliesController;
        crud = new GridCrud<>(Supplies.class);
        crud.setCrudListener(new CrudListener<Supplies>() {
            @Override
            public Collection<Supplies> findAll() {
                return suppliesController.findAll();
            }

            @Override
            public Supplies add(Supplies supplies) {
                return suppliesController.add(supplies);
            }

            @Override
            public Supplies update(Supplies supplies) {
                return suppliesController.update(supplies);
            }

            @Override
            public void delete(Supplies supplies) {
                suppliesController.delete(supplies);
            }
        });
        H1 h1 = new H1("Facility Supplies");

        crud.getGrid().removeAllColumns(); //remove default headers
        //readd custom headers
        crud.getGrid().addColumn(Supplies::getCategory).setHeader("Category").setSortable(true);
        crud.getGrid().addColumn(Supplies::getItem).setHeader("Item").setSortable(true);
        crud.getGrid().addColumn(Supplies::getQuantity).setHeader("Quantity").setSortable(true);
        crud.getGrid().addColumn(Supplies::getSupplier).setHeader("Supplier").setSortable(true);

        //Search Bar
        searchTerm.setPlaceholder("Enter Item or Category...");
        searchTerm.setClearButtonVisible(true);
        searchTerm.setWidth("300px");


        searchTerm.setValueChangeMode(ValueChangeMode.EAGER);
        searchTerm.addValueChangeListener(e ->
                crud.getGrid().setItems(suppliesController.searchItem(e.getValue())));

        // CRUD operations
        crud.setAddOperation(suppliesController::add);
        crud.setUpdateOperation(suppliesController::update);
        crud.setDeleteOperation(suppliesController::delete);
        crud.setFindAllOperation(suppliesController::findAll);

        add(h1, searchTerm, crud);
        setSizeFull();

    }

}