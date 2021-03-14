package isen.java2.project.utilities;

import isen.java2.project.entities.Person;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public abstract class ContactChangeListener implements ChangeListener<Person> {

	@Override
	public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
		handleNewValue(newValue);

	}

	public abstract void handleNewValue(Person newValue);

}
