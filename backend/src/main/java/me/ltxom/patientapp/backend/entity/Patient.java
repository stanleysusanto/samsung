package me.ltxom.patientapp.backend.entity;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.data.annotation.Id;

import javax.annotation.Generated;
import java.util.List;


public class Patient {
    @Id
    public String patientId;

    public String firstName;
    public String lastName;
    public String phone;
    public String email;

    public Address address;

    public Insurance insurance;

    public List<Visit> visits;

    public Patient(){}

    public Patient(String patientId, String firstName, String lastName, String phone,
                   String email, Address address, Insurance insurance, List<Visit> visits) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.insurance = insurance;
        this.visits = visits;
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
