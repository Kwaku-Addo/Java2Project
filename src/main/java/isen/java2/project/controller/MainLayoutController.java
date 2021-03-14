package isen.java2.project.controller;

import isen.java2.App;
import isen.java2.project.entities.Person;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.io.IOException;

public class MainLayoutController {

    @FXML
    private TableView<Person> contactsTableView;


    public void closeApplication() {
        Platform.exit();
    }

    /**
     * Method allowing us to go back to the home screen
     * @throws IOException
     */
    public void gotoHome() throws IOException {
        App.showView("Home");
    }

    public void gotoAllContacts() throws IOException {
        AllContactsLayoutController allContactsLayoutController = new AllContactsLayoutController();
        //allContactsLayoutController.resetView();
        App.showView("AllContactsLayout");

    }

    public void gotoAddContacts() throws IOException {
        App.showView("AddContactLayout");
    }


}
