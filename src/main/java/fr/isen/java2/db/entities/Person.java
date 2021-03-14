package fr.isen.java2.db.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Person
 */
public class Person {

    private Integer id;
    private String lastName;
    private String firstName;
    private String nickName;
    private String phoneNumber;
    private String street;
    private String apartment;
    private int postalCode;
    private String city;
    private String emailAddress;
    private LocalDate birthDate;

    public Person(){
    
    }

    public Person(Integer id, String lastName, String firstName, String nickName, String phoneNumber, String street, String apartment, int postalCode, String city, String emailAddress, LocalDate birthDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.apartment = apartment;
        this.postalCode = postalCode;
        this.city = city;
        this.emailAddress = emailAddress;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public String getAddress() {
//        return this.address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person id(Integer id) {
        setId(id);
        return this;
    }

    public Person lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Person firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Person nickName(String nickName) {
        setNickName(nickName);
        return this;
    }

    public Person phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

//    public Person address(String address) {
//        setAddress(address);
//        return this;
//    }

    public Person emailAddress(String emailAddress) {
        setEmailAddress(emailAddress);
        return this;
    }

    public Person birthDate(LocalDate birthDate) {
        setBirthDate(birthDate);
        return this;
    }

    public Person street(String street){
        setStreet(street);
        return this;
    }

    public Person apartment(String apartment){
        setApartment(apartment);
        return this;
    }

    public Person postalCode(int postalCode){
        setPostalCode(postalCode);
        return this;
    }

    public Person city(String city){
        setCity(city);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(nickName, person.nickName) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(street, person.street) && Objects.equals(apartment, person.apartment) && Objects.equals(postalCode, person.postalCode) && Objects.equals(city, person.city) && Objects.equals(emailAddress, person.emailAddress) && Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, nickName, phoneNumber, street, apartment, postalCode, city, emailAddress, birthDate);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", nickName='" + getNickName() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", address='" + getStreet() + "'" +
            ", address='" + getApartment() + "'" +
            ", address='" + getPostalCode() + "'" +
            ", address='" + getCity() + "'" +
            ", emailAddress='" + getEmailAddress() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            "}";
    }

}

