package me.ltxom.patientapp.entity;

public class Doctor {
    public String firstName;
    public String lastName;
    public String email;
    public String doctorPassword;

    public Doctor(){}

    public Doctor(String firstName, String lastName, String email, String doctorPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.doctorPassword = doctorPassword;
    }
}
