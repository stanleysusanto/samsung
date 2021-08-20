package me.ltxom.patientapp.service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import androidx.annotation.RequiresApi;
import me.ltxom.patientapp.R;
import me.ltxom.patientapp.entity.Patient;
import me.ltxom.patientapp.util.RestUtil;

public class PatientService {

    public Patient findPatient(String patientid) {
        JsonObject jsonObject = RestUtil.sendGet(RestUtil.BASE_URL + "findPatient?patientid=" + patientid);
        Gson gson = new Gson();
        Patient patient = gson.fromJson(jsonObject.get("data"), Patient.class);
        return patient;
    }

    public List<LinkedTreeMap> listPatients() {
        JsonObject jsonObject = RestUtil.sendGet(RestUtil.BASE_URL + "listPatients");
        if (jsonObject.get("code").getAsInt() != 200) {
            return null;
        }
        Gson gson = new Gson();
        List<LinkedTreeMap> patientList = gson.fromJson(jsonObject.get("data"), List.class);
        return patientList;
    }

    public boolean removePatient(String patientid) {
        JsonObject jsonObject = RestUtil.sendGet(RestUtil.BASE_URL + "removePatient?patientid=" + patientid);
        return jsonObject.get("code").getAsInt() == 200;
    }

    //return patient id
    public String createProfile(String firstname,
                                String lastname,
                                String phone,
                                String email,
                                String icon) {
        JsonObject jsonObject = RestUtil.sendPost(RestUtil.BASE_URL + "updateProfile?firstname=" + firstname + "&lastname=" + lastname + "&phone=" + phone + "&email=" + email + "&icon=" + icon);
        return jsonObject.get("data").getAsString();
    }

    public boolean updateProfile(String patientid, String firstname,
                                 String lastname,
                                 String phone,
                                 String email, String icon) {
        JsonObject jsonObject = RestUtil.sendPost(RestUtil.BASE_URL + "updateProfile?patientid=" + patientid + "&firstname=" + firstname + "&lastname=" + lastname + "&phone=" + phone + "&email=" + email + "&icon=" + icon);
        return jsonObject.get("code").getAsInt() == 200;
    }

    public boolean saveAddress(String patientid,
                               String street1,
                               String street2,
                               String city, String state,
                               String zipcode) {
        JsonObject jsonObject = RestUtil.sendGet(RestUtil.BASE_URL + "saveAddress?patientid=" + patientid + "&street1=" + street1 + "&street2=" + street2 + "&city=" + city + "&state=" + state + "&zipcode=" + zipcode);
        return jsonObject.get("code").getAsInt() == 200;
    }

    public boolean saveInsurance(String patientid,
                                 String providername,
                                 String insuranceid,
                                 String plantype,
                                 String rxgroup) {
        JsonObject jsonObject = RestUtil.sendGet(RestUtil.BASE_URL + "saveInsurance?patientid=" + patientid + "&providername=" + providername + "&insuranceid=" + insuranceid + "&plantype=" + plantype + "&rxgroup=" + rxgroup);
        return jsonObject.get("code").getAsInt() == 200;
    }

    public boolean addVisit(String patientid,
                            String location,
                            String admissionroom,
                            String personresponsibleforadmission,
                            String startdatetime,
                            String enddatetime,
                            String typeofvisit,
                            String reasonforvisit,
                            String symptoms,
                            String timesincesymptoms,
                            String qrcode,
                            String paymentmade) {
        JsonObject jsonObject = RestUtil.sendGet(RestUtil.BASE_URL + "addVisit?patientid=" + patientid + "&location=" + location + "&admissionroom=" + admissionroom + "&personresponsibleforadmission=" + personresponsibleforadmission + "&startdatetime=" + startdatetime + "&enddatetime=" + enddatetime + "&typeofvisit=" + typeofvisit + "&reasonforvisit=" + reasonforvisit + "&symptoms" + symptoms + "&timesincesymptoms" + timesincesymptoms + "&qrcode" + qrcode + "&paymentmade=" + paymentmade);
        return jsonObject.get("code").getAsInt() == 200;
    }

    public boolean addTimeLine(String patientid,
                               String visitid,
                               String actiontype,
                               String actionreason,
                               String entrydatetime,
                               String providername,
                               String providertype,
                               String locationroom,
                               String locationbednumber,
                               String details) {
        JsonObject jsonObject = RestUtil.sendGet(RestUtil.BASE_URL + "addTimeLine?patientid=" + patientid + "&visitid=" + visitid + "&actiontype=" + actiontype + "&actionreason=" + actionreason + "&entrydatetime=" + entrydatetime + "&providername=" + providername + "&providertype=" + providertype + "&locationroom=" + locationroom + "&locationbednumber=" + locationbednumber + "&details=" + details);
        return jsonObject.get("code").getAsInt() == 200;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws IOException {
         //patientService.saveAddress(patientId, "S1", "S2", "C", "State", "zip");
        //patientService.saveInsurance(patientId, "Pname", "Id", "type", "group");
        //patientService.addVisit(patientId, "", "", "", "", "", "", "", "", "", "", "");
        //patientService.addTimeLine(patientId, "1", "", "", "", "", "", "", "", "");

        // Patient patient = patientService.findPatient("5dcfdd378fb4e30058d54308");

    }

}
