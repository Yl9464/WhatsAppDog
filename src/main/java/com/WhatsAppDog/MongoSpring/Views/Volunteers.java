package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Repository.StaffRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route(value=Volunteers.ROUTE, layout = MainView.class)

public class Volunteers extends Div{
    public static  final String ROUTE = "volunteers";
    private StaffRepo staffRepo;

    //TextField searchTerm = new TextField();
    public Volunteers(StaffRepo staff) {
        // Div volLayout = new Div();
        H1 volTitle = new H1("Active Volunteers");
        GridCrud<Staff> crud = new GridCrud<>(Staff.class);
        Grid<Staff> grid = crud.getGrid(); //access internal grid
        grid.removeAllColumns(); //remove default headers
        //add headers
        grid.addColumn(Staff::getFirstName).setHeader("First Name");
        grid.addColumn(Staff::getLastName).setHeader("Last Name");
        grid.addColumn(Staff::getEmail).setHeader("Email");
        grid.addColumn(Staff::getJobTitle).setHeader("Position");

        crud.setFindAllOperation(staff::findAll);
        crud.setAddOperation(staff::save);

//        List<Staff> staff = staffRepo.findAll();
        //add data
        for (int i = 1; i <= 10; i++) {
            Staff vol = new Staff();
            vol.setFirstName("First Name" + i);
            vol.setLastName("LastName" + i);
            staff.save(vol);
        }
        //refresh grid
        crud.refreshGrid();
        add(volTitle, crud);
    }
}
