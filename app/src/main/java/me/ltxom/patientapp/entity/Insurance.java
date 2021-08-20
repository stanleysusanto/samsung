package me.ltxom.patientapp.entity;

public class Insurance {
    public String providerName;
    public String insuranceID;
    public String planType;
    public String rXGroup;

    public Insurance(){}

    public Insurance(String providerName, String insuranceID, String planType,
                     String rXGroup) {
        this.providerName = providerName;
        this.insuranceID = insuranceID;
        this.planType = planType;
        this.rXGroup = rXGroup;
    }
}
