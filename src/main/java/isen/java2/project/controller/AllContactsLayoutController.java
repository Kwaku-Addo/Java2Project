package isen.java2.project.controller;

import isen.java2.project.daos.PersonDao;
import isen.java2.project.entities.Person;
import isen.java2.project.service.ContactService;
import isen.java2.project.utilities.ContactChangeListener;
import isen.java2.project.utilities.ContactValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

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
    private TableColumn <Person, String> contactsTableColumn;

    @FXML
    private Button editContactButton;

    @FXML
    private Button deleteContactButton;

    @FXML
    private Button exportIndividualContactButton;

    @FXML
    private VBox contactDetailsVbox;
    Person currentPerson;
    PersonDao personDao = new PersonDao();

    private void showContactDetails(Person person) {
        if (person == null) {
//            this.contactsDetailsVBox.setVisible(false);
        } else {
//            this.contactsDetailsVBox.setVisible(true);
            this.currentPerson = person;
            this.firstNameTextField.setText(currentPerson.getFirstName());
            this.lastNameTextField.setText(currentPerson.getLastName());
            this.nicknameTextField.setText(currentPerson.getNickName());
            this.phoneNumberTextField.setText(currentPerson.getPhoneNumber());
            this.streetNameTextField.setText(currentPerson.getStreet());
            this.apartmentTextField.setText(currentPerson.getApartment());
            this.postalCodeTextField.setText(String.valueOf(currentPerson.getPostalCode()));
            this.cityTextField.setText(currentPerson.getCity());
            this.emailTextField.setText(currentPerson.getEmailAddress());
            this.dateOfBirthDatePicker.setValue(currentPerson.getBirthDate());
            System.out.println("Current Person is " + this.currentPerson.getLastName());
        }
    }

    private void populateList() {
        this.contactsTableView.setItems(ContactService.getContacts());
        this.contactsTableView.refresh();
    }

    @FXML
    public void initialize(){
        this.contactsTableColumn.setCellValueFactory(new ContactValueFactory());
        this.populateList();
        this.contactsTableView.getSelectionModel().selectedItemProperty().addListener(new ContactChangeListener() {
            // here we use the QuizChangeListener. Itt's value is only to avoid you the boilerplate code
            // of the original ChangleListener Method
            @Override
            public void handleNewValue(Person newValue) {
                showContactDetails(newValue);

            }
        });
        this.resetView();
    }

    private void resetView() {
        this.showContactDetails(null);
        this.refreshList();
    }

    private void refreshList() {
        this.contactsTableView.refresh();
        this.contactsTableView.getSelectionModel().clearSelection();
    }

    @FXML
    private void deleteContact() {
        int selectedIndex = this.contactsTableView.getSelectionModel().getSelectedIndex();

        System.out.println("Deleted Person is "+currentPerson.getLastName());
        personDao.deletePerson(this.currentPerson.getId());
        if (selectedIndex >= 0) {
            contactsTableView.getItems().remove(selectedIndex);
            resetView();
        }
    }

    private void editContact(){

    }
}
