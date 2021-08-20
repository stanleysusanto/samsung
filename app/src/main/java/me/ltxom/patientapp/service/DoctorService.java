package me.ltxom.patientapp.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import java.util.List;

import me.ltxom.patientapp.entity.Doctor;
import me.ltxom.patientapp.util.RestUtil;

public class DoctorService {

    public List<LinkedTreeMap> listDoctors() {
        JsonObject jsonObject = RestUtil.sendGet(RestUtil.BASE_URL + "listDoctors");
        if (jsonObject.get("code").getAsInt() != 200) {
            return null;
        }
        Gson gson = new Gson();
        List<LinkedTreeMap> doctors = gson.fromJson(jsonObject.get("data"), List.class);
        return doctors;
    }

    public boolean addDoctor(String firstname,
                             String lastname,
                             String email,
                             String password) {
        JsonObject jsonObject = RestUtil.sendGet(RestUtil.BASE_URL + "addDoctor?&firstname=" + firstname + "&lastname=" + lastname + "&password=" + password + "&email=" + email);
        return jsonObject.get("code").getAsInt() == 200;
    }

}
