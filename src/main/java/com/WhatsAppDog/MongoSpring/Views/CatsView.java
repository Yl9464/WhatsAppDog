//package com.WhatsAppDog.MongoSpring.Views;
//
//import com.WhatsAppDog.MongoSpring.Controller.AnimalController;
//import com.WhatsAppDog.MongoSpring.MainView;
//import com.WhatsAppDog.MongoSpring.Model.Animal;
//import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.dependency.CssImport;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.html.H4;
//import com.vaadin.flow.component.html.Image;
//import com.vaadin.flow.component.html.Span;
//import com.vaadin.flow.component.icon.Icon;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.server.streams.DownloadHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//@CssImport("./styles/styles.css")
//@Route(value= CatsView.ROUTE, layout = MainView.class)
//
//public class CatsView extends VerticalLayout {
//    public static final String ROUTE = "cats";
//
//    private final AnimalController animalController;
//    private final Grid<Animal> grid = new Grid<>(Animal.class, false);
//    private final Div cardContainer = new Div();
//
//    @Autowired
//    public CatsView(AnimalController animalController) {
//        this.animalController = animalController;
//        setSizeFull();
//        setSpacing(true);
//        configureGrid();
//        configureCardGrid();
//
//        //ADD
////        Button addBtn = new Button("Add Cat", new Icon(VaadinIcon.PLUS));
////        addBtn.addClickListener(e -> {
////            addForm form = new addForm(this::saveAnimal);
////            form.open(new Animal());
////        });
//
//        //LEFT
//        VerticalLayout layoutLeft = new VerticalLayout();
//        layoutLeft.setSizeFull();
//        layoutLeft.setPadding(false);
//        layoutLeft.setSpacing(false);
//
//
//        //RIGHT Cards
//        cardContainer.setSizeFull();
//        //Layout
//        add(layoutLeft,addBtn, cardContainer);
//        setFlexGrow(1, layoutLeft);
//        setFlexGrow(2, cardContainer);
//
//        refreshAll();
//    }
//
//    private void configureGrid() {
//        grid.removeAllColumns();
//        grid.addColumn(Animal::getName).setHeader("Name");
//        grid.addColumn(Animal::getAge).setHeader("Age");
//        grid.addColumn(Animal::getType).setHeader("Type");
//
//        grid.addColumn(a -> a.isAggressive() ? "Use Caution" : "No").setHeader("Aggression Status");
//        grid.addColumn(a -> a.isFemale() ? "Female" : "Male").setHeader("Gender");
//
////        grid.asSingleSelect().addValueChangeListener(e -> {
////            if (e.getValue() != null) {
////              //  addForm form = new addForm(this::saveAnimal);
////                form.open(e.getValue());
////            }
////        });
//
//        grid.addComponentColumn(a -> {
//            Button delete = new Button("Delete");
//            delete.addClickListener(e -> {
//                animalController.delete(a);
//                refreshAll();
//            });
//            return delete;
//        }).setHeader("Delete?");
//    }
//
//    private void configureCardGrid() {
//        cardContainer.getStyle()
//                .set("display", "grid")
//                .set("grid-template-columns", "repeat(3, 1fr)")   // 🔥 EXACTLY 3 CARDS PER ROW
//                .set("gap", "20px")
//                .set("padding", "20px");
//        addClassName("card-container");
//    }
//    private void refreshAll() {
//        List<Animal> list = animalController.findAll();
//        grid.setItems(list);
//        refreshCards(list);
//    }
//
//    private void refreshCards(List<Animal> animal) {
//        cardContainer.removeAll();
//        animal.forEach(s -> cardContainer.add(createCard(s)));
//    }
//
//    private Component createCard(Animal animal) {
//        VerticalLayout catCard = new VerticalLayout();
//
//        catCard.getStyle()
//                .set("border", "1px solid var(--lumo-contrast-20pct)")
//                .set("border-radius", "10px")
//                .set("padding", "15px")
//                .set("background-color", "white")
//                .set("box-shadow", "var(--lumo-box-shadow-s)");
//
//        DownloadHandler imageHandler = DownloadHandler.forClassResource(
//                getClass(),  animal.getImageUrl(), "Animal Pic");
//        Image catImage = new Image(imageHandler, "");
//        catImage.setWidth("200px");
//        catImage.setWidth("200px");
//
//        H4 name = new H4(animal.getName());
//        Span age = new Span("Age: " + animal.getAge());
//        Span aggression = new Span("Aggression: " + (animal.isAggressive() ? "Use caution" : "No"));
//        Span gender = new Span(animal.isFemale() ? "Female" : "Male");
//
////        Button edit = new Button("Edit", e -> {
////            addForm form = new addForm(this::saveAnimal);
////            form.open(animal);
////        });
//        Button del = new Button("Delete", e -> {
//            animalController.delete(animal);
//            refreshAll();
//        });
//
//        //catCard.add(catImage, name, age, aggression, gender, new HorizontalLayout(edit, del));
//
//        return catCard;
//    }
//
//}
