package isen.java2.project.daos;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import isen.java2.project.entities.Person;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * PersonDatTestCase
 */
public class PersonDaoTestCase {

    private PersonDao personDao = new PersonDao();


	@Before
	public void initDb() throws Exception {
		Connection connection = DataSourceFactory.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(
				"CREATE TABLE IF NOT EXISTS person (\r\n"
				+ "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\r\n" + "  lastname VARCHAR(45) NOT NULL,\r\n"
				+ "  firstname VARCHAR(45) NOT NULL,\r\n" + "  nickname VARCHAR(45) NOT NULL,\r\n"
				+ "  phone_number VARCHAR(15) NULL,\r\n" + "  street VARCHAR(200) NULL,\r\n"
				+ "  apartment VARCHAR(15) NULL,\r\n" + "  postal_code INTEGER(5) NULL,\r\n"
				+ "  city VARCHAR(150) NULL,\r\n" + "  email_address VARCHAR(150) NULL,\r\n" + " birth_date DATE NULL);");

		stmt.executeUpdate("DELETE FROM person");
		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, street, apartment, postal_code, city, email_address, birth_date) "
				+ "VALUES (1, 'Antwi','first name 1','nick name 1','phone 1', '178', '001', 59000, 'Lille', 'email_address 1','1996-08-26 12:00:00.000')");
		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, street, apartment, postal_code, city, email_address, birth_date) "
				+ "VALUES (2, 'Addo','first name 2','nick name 2','phone 2', '119', '201', 59320, 'Haubourdin', 'email_address 2','1997-11-14 12:00:00.000')");
		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, street, apartment, postal_code, city, email_address, birth_date) "
				+ "VALUES (3, 'Bamfo','first name 3','nick name 3','phone 3', '22', '107', 59000, 'Lille', 'email_address 3','2000-11-04 12:00:00.000')");

		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, street, apartment, postal_code, city, email_address, birth_date) "
				+ "VALUES (4, 'Setor','first name 1','nick name 1','phone 1', '178', '001', 59000, 'Lille', 'email_address 1','1996-08-26 12:00:00.000')");
		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, street, apartment, postal_code, city, email_address, birth_date) "
				+ "VALUES (5, 'Ahmed','first name 2','nick name 2','phone 2', '119', '201', 59320, 'Haubourdin', 'email_address 2','1997-11-14 12:00:00.000')");
		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, street, apartment, postal_code, city, email_address, birth_date) "
				+ "VALUES (6, 'Dawuda','first name 3','nick name 3','phone 3', '22', '107', 59000, 'Lille', 'email_address 3','2000-11-04 12:00:00.000')");


		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, street, apartment, postal_code, city, email_address, birth_date) "
				+ "VALUES (7, 'Akweley','first name 1','nick name 1','phone 1', '178', '001', 59000, 'Lille', 'email_address 1','1996-08-26 12:00:00.000')");
		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, street, apartment, postal_code, city, email_address, birth_date) "
				+ "VALUES (8, 'Fatia','first name 2','nick name 2','phone 2', '119', '201', 59320, 'Haubourdin', 'email_address 2','1997-11-14 12:00:00.000')");
		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, street, apartment, postal_code, city, email_address, birth_date) "
				+ "VALUES (9, 'Nkrumah','first name 3','nick name 3','phone 3', '22', '107', 59000, 'Lille', 'email_address 3','2000-11-04 12:00:00.000')");

		stmt.close();
		connection.close();

	}

	@Test
	public void shouldListPersons() {
		List<Person> persons = personDao.listPersons();
		Assertions.assertThat(persons).hasSize(9);
//		Assertions.assertThat(films).extracting(new String[]{"id", "title", "releaseDate", "genre.id", "duration", "director", "summary"}).containsOnly(new Tuple[]{Assertions.tuple(new Object[]{1, "Title 1", LocalDate.parse("2015-11-26"), 1, 120, "director 1", "summary of the first film"}), Assertions.tuple(new Object[]{2, "My Title 2", LocalDate.parse("2015-11-14"), 2, 114, "director 2", "summary of the second film"}), Assertions.tuple(new Object[]{3, "Third title", LocalDate.parse("2015-12-12"), 2, 176, "director 3", "summary of the third film"})});
	}
}