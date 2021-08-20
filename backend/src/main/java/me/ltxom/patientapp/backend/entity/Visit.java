package me.ltxom.patientapp.backend.entity;

import java.util.List;

public class Visit {
    public String visitID;
    public String location;
    public String admissionRoom;
    public String personResponsibleForAdmission;
    public String startDateTime;
    public String endDateTime;
    public String typeOfVisit;
    public String reasonForVisit;
    public String symptoms;
    public String timeSinceSymptoms;
    public String qRCode;
    public String paymentMade;
    public List<TimeLine> timelines;

    public Visit(){}

    public Visit(String visitID, String location, String admissionRoom,
                 String personResponsibleForAdmission, String startDateTime,
                 String endDateTime, String typeOfVisit, String reasonForVisit,
                 String symptoms, String timeSinceSymptoms, String qRCode,
                 String paymentMade, List<TimeLine> timelines) {
        this.visitID = visitID;
        this.location = location;
        this.admissionRoom = admissionRoom;
        this.personResponsibleForAdmission = personResponsibleForAdmission;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.typeOfVisit = typeOfVisit;
        this.reasonForVisit = reasonForVisit;
        this.symptoms = symptoms;
        this.timeSinceSymptoms = timeSinceSymptoms;
        this.qRCode = qRCode;
        this.paymentMade = paymentMade;
        this.timelines = timelines;
    }
}
