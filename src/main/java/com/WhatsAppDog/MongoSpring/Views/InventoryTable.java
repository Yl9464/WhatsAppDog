package com.WhatsAppDog.MongoSpring.Views;
import com.WhatsAppDog.MongoSpring.MainLayout;
import com.WhatsAppDog.MongoSpring.Model.Supplies;
import com.WhatsAppDog.MongoSpring.Repository.SuppliesRepo;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

import static java.lang.Integer.valueOf;


@Route(value = InventoryTable.ROUTE, layout = MainLayout.class)
public class InventoryTable extends VerticalLayout {

    public static final String ROUTE = "supplies";
    public static final String TITLE = "Supplies";


    public InventoryTable(SuppliesRepo suppliesRepo) {

        GridCrud<Supplies> suppliesCrud = new GridCrud<>(Supplies.class);
        suppliesCrud.setFindAllOperation(suppliesRepo::findAll);

        add(suppliesCrud);
        setSizeFull();

    }
}