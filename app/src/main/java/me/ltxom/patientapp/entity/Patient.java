package me.ltxom.patientapp.entity;

import java.util.List;

public class Patient {

    public String patientId;

    public String firstName;
    public String lastName;
    public String phone;
    public String email;
    public String icon;
    public Address address;

    public Insurance insurance;

    public List<Visit> visits;

    public Patient() {
    }

    public Patient(String patientId, String firstName, String lastName, String phone,
                   String email, Address address, Insurance insurance, List<Visit> visits,String icon) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.insurance = insurance;
        this.visits = visits;
        this.icon  = icon;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", insurance=" + insurance +
                ", visits=" + visits +
                '}';
    }
}
