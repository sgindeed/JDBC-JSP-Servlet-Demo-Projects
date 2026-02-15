package com.bank.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bank.bean.Hospital;
import com.bank.util.DBUtil;

public class HospitalDAO {

    public void addHospital(Hospital hospital) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "INSERT INTO Hospital (patientName, balance) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, hospital.getPatientName());
        ps.setDouble(2, hospital.getBalance());
        ps.executeUpdate();
        con.close();
    }

    public List<Hospital> getAllHospitals() throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT * FROM Hospital";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        List<Hospital> list = new ArrayList<>();

        while (rs.next()) {
            Hospital hosp = new Hospital(
                    rs.getInt("patientId"),
                    rs.getString("patientName"),
                    rs.getDouble("balance")
            );
            list.add(hosp);
        }

        con.close();
        return list;
    }

    public void updateHospital(Hospital hospital) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "UPDATE Hospital SET patientName=?, balance=? WHERE patientId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, hospital.getPatientName());
        ps.setDouble(2, hospital.getBalance());
        ps.setInt(3, hospital.getPatientId());
        ps.executeUpdate();
        con.close();
    }

    public void deleteHospital(int patientId) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "DELETE FROM Hospital WHERE patientId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, patientId);
        ps.executeUpdate();
        con.close();
    }
}