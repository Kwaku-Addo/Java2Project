package isen.java2.project.controller;

import isen.java2.project.daos.PersonDao;
import isen.java2.project.entities.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddContactLayoutController {

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
    private Button saveContactButton;

    AllContactsLayoutController allContactsLayoutController = new AllContactsLayoutController();
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
            allContactsLayoutController.myErrorAlerts("Error Adding Contact", "Empty Field Detected", "Please Make sure you have no empty field");
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


            allContactsLayoutController.mySuccessAlerts("Contact Added","New Contact Added", "Your Contact has been added successfully");
        }

    }
}
