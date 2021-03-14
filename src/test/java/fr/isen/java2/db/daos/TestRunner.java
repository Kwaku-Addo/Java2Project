package fr.isen.java2.db.daos;

import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("TestRunner for Person");

        PersonDaoTestCase test = new PersonDaoTestCase();

        try {
            test.initDb();
            System.out.println("DataBase initiated");


        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
           
        sc.close();
        
    }
}
