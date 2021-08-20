package me.ltxom.patientapp.entity;

public class TimeLine {
    public String actionID;
    public String actionType;
    public String actionReason;
    public String entryDateTime;
    public String providerName;
    public String providerType;
    public String locationRoom;
    public String locationBedNumber;
    public String details;

    public TimeLine() {
    }

    public TimeLine(String actionID, String actionType, String actionReason,
                    String entryDateTime, String providerName, String providerType,
                    String locationRoom, String locationBedNumber, String details) {
        this.actionID = actionID;
        this.actionType = actionType;
        this.actionReason = actionReason;
        this.entryDateTime = entryDateTime;
        this.providerName = providerName;
        this.providerType = providerType;
        this.locationRoom = locationRoom;
        this.locationBedNumber = locationBedNumber;
        this.details = details;
    }

    @Override
    public String toString() {
        return "TimeLine{" +
                "actionID='" + actionID + '\'' +
                ", actionType='" + actionType + '\'' +
                ", actionReason='" + actionReason + '\'' +
                ", entryDateTime='" + entryDateTime + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerType='" + providerType + '\'' +
                ", locationRoom='" + locationRoom + '\'' +
                ", locationBedNumber='" + locationBedNumber + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
