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
    private TextField addFirstNameTextField;

    @FXML
    private TextField addLastNameTextField;

    @FXML
    private TextField addNicknameTextField;

    @FXML
    private TextField addPhoneNumberTextField;

    @FXML
    private TextField addEmailTextField;

    @FXML
    private TextField addStreetNameTextField;

    @FXML
    private TextField addApartmentTextField;

    @FXML
    private TextField addPostalCodeTextField;

    @FXML
    private TextField addCityTextField;

    @FXML
    private DatePicker addDateOfBirthDatePicker;

    @FXML
    private Button saveContactButton;




    public void addContact() throws IOException {
        Person person = new Person();
        PersonDao personDao = new PersonDao();

        person.setLastName(addLastNameTextField.getText());
        person.setFirstName(addFirstNameTextField.getText());
        person.setNickName(addNicknameTextField.getText());
        person.setPhoneNumber(addPhoneNumberTextField.getText());
        person.setStreet(addStreetNameTextField.getText());
        person.setApartment(addApartmentTextField.getText());
        person.setPostalCode(Integer.valueOf(addPostalCodeTextField.getText()));
        person.setCity(addCityTextField.getText());
        person.setEmailAddress(addEmailTextField.getText());
        person.setBirthDate(addDateOfBirthDatePicker.getValue());

       personDao.addPerson(person);
    }
}
