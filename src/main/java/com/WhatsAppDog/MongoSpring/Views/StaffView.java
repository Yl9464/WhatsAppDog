package com.WhatsAppDog.MongoSpring.Views;


import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Repository.StaffRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route(value = StaffView.ROUTE, layout= MainView.class)
public class StaffView extends VerticalLayout{

    public static final String ROUTE = "staff";

    @Autowired
    private StaffRepo staffRepo;
    GridCrud<Staff> crud = new GridCrud<>(Staff.class);
    Grid<Staff> grid = crud.getGrid(); //access internal grid
    TextField searchTerm = new TextField();

    public StaffView(StaffRepo staff)  {

        H1 h1  = new H1("Staff Members");

        grid.removeAllColumns(); //remove default headers
        //readd custom headers
        grid.addColumn(Staff::getFirstName).setHeader("First Name").setSortable(true);;
        grid.addColumn(Staff::getLastName).setHeader("Last Name").setSortable(true);;
        grid.addColumn(Staff::getEmail).setHeader("Email").setSortable(true);;
        crud.getGrid().addColumn(person ->
                person.isEmployee() ? "Employee" : "Volunteer"
        ).setHeader("Staff Type").setSortable(true);;

        grid.addColumn(Staff::getSalary).setHeader("Salary").setSortable(true);;

        crud.setFindAllOperation(staff::findAll);
        crud.setAddOperation(staff::save);

//search bar
        searchTerm.setPlaceholder("Enter name...");
        searchTerm.setClearButtonVisible(true);
        searchTerm.setWidth("300px");

        searchTerm.setValueChangeMode(ValueChangeMode.EAGER);
        searchTerm.addValueChangeListener(e -> {
                    String value = e.getValue();
                    crud.getGrid().setItems(staffRepo.searchPerson(value));
                });

        add(h1, searchTerm, crud);
        setSizeFull();

    }
}
