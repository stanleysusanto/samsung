package me.ltxom.patientapp.backend.controller;

import me.ltxom.patientapp.backend.entity.*;
import me.ltxom.patientapp.backend.repo.PatientRepo;
import me.ltxom.patientapp.backend.util.ActionResult;
import me.ltxom.patientapp.backend.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientRepo patientRepo;

    @RequestMapping(value = "listPatients", method = RequestMethod.GET)
    public ActionResult listPatients() {
        List<Patient> patientList = patientRepo.findAll();

        return ActionResult.genActionResultByOk(patientList);
    }

    @RequestMapping(value = "removePatient", method = RequestMethod.GET)
    public ActionResult removePatient(@RequestParam String patientid) {
        patientRepo.deleteById(patientid);

        return ActionResult.genActionResultByOk();
    }

    @RequestMapping(value = "clear", method = RequestMethod.GET)
    public ActionResult clear() {
        patientRepo.deleteAll();

        return ActionResult.genActionResultByOk();
    }

    @RequestMapping(value = "updateProfile", method = RequestMethod.GET)
    public ActionResult updateProfile(@RequestParam(required = false) String patientid,
                                      @RequestParam String firstname,
                                      @RequestParam String lastname,
                                      @RequestParam String phone,
                                      @RequestParam String email) {
        Patient patient = new Patient();
        patient.patientId = patientid;
        patient.firstName = firstname;
        patient.lastName = lastname;
        patient.phone = phone;
        patient.email = email;
        patient.address = new Address();
        patient.insurance = new Insurance();
        patient.visits = new ArrayList<>();
        patientRepo.save(patient);

        return ActionResult.genActionResultByOk();
    }

    @RequestMapping(value = "saveAddress", method = RequestMethod.GET)
    public ActionResult saveAddress(@RequestParam String patientid,
                                    @RequestParam String street1,
                                    @RequestParam(required = false) String street2,
                                    @RequestParam String city, @RequestParam String state,
                                    @RequestParam String zipcode) {
        Patient patient = patientRepo.findByPatientId(patientid);
        if (patient == null)
            return ActionResult.genActionResult(ResultCode.NOT_EXIST);
        Address address = patient.address;
        address.street1 = street1;
        address.street2 = street2;
        address.city = city;
        address.state = state;
        address.zipCode = zipcode;

        patientRepo.save(patient);

        return ActionResult.genActionResultByOk();
    }

    @RequestMapping(value = "saveInsurance", method = RequestMethod.GET)
    public ActionResult saveInsurance(@RequestParam String patientid,
                                      @RequestParam String providername,
                                      @RequestParam String insuranceid,
                                      @RequestParam String plantype,
                                      @RequestParam String rxgroup) {
        Patient patient = patientRepo.findByPatientId(patientid);
        if (patient == null)
            return ActionResult.genActionResult(ResultCode.NOT_EXIST);
        Insurance insurance = patient.insurance;
        insurance.providerName = providername;
        insurance.insuranceID = insuranceid;
        insurance.planType = plantype;
        insurance.rXGroup = rxgroup;

        patientRepo.save(patient);

        return ActionResult.genActionResultByOk();
    }

    @RequestMapping(value = "addVisit", method = RequestMethod.GET)
    public ActionResult addVisit(@RequestParam String patientid,
                                 @RequestParam String location,
                                 @RequestParam String admissionroom,
                                 @RequestParam String personresponsibleforadmission,
                                 @RequestParam String startdatetime,
                                 @RequestParam String enddatetime,
                                 @RequestParam String typeofvisit,
                                 @RequestParam String reasonforvisit,
                                 @RequestParam String symptoms,
                                 @RequestParam String timesincesymptoms,
                                 @RequestParam String qrcode,
                                 @RequestParam String paymentmade) {
        Patient patient = patientRepo.findByPatientId(patientid);
        if (patient == null)
            return ActionResult.genActionResult(ResultCode.NOT_EXIST);
        List<Visit> visits = patient.visits;
        Visit visit = new Visit();
        visits.add(visit);
        visit.visitID = visits.size() + "";
        visit.location = location;
        visit.admissionRoom = admissionroom;
        visit.personResponsibleForAdmission = personresponsibleforadmission;
        visit.startDateTime = startdatetime;
        visit.endDateTime = enddatetime;
        visit.typeOfVisit = typeofvisit;
        visit.reasonForVisit = reasonforvisit;
        visit.symptoms = symptoms;
        visit.timeSinceSymptoms = timesincesymptoms;
        visit.qRCode = qrcode;
        visit.paymentMade = paymentmade;

        patientRepo.save(patient);

        return ActionResult.genActionResultByOk();
    }

    @RequestMapping(value = "addTimeLine", method = RequestMethod.GET)
    public ActionResult addTimeLine(@RequestParam String patientid,
                                    @RequestParam String visitid,
                                    @RequestParam String actiontype,
                                    @RequestParam String actionreason,
                                    @RequestParam String entrydatetime,
                                    @RequestParam String providername,
                                    @RequestParam String providertype,
                                    @RequestParam String locationroom,
                                    @RequestParam String locationbednumber,
                                    @RequestParam String details) {
        Patient patient = patientRepo.findByPatientId(patientid);
        if (patient == null)
            return ActionResult.genActionResult(ResultCode.NOT_EXIST);
        List<Visit> visits = patient.visits;
        Visit target = null;
        for (Visit visit : visits) {
            if (visit.visitID.equals(visitid)) {
                target = visit;
                break;
            }
        }
        if (target == null)
            return ActionResult.genActionResult(ResultCode.NOT_EXIST);
        if (target.timelines == null)
            target.timelines = new ArrayList<>();
        List<TimeLine> timeLines = target.timelines;
        TimeLine timeLine = new TimeLine();
        timeLines.add(timeLine);
        timeLine.actionID = timeLines.size() + "";
        timeLine.actionType = actiontype;
        timeLine.actionReason = actionreason;
        timeLine.entryDateTime = entrydatetime;
        timeLine.providerName = providername;
        timeLine.providerType = providertype;
        timeLine.locationRoom = locationroom;
        timeLine.locationBedNumber = locationbednumber;
        timeLine.details = details;

        patientRepo.save(patient);

        return ActionResult.genActionResultByOk();
    }
}
