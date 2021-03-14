package isen.java2.project.daos;

import java.util.List;

import isen.java2.project.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * PersonDao
 */
public class PersonDao {

    public List<Person> listPersons() {
		List<Person> listPerson = new ArrayList<>();
		try (Connection connection = DataSourceFactory.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet results = statement.executeQuery("SELECT * FROM person")) {
					while (results.next()) {
                        Person person = new Person(results.getInt("id"),
                                                    results.getString("lastname"),
                                                    results.getString("firstname"),
                                                    results.getString("nickname"),
                                                    results.getString("phone_number"),
                                                    results.getString("street"),
													results.getString("apartment"),
													results.getInt("postal_code"),
													results.getString("city"),
                                                    results.getString("email_address"),
                                                    results.getDate("birth_date").toLocalDate());
						
						listPerson.add(person);
					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listPerson;
		//throw new RuntimeException("Method is not yet implemented");
	}

    public void addPerson(Person person) {
		try (Connection connection = DataSourceFactory.getDataSource().getConnection()) {
			String sqlQuery = "INSERT INTO person(lastname,firstname,nickname,phone_number," +
                                "street,apartment,postal_code,city,email_address,birth_date)" +
                                "VALUES(?,?,?,?,?,?,?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(
							sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, person.getLastName());
				statement.setString(2, person.getFirstName());
				statement.setString(3, person.getNickName());
				statement.setString(4, person.getPhoneNumber());
				statement.setString(5, person.getStreet());
				statement.setString(6, person.getApartment());
				statement.setInt(7, person.getPostalCode());
				statement.setString(8, person.getCity());
                statement.setString(9, person.getEmailAddress());
                statement.setDate(10, Date.valueOf(person.getBirthDate()));
				statement.executeUpdate();
				connection.close();
			}
		}catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
    }

    public void updatePerson(Integer id, Person person){
        try (Connection connection = DataSourceFactory.getDataSource().getConnection()) {
			String sqlQuery = "UPDATE person SET lastname = ?, firstname = ?, nickname = ?, phone_number = ?," + 
                            "street = ?, apartment = ?, postal_code = ?, city = ?, email_address = ?, birth_date = ? WHERE id = ?";
                                
			try (PreparedStatement statement = connection.prepareStatement(
							sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, person.getLastName());
				statement.setString(2, person.getFirstName());
				statement.setString(3, person.getNickName());
				statement.setString(4, person.getPhoneNumber());
				statement.setString(5, person.getStreet());
				statement.setString(6, person.getApartment());
				statement.setInt(7, person.getPostalCode());
				statement.setString(8, person.getCity());
                statement.setString(9, person.getEmailAddress());
                statement.setDate(10, Date.valueOf(person.getBirthDate()));
                statement.setInt(11, id);
				statement.executeUpdate();
				connection.close();
			}
		}catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
    }

    
    /*public void deletePerson(Person person){
        try (Connection connection = DataSourceFactory.getDataSource().getConnection()) {
			String sqlQuery = "DELETE FROM person WHERE id = ?";

			try (PreparedStatement statement = connection.prepareStatement(
							sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
				statement.setInt(1, person.getId());
				statement.executeUpdate();
				connection.close();
			}
		}catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
    }*/

    public void deletePerson(Integer id){
        try (Connection connection = DataSourceFactory.getDataSource().getConnection()) {
			String sqlQuery = "DELETE FROM person WHERE id = ?";
                                
			try (PreparedStatement statement = connection.prepareStatement(
							sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
				statement.setInt(1, id);
				statement.executeUpdate();
				connection.close();
			}
		}catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
    }

}
