package me.ltxom.patientapp.backend.entity;

public class Address {
    public String street1;
    public String street2;
    public String city;
    public String state;
    public String zipCode;

    public Address(){}

    public Address(String street1, String street2, String city, String state, String zipCode) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}
