package isen.java2.project.controller;

import isen.java2.App;
import isen.java2.project.daos.PersonDao;
import isen.java2.project.entities.Person;
import isen.java2.project.service.ContactService;
import isen.java2.project.utilities.ContactChangeListener;
import isen.java2.project.utilities.ContactValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.*;

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
    private Button saveButton;

    @FXML
    private Button createContactButton;

    @FXML
    private Button saveContactButton;



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
        }
    }

    private void populateList() {
        this.contactsTableView.setItems(ContactService.getContacts());
        this.contactsTableView.refresh();
        resetView();
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
    private void deleteContact() throws IOException {
        int selectedIndex = this.contactsTableView.getSelectionModel().getSelectedIndex();
        personDao.deletePerson(this.currentPerson.getId());
        mySuccessAlerts("Contact Deletion","Contact Deletion Acknowledged", "The Selected Contact has been deleted successfully");
        if (selectedIndex >= 0) {
            contactsTableView.getItems().remove(selectedIndex);
            resetView();
        }
    }

    @FXML
    private void editContact(){

        firstNameTextField.setEditable(true);
        lastNameTextField.setEditable(true);
        nicknameTextField.setEditable(true);
        phoneNumberTextField.setEditable(true);
        streetNameTextField.setEditable(true);
        apartmentTextField.setEditable(true);
        postalCodeTextField.setEditable(true);
        cityTextField.setEditable(true);
        emailTextField.setEditable(true);
        dateOfBirthDatePicker.setEditable(true);

        editContactButton.setVisible(false);
        saveButton.setVisible(true);
    }

    @FXML
    private void saveEditedContacts() throws IOException {
        int id = this.currentPerson.getId();

        System.out.println("Person ID is " + id);
        currentPerson.setLastName(lastNameTextField.getText());
        currentPerson.setFirstName(firstNameTextField.getText());
        currentPerson.setNickName(nicknameTextField.getText());
        currentPerson.setPhoneNumber(phoneNumberTextField.getText());
        currentPerson.setStreet(streetNameTextField.getText());
        currentPerson.setApartment(apartmentTextField.getText());
        currentPerson.setPostalCode(Integer.parseInt(postalCodeTextField.getText()));
        currentPerson.setCity(cityTextField.getText());
        currentPerson.setEmailAddress(emailTextField.getText());
        currentPerson.setBirthDate(dateOfBirthDatePicker.getValue());

        personDao.updatePerson(id, currentPerson);
        saveButton.setVisible(false);
        editContactButton.setVisible(true);

        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        nicknameTextField.setEditable(false);
        phoneNumberTextField.setEditable(false);
        streetNameTextField.setEditable(false);
        apartmentTextField.setEditable(false);
        postalCodeTextField.setEditable(false);
        cityTextField.setEditable(false);
        emailTextField.setEditable(false);
        dateOfBirthDatePicker.setEditable(false);

        mySuccessAlerts("Contact Edit","Contact Edited Successfully", "Your Edit has been acknowledged");
        resetView();
    }

    @FXML
    private void startContactCreation(){
        firstNameTextField.setEditable(true);
        lastNameTextField.setEditable(true);
        nicknameTextField.setEditable(true);
        phoneNumberTextField.setEditable(true);
        streetNameTextField.setEditable(true);
        apartmentTextField.setEditable(true);
        postalCodeTextField.setEditable(true);
        cityTextField.setEditable(true);
        emailTextField.setEditable(true);
        dateOfBirthDatePicker.setEditable(true);
        firstNameTextField.clear();
        lastNameTextField.clear();
        nicknameTextField.clear();
        phoneNumberTextField.clear();
        streetNameTextField.clear();
        apartmentTextField.clear();
        postalCodeTextField.clear();
        cityTextField.clear();
        emailTextField.clear();
        dateOfBirthDatePicker.getEditor().clear();


        editContactButton.setVisible(false);
        saveButton.setVisible(false);
        deleteContactButton.setVisible(false);
        exportIndividualContactButton.setVisible(false);
        saveContactButton.setVisible(true);
    }

    @FXML
    private void addNewContact() throws IOException {
        Person person = new Person();
        PersonDao personDao = new PersonDao();

        person.setLastName(lastNameTextField.getText());
        person.setFirstName(firstNameTextField.getText());
        person.setNickName(nicknameTextField.getText());
        person.setPhoneNumber(phoneNumberTextField.getText());
        person.setStreet(streetNameTextField.getText());
        person.setApartment(apartmentTextField.getText());
        person.setPostalCode(Integer.parseInt(postalCodeTextField.getText()));
        person.setCity(cityTextField.getText());
        person.setEmailAddress(emailTextField.getText());
        person.setBirthDate(dateOfBirthDatePicker.getValue());

        if (lastNameTextField.getText().isEmpty() || firstNameTextField.getText().isEmpty() || nicknameTextField.getText().isEmpty() || phoneNumberTextField.getText().isEmpty() ||
                streetNameTextField.getText().isEmpty() || apartmentTextField.getText().isEmpty() || postalCodeTextField.getText().isEmpty() || cityTextField.getText().isEmpty() ||
                emailTextField.getText().isEmpty() || dateOfBirthDatePicker.getEditor().getText().isEmpty()){
            myErrorAlerts("Error Adding Contact", "Empty Field Detected", "Please Make sure you have no empty field");
        }

        else{
            personDao.addPerson(person);

            firstNameTextField.clear();
            lastNameTextField.clear();
            nicknameTextField.clear();
            phoneNumberTextField.clear();
            streetNameTextField.clear();
            apartmentTextField.clear();
            postalCodeTextField.clear();
            cityTextField.clear();
            emailTextField.clear();
            dateOfBirthDatePicker.getEditor().clear();
            firstNameTextField.setEditable(false);
            lastNameTextField.setEditable(false);
            nicknameTextField.setEditable(false);
            phoneNumberTextField.setEditable(false);
            streetNameTextField.setEditable(false);
            apartmentTextField.setEditable(false);
            postalCodeTextField.setEditable(false);
            cityTextField.setEditable(false);
            emailTextField.setEditable(false);
            dateOfBirthDatePicker.setEditable(false);

            editContactButton.setVisible(true);
            saveButton.setVisible(false);
            deleteContactButton.setVisible(true);
            exportIndividualContactButton.setVisible(true);
            saveContactButton.setVisible(false);

            mySuccessAlerts("Contact Added","New Contact Added", "Your Contact has been added successfully");
            resetView();
            initialize();

            int selectedIndex = this.contactsTableView.getSelectionModel().getSelectedIndex();
            personDao.deletePerson(this.currentPerson.getId());
            if (selectedIndex >= 0) {
                contactsTableView.getItems().remove(selectedIndex);
                resetView();
            }
        }
    }

    @FXML
    private void exportVCard() throws IOException {
        File f = new File ("contact.vcf");
        FileOutputStream fop = new FileOutputStream (f);

        if (f.exists ()) {
            String str = "BEGIN: VCARD \n" + "VERSION: 4.0  \n" +
                    "N:"+currentPerson.getFirstName() + ";"+currentPerson.getLastName()+" \n" +
                    "FN:"+ currentPerson.getNickName()+"\n" +
                    "TEL; TYPE = home, voice; VALUE = uri: tel: "+ currentPerson.getPhoneNumber()+" \n" +
                    "EMAIL: "+ currentPerson.getEmailAddress()+" \n" +
                    "ADR; TYPE=dom,home,postal,parcel:;;"+ currentPerson.getStreet()+";"+currentPerson.getApartment()+";"+currentPerson.getPostalCode()+";"+currentPerson.getCity()+" \n" +
                    "END: VCARD";
            fop.write (str.getBytes ());
            // Now read the content of the vCard after writing data into it
            BufferedReader br = null;
            String sCurrentLine;
            br = new BufferedReader (new FileReader("contact.vcf"));
            // close the output stream and buffer reader
            fop.flush ();
            fop.close ();

            mySuccessAlerts("VCard Status", "VCard Created Successfully", "Check your root file to find your VCard");
        }

        else
            myErrorAlerts("VCard Status","VCard Creation Failed", "Recreate VCard or Check Contact");
    }

    public void mySuccessAlerts(String title, String headerText, String contentText) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public void myErrorAlerts(String title, String headerText, String contentText) throws IOException {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }


}
