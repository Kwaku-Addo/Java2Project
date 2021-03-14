package isen.java2.project.controller;

import isen.java2.App;
import isen.java2.project.daos.PersonDao;
import isen.java2.project.entities.Person;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainLayoutController {

    @FXML
    private TableView<Person> contactsTableView;


    public void closeApplication() {
        Platform.exit();
    }

    /**
     * Method allowing us to go back to the home screen
     * @throws IOException
     */
    public void gotoHome() throws IOException {
        App.showView("Home");
    }

    public void gotoAllContacts() throws IOException {
        App.showView("AllContactsLayout");

    }

    public void gotoAddContacts() throws IOException {
        App.showView("AddContactLayout");
    }

    PersonDao personDao = new PersonDao();
    Person person = new Person();

    private List contact;

    @FXML
    private void exportToExcel() throws IOException {
        try{
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Java Books");
            contact = personDao.listPersons();

            int rowCount = 0;

            for (Object person: contact){
                Row row = sheet.createRow(rowCount ++);
                createList((Person) person, row);
            }

            FileOutputStream out = new FileOutputStream(new File("ContactList.xlsx")); // file name with path
            workbook.write(out);
            out.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void createList(Person person, Row row) // creating cells for each row
    {
        Cell cell = row.createCell(0);
        cell.setCellValue(person.getFirstName());

        cell = row.createCell(1);
        cell.setCellValue(person.getLastName());

        cell = row.createCell(2);
        cell.setCellValue(person.getNickName());

        cell = row.createCell(3);
        cell.setCellValue(person.getBirthDate().toString());

        cell = row.createCell(4);
        cell.setCellValue(person.getNickName());

        cell = row.createCell(5);
        cell.setCellValue(person.getEmailAddress());

        cell = row.createCell(6);
        cell.setCellValue(person.getStreet());

        cell = row.createCell(7);
        cell.setCellValue(person.getApartment());

        cell = row.createCell(8);
        cell.setCellValue(person.getPostalCode());

        cell = row.createCell(9);
        cell.setCellValue(person.getCity());
    }
}
