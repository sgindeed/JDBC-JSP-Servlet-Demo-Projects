package com.bank.service;

import java.util.List;

import com.bank.bean.Hospital;
import com.bank.dao.HospitalDAO;

public class HospitalService {

    HospitalDAO dao = new HospitalDAO();

    public void createHospital(String name, double balance) throws Exception {
        Hospital hospital = new Hospital(name, balance);
        dao.addHospital(hospital);
    }

    public List<Hospital> viewHospitals() throws Exception {
        return dao.getAllHospitals();
    }

    public void editHospital(int id, String name, double balance) throws Exception {
        Hospital hospital = new Hospital(id, name, balance);
        dao.updateHospital(hospital);
    }

    public void removeHospital(int id) throws Exception {
        dao.deleteHospital(id);
    }
}