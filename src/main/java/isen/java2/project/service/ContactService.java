package isen.java2.project.service;

import isen.java2.project.daos.PersonDao;
import isen.java2.project.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ContactService {

	private ObservableList<Person> contacts;

	PersonDao personDao = new PersonDao();

	private ContactService() {
		contacts = FXCollections.observableArrayList(personDao.listPersons());
	}

	public static ObservableList<Person> getContacts() {
		return ContactServiceHolder.INSTANCE.contacts;
	}


	private static class ContactServiceHolder {
		private static final ContactService INSTANCE = new ContactService();
	}

}
