package isen.java2.project.controller;

import isen.java2.project.entities.Person;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AllContactsLayoutController {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField nicknameTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField streetNameTextField;

    @FXML
    private TextField apartmentTextField;

    @FXML
    private TextField postalCodeTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private DatePicker dateOfBirthDatePicker;

    @FXML
    private TableView <Person> contactsTableView;

    @FXML
    private TableColumn contactsTableColumn;

    @FXML
    private Button editContactButton;

    @FXML
    private Button deleteContactButton;

    @FXML
    private Button exportIndividualContactButton;

}
