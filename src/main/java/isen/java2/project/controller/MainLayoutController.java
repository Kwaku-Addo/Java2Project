package isen.java2.project.controller;

import isen.java2.App;
import javafx.application.Platform;

import java.io.IOException;

public class MainLayoutController {

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
        App.showView("AllContactsLayout");
    }

    public void gotoAddContacts() throws IOException {
        App.showView("AddContactLayout");
    }


}
