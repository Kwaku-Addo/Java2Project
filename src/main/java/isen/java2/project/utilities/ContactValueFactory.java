package isen.java2.project.utilities;

import isen.java2.project.entities.Person;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class ContactValueFactory
		implements Callback<CellDataFeatures<Person, String>, ObservableValue<String>> {

	@Override
	public ObservableValue<String> call(CellDataFeatures<Person, String> cellData) {
		return new SimpleStringProperty(cellData.getValue().getFirstName() + " " + cellData.getValue().getLastName());
	}
}
