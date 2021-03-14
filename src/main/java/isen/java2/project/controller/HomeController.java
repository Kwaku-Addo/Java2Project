package isen.java2.project.controller;

import isen.java2.App;

import java.io.IOException;

public class HomeController {
    /**
     * Method allowing us to go back to the home screen
     * @throws IOException
     */
    public void gotoAllContacts() throws IOException {
        App.showView("AllContactsLayout");
    }

}
